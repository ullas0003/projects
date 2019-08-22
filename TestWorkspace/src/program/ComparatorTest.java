package program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student {

	int age;

	String name;

	public Student(int age, String name) {
		// super();
		this.age = age;
		this.name = name;
	}

}

class NameComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {

		return o1.name.compareTo(o2.name);
	}

}

public class ComparatorTest {

	public static void main(String[] args) {

		ArrayList<Student> al = new ArrayList<>();
		al.add(new Student(101, "Vijay"));
		al.add(new Student(106, "Ajay"));
		al.add(new Student(105, "Jai"));

		Collections.sort(al, new NameComparator());

		for (Student student : al) {

			System.out.println(student.age + " ===>> " + student.name);
		}
		
		

	}

}
