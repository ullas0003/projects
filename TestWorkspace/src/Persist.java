import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Persist{  
	 public static void main(String args[])throws Exception{  
	  Student s1 =new Student(211,"ullas","VALUE");  
	  
	  //FileOutputStream fout=new FileOutputStream("f.txt");  
	  ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("f.txt"));  
	  
	  out.writeObject(s1);  
	  out.flush();
	  out.close();
	  System.out.println("success"+s1.id);  
	  
	  //ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("f.txt"));
	  
	  
	 }  
	}  