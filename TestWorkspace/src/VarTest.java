public class VarTest {
	int x = 10;
	static String name = "ullas";

	public static  void  main(String[] args) {
		// static String name = "ullas"; //no static var in any block
		// name = "kishan"; any object can change field static val.
		// v.name= "kishan";
		arg(new int[]{'1'});
		 VarTest v = new VarTest();
		// v.x=12;
		System.out.println(VarTest.name);
		v.name();

	}

	public void name() {
		int x =0 ;
		System.out.println(x);
		System.out.println(name);
		arg(new int[]{'1'});

	}
	
	//var-args
	
	public static void arg(int... a){
		
		
	}
}
