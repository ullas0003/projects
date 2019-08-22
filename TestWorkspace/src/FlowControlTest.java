import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class FlowControlTest {
	
	int[] aaa = new int[10];

	public static void main(String[] args) {
		
		
		l1:{
		System.out.println("cool label");
		
	}

		boolean x = false;

		if(x=false)
			System.out.println("hello");
		else
			System.out.println("hi"); // x =false is false for if statement 

		//------------
		boolean y = false;

		if(y==false)
			System.out.println("hello"); // false == false is  true
		else
			System.out.println("hi"); 

		//------------

		//		if(x)
		//			int ta = 10; // no declarative staement in without curly braces
		//		
		//----

		//		if(x==false)
		//			if(x=false)
		//				System.out.println("cool");
		//			else
		//				System.out.println("dangling else"); // else is related to nearest if statement.


		//-----

		//SWITCH

		final int z = 3;

		switch (z) { // only bsic is allowed from 1.7 wrapperclasses similar BSIC ,string and enum is allowed
		case 1:
			System.out.println("swith 1");
			System.out.println("switch 1");
			break;
		case 2:
			System.out.println("switch 2");
			break;

		default:
			System.out.println("break");
			break;
		}
		//
		//		String[] s = "cool".split("");
		//		System.out.println(Arrays.toString(s));

		//System.out.println(File.separatorChar);

		//Integer a = Integer.parseInt("22");
		//	a.getClass().getConstructor(String.class);


		//		while (true) {
		//			System.out.println("cool");
		//		}


		int num =1;

		while(num < 10) {
			//	System.out.println(num+"  = cool");
			num++;

		}

		//		int val = 1;
		//		do {
		//
		//			System.out.println(val++);
		//			//val++;
		//
		//		} while (val < 10);

		//while(true); // valid

		//while(true) System.out.println("sad");

		//		do while(true)
		//			System.out.println("d");
		//		while(true); // valid

		//---- FOR LOOP

		//for(int i = 0;true;i++); // valid

		for(int h = 0; h < 10 ; ++h) {

			//System.out.println("cool =" +  h);


		}


		///-------FOREACH LOOP
		int[] arr = {12,13,43,545,545,66,6};

		for (int z1 : arr) {
			System.out.println(z1);

		}


		////-----ITERABLE

	//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(new FlowControlTest().aaa);
		
		//------BREAK CONTINUE
		
		
		// from durga study
		
		String name = "ullas";
		
		System.out.println(name.substring(1,2));

		final int aa = 10;
		
		//int ab = aa;
		
		;
		
		
	}
	
	
	



}
