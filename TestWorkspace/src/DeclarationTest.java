import java.io.Serializable;

abstract strictfp class Vehicle {

	abstract public void getName(); // abs and strictfp for method invalid

	private static final void name() {
		int x;

	}; // abs class may contain abstract methods or all concrete class.

}

public class DeclarationTest {
	final int x; // final instance var , provide value implicitly

	{
		x = 10;
	}
	// strictfp ll = 10.000;

	public void nam() {

	}

}

class TT extends DeclarationTest  {
	
	int i = 0;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TT other = (TT) obj;
		if (i != other.i)
			return false;
		return true;
	}

	public int namee(int i) {
		return i;

	}

	public void namee(int i, int j) {

	}
	public static void main(String[] args) {
		
		DeclarationTest dd = new DeclarationTest();
		
		
		
	}

}