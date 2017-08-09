
class Display{
	//boolean ob = false;
	public   void  wish(String name){

		synchronized (this) {

			for (int i = 0; i < 10; i++) {
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
class Mythread3 extends Thread{

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

		t1.start();
		t2.start();
		//System.in.read();
		//		d.ob=true;

	}
}
