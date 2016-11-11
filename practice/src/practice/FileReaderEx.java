package practice;

import java.io.*;

public class FileReaderEx {
	public static void main(String[] args) {
		FileReader in = null;
		try{
			in = new FileReader("C:\\Project\\practice\\src\\practice\\a.txt");
			int c;
			while((c = in.read()) != -1){
				System.out.print((char)c);
			}
			in.close();
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
}
