import java.lang.reflect.Field;
public class Test {

    int x;
    int y;  

    public void getClassName(){
        String className = this.getClass().getSimpleName(); 
        System.out.println("class Name:"+className);
    }

    public void getAttributes(){
        Field[] Attributes = this.getClass().getDeclaredFields();   
        for(int i=0;i<Attributes.length;i++){
            System.out.println("Declared Fields"+Attributes[i]);    
        }

    }
    public static void main(String args[]){

        Test t = new Test();
        t.getClassName();
        t.getAttributes();
        int c = 0;
        while(c<=2){
        	System.out.println("hello");
        	c ++;
        }
        System.out.println(c+"sad");
    }

}