

class Name{
	
	private void name() {
		System.out.println("ullas");
	}
}
public class TestPrivate {

	public static void main(String[] args) {
		new Name(); // cant access private method in this class
	}
}
