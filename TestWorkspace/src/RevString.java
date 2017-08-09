import java.io.*;
import java.util.*;

public class RevString {
	public static void main(String[] args) {
		String input="";
		System.out.println("Enter the input string");
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			input = br.readLine();
			System.out.println(input);
			
			
			//System.out.println(input.substring(3,6));
			//case 1
			String s1 = "ullas";
			String s2 = "ullas";
			System.out.println(s1==s2);//reference comparison
			System.out.println(s1.equals(s2));//content comparison
			System.out.println("case 2");
			
			//case 2
			StringBuffer s3 = new StringBuffer("ullas");
			StringBuffer s4= new StringBuffer("ullas");
			System.out.println(s3==s4);//reference comparison
			System.out.println(s3.equals(s4));//reference comparison object equals
			//case 3
			System.out.printf("hello %s", s4);
			System.out.println("case 3");
			
			String s5 = "ullas";
			String s6 = new String("ullas");
			System.out.println(s5==s6);//reference comparison
			System.out.println(s5.equals(s6));//content comparison

			//case 4
			System.out.println("case 4");

			String s7 = new String("ullas");
			String s8= new String("ullas");
			System.out.println(s7==s8);//reference comparison
			System.out.println(s7.equals(s8));//content comparison string equals
			//input.concat("newtest");
			StringBuffer sb = new StringBuffer(input);
			System.out.println(sb.append("ullas").reverse() +" =>test");
			char[] try1= input.toCharArray();
			//System.out.println(try1[1]);

			String append = "";
			for (int i=try1.length-1;i>=0;i--){
					append = append + try1[i];
				//System.out.print(try1[i]);
			}
			System.out.println("apend===>>"+append);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
