package program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CheckBigValueArray {

	Object o = new Object();
	String s;
	public static void main(String[] args) {

		CheckBigValueArray ch = new CheckBigValueArray();
		
		ch.o  = ch.s;
		ch.s = (String) ch.o;
		
		Map<String, String> map = new LinkedHashMap<>();
		
		map.put(null, "coll");
		map.put(null, null);
		map.put("test", null);
		map.put("coll", "cs");
		
		List<String> ls =  new ArrayList<>(map.keySet());
		
		for (String string : ls) {
			System.out.println(map.get(string));
		}
		
		System.out.println(map);
		
		



	}	


}





