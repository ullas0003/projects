
 class MyThread extends Thread{
	 String name;
	
	 public MyThread(String name) {
		 
		 this.name = name;

	}
	/*public void start() {
		super.start();
		System.out.println("start method");
	}*/
	 
	 public void run() {
		
		/*for (int i = 0; i < 10; i++) {	
			System.out.println("child thread");
		}*/
		 
		 System.out.println("run method"+ Thread.currentThread().getName()+name);
	}

}

public class ThreadDemo {
	
	/**
	 * 
	 */

	//@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException {
		
		MyThread th = new MyThread("ullas");
		//th.join();

		//@SuppressWarnings("rawtypes")
		//List list = new ArrayList();
		//list.add("ullas");
		
		//String name =(String) list.get(0);
		th.start();
		//Xth.setPriority(3);
		//th.setName("kishan");
		//System.out.println("main method"+th.getName());
		//Thread.currentThread().setName("ullas");
		System.out.println("main method"+Thread.currentThread().getName()+Thread.NORM_PRIORITY+th.getPriority());
  		//System.out.println(10/0);
		/*int count=0;
		for (int i = 0; i < 10; i++) {
			count++; 
			System.out.println(count+"=>>>"+name);
			
		}*/
		
	/*	Thread t = new Thread(new  Runnable() {
			public void run() {
				System.err.println("inside runnable");
				
			}
		});
		
		t.start();*/
		
		
		
		
		
		
		
		
		
	}

}
