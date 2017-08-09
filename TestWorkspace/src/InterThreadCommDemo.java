

class MyThreadA extends Thread{

	int count =0;

	public void run() {

		synchronized (this) {
			System.out.println("child thread starts calculator");
			for(int i = 1;i<=100;i++){
				count = count+ i;

			}
			
			System.out.println("child thread gives notification");
			this.notify();
		}

	}

}




public class InterThreadCommDemo {


	public static void main(String[] args) throws InterruptedException {
		
		MyThreadA b = new MyThreadA();
		b.start();
		//Thread.sleep(10000);
		synchronized (b) {
			System.out.println("main thread trying to call wait");
			b.wait(10000);
			System.out.println("main thread got notify ");
			System.out.println(b.count);
		}

	}
}
