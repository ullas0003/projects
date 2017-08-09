class A{

	public synchronized void d1(B b){

		System.out.println("thread 1 starts execution of d1");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread t1 trying to call b last");
		b.last();
	}

	public synchronized void last(){
		System.out.println("inside A this is last method");
	}


}

class B{

	public synchronized void d2(A a){

		System.out.println("thread 2 starts execution of d2");
		try {

			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread 2 trying to call a last");
			a.last();
	}


	public synchronized void last(){
		System.out.println("inside  B this is last method");
	}
}

class DeadLockDemo extends Thread{
	
	A a = new A();
	B b = new B();

	public void m1(){
		this.start();
		a.d1(b);//main thread

	}

	public void run() {
		b.d2(a);//td thread

	}


	public static void main(String[] args) {
		DeadLockDemo td = new DeadLockDemo();//for runnable use constructor DeadLockDemo td = new DeadLockDemo(a,b);
		td.m1();


	}
}
