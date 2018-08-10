
public class ShallowCloning {
	public static void main(String[] args) throws CloneNotSupportedException {
		Cat c = new Cat(20);
		Dog d1 = new Dog(c, 10); 

		Dog d2 = (Dog) d1.clone();
		System.out.println(d1.i +" .. "+ d1.c.j);

		d2.i = 888;
		d2.c.j = 99;

		System.out.println(d1.i +" .. "+ d1.c.j);

	}

}

class Cat {
	int j;

	public Cat(int j) {
		this.j = j;

	}

}

class Dog implements Cloneable {
	int i;
	Cat c;

	public Dog(Cat c, int i) {
		this.i = i;
		this.c = c;

	}

	public Object clone() throws CloneNotSupportedException {
		//return super.clone(); // shallow cloning

		//deep cloning
		Cat c1 = new Cat(this.c.j);
		Dog d = new Dog(c1, this.i);
		return d;


	}

}
