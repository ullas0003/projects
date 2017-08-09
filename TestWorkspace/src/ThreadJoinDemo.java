
class Mythread11 implements Runnable{
	//static int x = 0;


	public void run() {

		for (int i = 0; i < 10; i++) {
			System.out.println("seetha thread");
			try {
				Thread.sleep(1000);
				//Thread.yeild();
			} catch (InterruptedException e) {}
		}
	}

}


public class ThreadJoinDemo {
	//static int x = 0;

	/*public  void  test(int... name){
		System.out.println(name[0]);
		
		ThreadJoinDemo ne = new ThreadJoinDemo();
		System.out.println(ne.x);


	}*/
	static final public synchronized strictfp void  main(String[] args) throws InterruptedException{
		//String s = new String(new char[]{'a'});
		//Mythread1 t1 = new Mythread1(); // while extending
		Mythread11 r = new Mythread11();
		Thread t1 = new Thread(r);		
		//ThreadJoinDemo n = new ThreadJoinDemo();
		//n.test(new int[]{1,2});
		//System.out.println(x);
		t1.start();	
		//Thread.yield();

		t1.join();

		for (int i = 0; i < 10; i++) {
			System.out.println("rama thread");
		}



	}

}


