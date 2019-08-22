
class Animal {
	public static void name() {
		System.out.println("animal");
	}
}

class Cata extends Animal {
	public static void name() {
		System.out.println("cata");
	}
}

public class TestMethodHiding {

	// public void name() {
	//
	// }
	//
	// public int name() { // in same class same method name with diff return types
	// is C.E
	//
	// }

	
	public void name() {

	}

	public static void main(String[] args) {

		Animal a = new Cata();
		a.name();
	}

}

class TTT extends TestMethodHiding {

	public void name() {

	}

}

//
// class Check implements Runnable {
//
// @Override
// public void run() {
// System.out.println("cool");
//
// }
//
// }
//
// class TestRun {
//
// public static void main(String[] args) {
// Thread th = new Thread(new Check());
// th.start();
//
// }
// }