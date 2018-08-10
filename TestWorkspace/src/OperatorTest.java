import java.awt.List;
import java.util.Arrays;
import java.util.Iterator;

public class OperatorTest implements Cloneable {
	public static void main(String[] args) {

		// C.E max(int,var 1 ,var 2)
		// byte a = 10;
		// byte b = 20;
		// byte = a+b; (int) (a+b) same as b++

		boolean f = 10 != Float.NaN; // true , rest is false
		String val = 10 + "";
		// boolean ff = 10 < 20 < 99; C:E
		// System.out.println(false == false);
		// System.out.println(97 == 97.0);
		String s = "ullab";
		byte[] bb = s.getBytes();
		for (byte b : bb) {
			// System.out.println(b);
		}

		System.out.println(10 / 0.0); // infinity

		// System.out.println(true > false); CE

		OperatorTest op = new OperatorTest();
		// OperatorTest op1 = (OperatorTest) op.clone();
		OperatorTest op1 = op;
		// System.out.println(op == op1);
		// System.out.println(null == null); // is always true
		Object obj = new Object();

		String ss = new String();
		Object ooo = op;
		// System.out.println(ooo instanceof OperatorTest); // is always true
		// obj = ss;
		// ss = (String) obj;

		// if (true ^ false) {
		// System.out.println("cool");
		// }

		// System.out.println(true ^ false); xor is true.
		// System.out.println(ooo instanceof String);//false no parent to child

		// int x = 0,ff = 99,fs = 130;
		byte b = (byte) x;
		System.out.println(b); // 126 loss of info

		// simple assignment operator
		int xx = 10;
		// chained assignment operator
		int gg, dff, sd, sdds = 10;
		// coumpound assignment operator
		gg += 10;

		// int a =b=c =20; //ce no chained assignment directly in declaration
		int a, bd, c;
		a = bd = c = 10;

		//int asd =10,ewe = 20; //works
		//int yy,asds; //works





	}

}
