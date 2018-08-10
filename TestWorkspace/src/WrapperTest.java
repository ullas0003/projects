import java.sql.Wrapper;

public class WrapperTest {
	static Thread t = new Thread();
	public static void main(String[] args) {
		
		int n = 10;
		short d =  (short) n;
		//Integer.reverse(n);
		System.out.println(Integer.reverse(n));
		Boolean a = new Boolean("TRuE");
		System.out.println(a);
		float aa = (float) 10.5;
		char aaa = '1';
		Integer num = Integer.valueOf(10); //con pri to object
		int k = num.intValue(); // object to pri
		double kk = num.doubleValue(); // object to pri

		Character nu = Character.valueOf('s'); // same as Char ch = new Char();
		String.valueOf(num); // int to string;
		
		//string to int
		Integer n1 = Integer.valueOf("10");
		int nnn = Integer.parseInt("1000");
		long ll = nnn;
		
		WrapperTest ww = new WrapperTest();
		
		
		
		System.out.println(t== null);
		//int to string 
		String ss = Integer.toString(10);
		
		
		//autoboxing
		int val = 10;
		Integer valI = val; //conversion of pri to obj. Integer.valueOf(val);
		
		//auto un boxing
		Integer unbox = new Integer(11);
		int un = unbox; //conv of obj to pri unbox.intvalue()
		
		final String s = "ullas";
		//s ="fg";
		System.out.println(s.intern()); 
		
	}
	public void name() {
		
	}
}
