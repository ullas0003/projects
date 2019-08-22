package program;

import java.util.Arrays;

public class LargestInArray {
	
	public static int getLargest(int... arr) {
		
		int max = arr[0]; // first element is fixed..
		//int sec = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > max ) // for smallest check for less value
				max = arr[i];
		}
		return max;
	} 

	public static void main(String[] args) {
		
		System.out.println(LargestInArray.getLargest(new int[] {2,1,4,5}));
		
		int[] nums = {5,1,2,11,3}; //List or Vector
		Arrays.sort(nums); //Collections.sort() for List,Vector
		String a=Arrays.toString(nums); //toString the List or Vector
		String ar[]=a.substring(1,a.length()-1).split(", ");
		System.out.println(Arrays.toString(ar));

	}
	
}
