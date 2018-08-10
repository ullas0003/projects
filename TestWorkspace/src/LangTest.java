import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class LangTest {
	int x = 0;
	String[] s = { "ullas", "bharath" };

	public static void main(String[] args) throws ClassNotFoundException {

		Class o = Class.forName("java.lang.Object");
		Method[] m = o.getDeclaredMethods();
		Field[] f = o.getDeclaredFields();

		int count = 0;
		for (Method method : m) {
			System.out.println(method.getName() + ":" + ++count);
		}
		LangTest lt = new LangTest();
		// main(new String[]{"ullas"});
		//
		ArrayList<String> al = new ArrayList<>();
		al.add("ullas");

		System.out.println(Arrays.toString(al.toArray()));
		System.out.println(Arrays.toString(lt.s));
		System.out.println(lt.getClass().getName());
		System.out.println(lt.hashCode()); // to string override

	}

	public String toString() {
		return "ullas";

	}

	public String name() {
		return getClass().getName() + Integer.toHexString(hashCode());

	}
}
