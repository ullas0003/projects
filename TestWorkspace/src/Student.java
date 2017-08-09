
import java.io.Serializable;  

 class Student implements Serializable{  

	private static final long serialVersionUID = 1233L;
	int id;  
	String name;
	transient String value;
	public Student(int id, String name,String value) {  
		this.id = id;  
		this.name = name;
		this.value = value;
 }  
} 

