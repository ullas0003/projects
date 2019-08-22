import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileTest {
	public static void main(String[] args) throws IOException {

		File f = new File("abc.txt");
		//		File f = new File("/Users/ullas/Desktop/");
//		System.out.println(f.exists());
		f.createNewFile();
//		System.out.println(f.getAbsolutePath());
		// String name = (f.canRead()==true)?"asd":"asd";//ternary
//		System.out.println(f.exists());
		//f.mkdir();
		//System.out.println(f.length());
//		String[] files = f.list();
//		for (String file : files) {
//			System.out.println(file);
//		}
		//f.delete();
		//FileWriter fw = new FileWriter(f); //for override
		//		FileWriter fw = new FileWriter("fw.txt");

		//fw.write("hello ullas\n"); //for override
		//fw.close();
		
//		FileWriter fw = new FileWriter("cool.txt", true); //constructor for append -- use this 
//		fw.write("cool\n");
//		fw.flush(); //complete writing
//		fw.close();
		
		/*FileReader  fr = new FileReader("abc.txt");
		int i = fr.read();
		while (i != -1) {
			System.out.println((char)i);
				i = fr.read();
			
			
		}
		fr.close();*/
		
		//buffered writer 
//		BufferedWriter bw = new BufferedWriter(new FileWriter("abc.txt",true));
//		bw.newLine();
//		bw.write("helbwlo");
//		bw.newLine();
//		bw.write("hellbw");
//		bw.flush(); bw.close();
		
		//buffered Reader
//		
//		BufferedReader br = new BufferedReader(new FileReader("cool.txt"));
//		
//		String line = br.readLine();
//		while (line != null) {
//			System.out.println(br.readLine());
//			line = br.readLine();
//			
//		}
//		
//		br.close();
		
		/*PrintWriter pw = new PrintWriter("pw.txt");
		pw.write("dasdasd");
		pw.println("aok ddasd");
		pw.flush();
		pw.close();*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(br.readLine());
		
	}

}
