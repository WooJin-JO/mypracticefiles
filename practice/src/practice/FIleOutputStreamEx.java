package practice;

import java.io.*;

public class FIleOutputStreamEx {
	public static void main(String[] args) {
		byte b[] = {7, 51, 3, 4, -1, 24};
		
		try{
			FileOutputStream fout = new FileOutputStream("C:\\Project\\practice\\src\\practice\\c.out");
			for(int i = 0; i < b.length; i++){
				fout.write(b[i]);
			}
			fout.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		System.out.println("C:\\Project\\practice\\src\\practice\\c.out을 저장하였습니다.");
	}
}
