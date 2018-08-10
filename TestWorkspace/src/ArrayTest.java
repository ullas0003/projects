import java.lang.reflect.Method;

public class ArrayTest {
	public static  void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		int[][] a1 = new int[6][6];
		int[] a = new int[] {1,2}; //init and dec and creat
		int[] b =  {1,2};
		int[][] ab =  new int[][] {{1,2},{1,2}};
		a[0] = 4;
		int[] c =b;
		System.out.println(a[0]);
		System.out.println(b.length);
		Number[] n = new Number[4];
		n[0] = new Integer(10);
		System.out.println(n[0]);
		Object[] name = null ;
		String[] n1 = (String[]) name; 
		System.out.println(Float.MAX_VALUE +"==="+ Float.MIN_VALUE);
		System.out.println(Double.MAX_VALUE +"==="+ Double.MIN_VALUE);

	}

}
