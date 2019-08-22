
interface TestProvider  {
	
	static final int c =10;
	public void name();
	//static void name1();
	public void test(); // not impl , hence class below is abstract
}

public abstract class InterfaceTest implements TestProvider {
	InterfaceTest tt ;

	abstract void getName();
	@Override
	public void test() {
		// TODO Auto-generated method stub

	}
	
	
	private void test(int i) {
		// TODO Auto-generated method stub

	}
	public static void main(String[] args) {
		//int c = 10; local var
		System.out.println(TestProvider.c);
		
	}

}

 class Prov extends InterfaceTest{
	
	@Override
	public void name() {
		
	}

	@Override
	void getName() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

final class NN extends InterfaceTest{

	@Override
	public void name() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void getName() {
		// TODO Auto-generated method stub
		
	}
	
}