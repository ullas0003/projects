package program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

class Operation {
	int square(int n) {
		return n * n;
	}
}

public class Circle {
	 Operation op;// aggregation
	double pi = 3.14;

	double area(int radius) {
		op = new Operation();
		int rsquare = op.square(radius);// code reusability (i.e. delegates the method call).
		return pi * rsquare;
	}

	public static void main(String args[]) {
		Circle c = new Circle();
		double result = c.area(5);
		System.out.println(result);
	
		ArrayList<Integer> al = new ArrayList<>();
	
		al.add(2);
		al.add(3);
		al.add(2);
		al.add(5);
		
		//al.is
		
		LinkedHashSet<String> set = new LinkedHashSet<>();
		
		set.add("ullas");
		set.add("manu");
		set.add(null);
		
		
		ArrayList<String> al1 = new ArrayList<>();
		al1.add("ull");
		al1.add("cool");
		al1.add(null);
		
		 HashMap<Integer, String> map = new HashMap<Integer, String>();           
		   map.put(101,"Let us C");  
		   map.put(102, "Operating System");  
		   map.put(103, "Data Communication and Networking");  
		   //System.out.println("Values before remove: "+ map);    

		   
		   for (Map.Entry mm: map.entrySet()) {
			   
			   System.out.println(mm.getKey() + " =>"+ mm.getValue());
			   
			
		}
		
		
		
		Iterator<String> it = al1.iterator();
		
		while(it.hasNext()) {
			
			System.out.println(it.next());
			
		}
		
	}
	
	
	
	
	

}