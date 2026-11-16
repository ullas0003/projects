#!/bin/bash
# ==============================================================================
#  Kubernetes cluster setup using kubeadm (Ubuntu 20.04+)
#
#  Usage:
#     ./cluster_setup_using_kubeadm_new.sh master    # control-plane node
#     ./cluster_setup_using_kubeadm_new.sh worker    # worker node
#
#  Run as a normal user with sudo access (e.g. ubuntu), NOT as root.
# ==============================================================================

set -euo pipefail          # stop on any error

NODE_TYPE="${1:-}"
K8S_VERSION="v1.36"
CALICO_VERSION="v3.30.2"
STERN_VERSION="1.24.0"
POD_CIDR="192.168.0.0/16"
ARCH="$(dpkg --print-architecture)"     # amd64 or arm64


# ------------------------------------------------------------------------------
#  Helper functions
# ------------------------------------------------------------------------------
step() {
    echo
    echo "===================================================================="
    echo "  $1"
    echo "===================================================================="
}

usage() {
    echo "Usage: curl -s <script-url> | bash -s master|worker"
    echo "  master : min 2 CPU, 2 GB RAM"
    echo "  worker : any size"
    exit 1
}


# ------------------------------------------------------------------------------
#  Step 1 : Disable swap and enable kernel networking
# ------------------------------------------------------------------------------
prepare_node() {
    step "Step 1 : Disable swap & load kernel modules"

    # kubelet does not run with swap ON
    sudo swapoff -a
    sudo sed -i '/ swap / s/^/#/' /etc/fstab

    # Modules needed by container networking
    sudo tee /etc/modules-load.d/k8s.conf > /dev/null <<EOF
overlay
br_netfilter
EOF
    sudo modprobe overlay
    sudo modprobe br_netfilter

    # Allow bridged traffic and IP forwarding
    sudo tee /etc/sysctl.d/k8s.conf > /dev/null <<EOF
net.bridge.bridge-nf-call-iptables  = 1
net.bridge.bridge-nf-call-ip6tables = 1
net.ipv4.ip_forward                 = 1
EOF
    sudo sysctl --system > /dev/null
}


# ------------------------------------------------------------------------------
#  Step 2 : Install containerd (container runtime)
# ------------------------------------------------------------------------------
install_containerd() {
    step "Step 2 : Install containerd"

    sudo apt-get update -y
    sudo apt-get install -y ca-certificates curl gpg apt-transport-https

    # Docker repo provides the containerd.io package
    sudo install -m 0755 -d /etc/apt/keyrings
    curl -fsSL https://download.docker.com/linux/ubuntu/gpg \
        | sudo gpg --dearmor --batch --yes -o /etc/apt/keyrings/docker.gpg
    echo "deb [arch=$ARCH signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" \
        | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null

    sudo apt-get update -y
    sudo apt-get install -y containerd.io

    # Use systemd cgroup driver (same as kubelet)
    containerd config default | sudo tee /etc/containerd/config.toml > /dev/null
    sudo sed -i 's/SystemdCgroup = false/SystemdCgroup = true/' /etc/containerd/config.toml

    sudo systemctl restart containerd
    sudo systemctl enable containerd
}


# ------------------------------------------------------------------------------
#  Step 3 : Install kubeadm, kubelet, kubectl
# ------------------------------------------------------------------------------
install_kubernetes() {
    step "Step 3 : Install kubeadm, kubelet, kubectl ($K8S_VERSION)"

    curl -fsSL "https://pkgs.k8s.io/core:/stable:/$K8S_VERSION/deb/Release.key" \
        | sudo gpg --dearmor --batch --yes -o /etc/apt/keyrings/kubernetes.gpg
    echo "deb [signed-by=/etc/apt/keyrings/kubernetes.gpg] https://pkgs.k8s.io/core:/stable:/$K8S_VERSION/deb/ /" \
        | sudo tee /etc/apt/sources.list.d/kubernetes.list > /dev/null

    sudo apt-get update -y
    sudo apt-get install -y kubelet kubeadm kubectl
    sudo apt-mark hold kubelet kubeadm kubectl      # stop accidental upgrades
    sudo systemctl enable kubelet
}


# ------------------------------------------------------------------------------
#  Step 4 : Install helper tools (stern, kubectx, kubens)
# ------------------------------------------------------------------------------
install_tools() {
    step "Step 4 : Install stern, kubectx, kubens"

    curl -fsSL -o /tmp/stern.tar.gz \
        "https://github.com/stern/stern/releases/download/v${STERN_VERSION}/stern_${STERN_VERSION}_linux_${ARCH}.tar.gz"
    tar -xzf /tmp/stern.tar.gz -C /tmp stern
    sudo mv /tmp/stern /usr/local/bin/

    sudo apt-get install -y kubectx
}


