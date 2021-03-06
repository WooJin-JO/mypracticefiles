package assignment_bookmanager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BookObjectOutputTest{

	public static void main(String[] args) {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		ArrayList<Book> list = new ArrayList<>();
		Book b1 = new Book("a0001", "자바완성", "홍길동", 10000, 1999, "han", 10);
		Book b2 = new Book("a0002", "스트럿츠", "김유신", 20000, 1999, "yang", 9);
		Book b3 = new Book("a0003", "기초 EJB", "김성박", 25000, 2000, "dea", 8);
		Book b4 = new Book("a0004", "한글", "안기하", 20000, 2010, "hak", 4);
		Book b5 = new Book("a0005", "가나다", "솜브라", 35000, 2002, "han", 2);
		Book b6 = new Book("a0006", "abc", "라인하", 29000, 2003, "yang", 5);
		Book b7 = new Book("a0007", "qwerty", "르트", 42000, 2011, "dea", 6);
		Book b8 = new Book("a0008", "asdfg", "한조", 29600, 2012, "hak", 7);
		Book b9 = new Book("a0009", "zxcvb", "위도우", 15000, 2005, "han", 2);
		Book b10 = new Book("a0010", "초급", "메아커", 55000, 2004, "yang", 3);
		Book b11 = new Book("a0011", "중급", "메이코", 66000, 2009, "dea", 5);
		Book b12 = new Book("a0012", "고급", "패스", 28500, 2008, "hak", 7);
		Book b13 = new Book("a0013", "이클립스", "김병장", 29000, 2010, "han", 8);
		Book b14 = new Book("a0014", "서브라임", "토르비욘", 35000, 2004, "yang", 9);
		Book b15 = new Book("a0015", "가가가", "슬랙", 25800, 2016, "dea", 4);
		Book b16 = new Book("a0016", "비쥬얼", "카카오", 12000, 2015, "hak", 3);
		Book b17 = new Book("a0017", "스튜디오", "어도비", 31000, 2011, "han", 5);
		Book b18 = new Book("a0018", "C언어", "네이벙", 52000, 2013, "yang", 6);
		Book b19 = new Book("a0019", "JAVA", "다응", 19000, 2001, "dea", 7);
		Book b20 = new Book("a0020", "Python", "국글", 26000, 2010, "hak", 7);
		
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		list.add(b5);
		list.add(b6);
		list.add(b7);
		list.add(b8);
		list.add(b9);
		list.add(b10);
		list.add(b11);
		list.add(b12);
		list.add(b13);
		list.add(b14);
		list.add(b15);
		list.add(b16);
		list.add(b17);
		list.add(b18);
		list.add(b19);
		list.add(b20);
		 
		try{
			fout = new FileOutputStream("booklist.dat");
			oos = new ObjectOutputStream(fout);
			
			oos.writeObject(list);
			oos.reset();
			
		}catch(Exception ex){
		}finally{
			try{
				oos.close();
				fout.close();
			}catch(IOException ioe){}
		} // finally
	} // main end
} // class end
