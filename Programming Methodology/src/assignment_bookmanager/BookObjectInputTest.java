package assignment_bookmanager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class BookObjectInputTest{

	public static void main(String[] args) {
		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try{
			fin = new FileInputStream("booklist.dat");
			ois = new ObjectInputStream(fin);
			
			ArrayList<Book> list = (ArrayList<Book>)ois.readObject();
			Book b1 = (Book)list.get(0);
			Book b2 = (Book)list.get(1);
			Book b3 = (Book)list.get(2);
			Book b4 = (Book)list.get(3);
			Book b5 = (Book)list.get(4);
			Book b6 = (Book)list.get(5);
			Book b7 = (Book)list.get(6);
			Book b8 = (Book)list.get(7);
			Book b9 = (Book)list.get(8);
			Book b10 = (Book)list.get(9);
			Book b11 = (Book)list.get(10);
			Book b12 = (Book)list.get(11);
			Book b13 = (Book)list.get(12);
			Book b14 = (Book)list.get(13);
			Book b15 = (Book)list.get(14);
			Book b16 = (Book)list.get(15);
			Book b17 = (Book)list.get(16);
			Book b18 = (Book)list.get(17);
			Book b19 = (Book)list.get(18);
			Book b20 = (Book)list.get(19);
			
			System.out.println(b1.toString());
			System.out.println(b2.toString());
			System.out.println(b3.toString());
			System.out.println(b4.toString());
			System.out.println(b5.toString());
			System.out.println(b6.toString());
			System.out.println(b7.toString());
			System.out.println(b8.toString());
			System.out.println(b9.toString());
			System.out.println(b10.toString());
			System.out.println(b11.toString());
			System.out.println(b12.toString());
			System.out.println(b13.toString());
			System.out.println(b14.toString());
			System.out.println(b15.toString());
			System.out.println(b16.toString());
			System.out.println(b17.toString());
			System.out.println(b18.toString());
			System.out.println(b19.toString());
			System.out.println(b20.toString());
			
		}catch(Exception ex){
		}finally{
			try{
				ois.close();
				fin.close();
			}catch(IOException ioe){}
		} // finally
	} // main end
} // class end