# ------------------------------------------------------------------------------
#  Step 5 (master) : Create the cluster
# ------------------------------------------------------------------------------
setup_master() {
    step "Step 5 : Initialize control-plane"
    sudo kubeadm init --pod-network-cidr="$POD_CIDR"

    step "Step 6 : Configure kubectl for $USER"
    mkdir -p "$HOME/.kube"
    sudo cp -f /etc/kubernetes/admin.conf "$HOME/.kube/config"
    sudo chown "$(id -u):$(id -g)" "$HOME/.kube/config"

    step "Step 7 : Install Calico network plugin ($CALICO_VERSION)"
    kubectl apply -f "https://raw.githubusercontent.com/projectcalico/calico/$CALICO_VERSION/manifests/calico.yaml"

    step "Step 8 : Wait for node to be Ready"
    kubectl wait --for=condition=Ready node --all --timeout=300s || true
    kubectl get nodes -o wide

    step "Run this command on each WORKER node (with sudo)"
    sudo kubeadm token create --print-join-command
    echo
    echo "Lost it? Run again on master:  sudo kubeadm token create --print-join-command"
}


# ------------------------------------------------------------------------------
#  Worker : Remove old cluster setup (if node was joined before)
# ------------------------------------------------------------------------------
reset_worker() {
    step "Old Kubernetes setup found on this node -> cleaning it"

    sudo kubeadm reset -f                        # remove old certs & configs
    sudo systemctl stop kubelet                  # free port 10250
    sudo rm -rf /etc/cni/net.d /var/lib/cni      # old network config
    sudo iptables -F && sudo iptables -t nat -F  # old network rules
    sudo iptables -t mangle -F && sudo iptables -X
    sudo systemctl restart containerd

    echo "  Cleanup done. Node is ready to join again."
}


# ------------------------------------------------------------------------------
#  Step 5 (worker) : Next steps
# ------------------------------------------------------------------------------
setup_worker() {
    step "Step 5 : Join this worker to the cluster"
    echo "  Before joining:"
    echo "    1. Security group (master & workers) must allow:"
    echo "         6443      -> kube-apiserver (workers talk to master)"
    echo "         10250     -> kubelet API    (logs, exec, metrics)"
    echo "         179       -> Calico BGP     (pod routes between nodes)"
    echo "         IP-in-IP  -> Calico traffic (protocol 4, pod-to-pod)"
    echo "    2. On MASTER run:  sudo kubeadm token create --print-join-command"
    echo "    3. Copy that full 'kubeadm join ...' line"
    echo

    # Read from /dev/tty because stdin is the script when using 'curl | bash'
    # (no -r, so a 2-line command ending with '\' is also accepted)
    JOIN_CMD=""
    read -p "  Paste join command (or press Enter to skip): " JOIN_CMD < /dev/tty || true

    JOIN_CMD="${JOIN_CMD#sudo }"            # remove 'sudo' if pasted

    if [[ -z "$JOIN_CMD" ]]; then
        echo "  Skipped. Run the join command later with sudo."
        return
    fi

    if [[ "$JOIN_CMD" != kubeadm\ join* ]]; then
        echo "  This is not a 'kubeadm join' command. Run it manually later."
        return
    fi

    # Joined before? Clean old setup so the join does not fail
    if [[ -f /etc/kubernetes/kubelet.conf || -f /etc/kubernetes/pki/ca.crt ]]; then
        reset_worker
    fi

    step "Step 6 : Joining the cluster"
    if sudo bash -c "$JOIN_CMD"; then
        echo
        echo "  Worker joined. On MASTER run:  kubectl get nodes"
    else
        echo
        echo "  Join failed. Check:"
        echo "    - Port 6443 open on master  ->  nc -zv <master-ip> 6443"
        echo "    - Token expired?            ->  on MASTER run:"
        echo "                                    sudo kubeadm token create --print-join-command"
        echo "    - Re-run this script        ->  it cleans the old setup automatically"
    fi
}


# ------------------------------------------------------------------------------
#  Main
# ------------------------------------------------------------------------------
[[ "$NODE_TYPE" == "master" || "$NODE_TYPE" == "worker" ]] || usage

prepare_node
install_containerd
install_kubernetes
install_tools

if [[ "$NODE_TYPE" == "master" ]]; then
    setup_master
else
    setup_worker
fi

step "Done : $NODE_TYPE node setup completed"
