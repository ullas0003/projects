
class Display{
	public static int  c;
	//boolean ob = false;
	public   void  wish(String name){

		synchronized (this) {

			for (int i = 0; i < 4; i++) {
				System.out.print("good morning: ");
				//if(ob==true)return;
				try {
					Thread.sleep(2000);

				} catch (InterruptedException e) {}
				System.out.println(name);
			}

		}
	}

} 
class Mythread3 implements Runnable{  //extends Thread
	
	String name ;
	Display d ;

	Mythread3(Display d,String name ) {
		this.d = d;
		this.name = name;

	}
	public void run() {
		d.wish(name);

	}

}



public class SynchronizedDemo {
	public static void main(String[] args)  {
		Display d = new Display();	
		Mythread3 t1 = new Mythread3(d,"ullas");
		Mythread3 t2 = new Mythread3(d,"rogue");
		
		Thread tt1 = new Thread(t1);
		Thread tt2 = new Thread(t2);
		
		tt1.start();
		tt2.start();
		
		//t1.start();
		//t2.start();
		//System.in.read();
		//		d.ob=true;
		
//		Thread t1 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				d.wish("ullas");
//				
//			}
//		});
//		t1.start();
//		
//		
//		
//Thread t2 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				d.wish("rogUe");
//				
//			}
//		});
//		t2.start();
//		
//
	}
		
}
