package program;

class Test{
	
	void clear(String o) {
		System.out.println("object");
	}
	
	
	void clear(Object s) {
		System.out.println("String");
	}
	
}

public class TestAuto {
	public static void main(String[] args) {
		
		new Test().clear(null);
		
	}
	

}
