

public class ReverseTest {
	public static void main(String[] args) {
		Integer num = 123456;
		String name = num.toString() ;
		//String name =  "ullas the great";
		//System.out.println(name.length());
		int i;
		//	char n ;
		String result="";
		for(i=0;i<name.length();i++){
			  result= name.charAt(i)+result;
				 //System.out.println(result);

		}
		 System.out.println(result);

	}
}
