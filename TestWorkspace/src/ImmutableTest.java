
public final class ImmutableTest {
	private int age;

	public ImmutableTest(int age) {

		this.age = age;

	}

	public ImmutableTest modify(int age1) {
		if (this.age == age1) {
			return this;
		} else {
			return (new ImmutableTest(age1));
		}
	}

	public static void main(String[] args) {
		char[] d = "ullas".toCharArray();
		char aa = 'a';
		int[] aaa = new int[4];
		Thread th = new Thread();
		System.out.println(aaa.getClass().getName());
		float a = 10_11F;
		long b = 10L;
		double c = 10.555D;
		ImmutableTest s1 = new ImmutableTest(23);
		// s1 = new ImmutableTest(22);
		System.out.println(s1.age);
		// ImmutableTest s2 = new ImmutableTest("kishan", 22);

		ImmutableTest s2 = s1.modify(24);// method for immutability
		System.out.println(s1 == s2);
	}

}
