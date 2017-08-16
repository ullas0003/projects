
public class Expo {
	
	public static void main(String[] args) {
		final int base = 5;
		int n =4;
		for (int i = 1; i < n; i++) {
			if (i%2==0){
				System.out.println(Math.pow(base, i)+base);
			}else{
				System.out.println(Math.pow(base, i));
			}
		}	
	}
}
