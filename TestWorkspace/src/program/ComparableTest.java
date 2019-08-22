package program;

import java.util.ArrayList;
import java.util.Collections;

class CompTest implements Comparable<CompTest> {

	int age;
	String name;

	public CompTest(int age, String name) {
		//super();
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(CompTest o) {

		if (age > o.age)
			return 1;
		if (age < o.age)
			return -1;

		return 0;
	}

}

public class ComparableTest {

	public static void main(String[] args) {

		CompTest com = new CompTest(19, "ullas");
		CompTest com1 = new CompTest(18, "kishan");

		ArrayList<CompTest> al = new ArrayList<>();

		al.add(com);
		al.add(com1);

		Collections.sort(al);
		
		//Collections.sort(list, new com);
		
		System.out.println(al);
		
		for (CompTest compTest : al) {
			System.out.println(compTest.age + " =>" + compTest.name);
			
			
		}

	}

}