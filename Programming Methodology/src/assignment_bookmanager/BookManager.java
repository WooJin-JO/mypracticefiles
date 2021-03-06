package assignment_bookmanager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BookManager {
	Scanner s = new Scanner(System.in);
	ArrayList<Book> books = new ArrayList<>();

	void save(){
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
	}

	void load(){
		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try{
			fin = new FileInputStream("booklist.dat");
			ois = new ObjectInputStream(fin);

			@SuppressWarnings("unchecked")
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
			
			for(int i = 0; i < list.size(); i++){
				books.add((Book)list.get(i));
			}

		}catch(Exception ex){
		}finally{
			try{
				ois.close();
				fin.close();
			}catch(IOException ioe){}
		}
	}

	void searchAuthor(){
		System.out.print("검색하실 저자명을 입력해 주세요.  ");
		String aut = s.next();
		for(int i = 0; i < books.size(); i++){
			if(books.get(i).getAuthor().equals(aut)){
				System.out.println(books.get(i).toString());
			}
		}
	}

	void searchPrice(){
		System.out.print("검색하실 금액을 입력해 주세요.(입력 금액 이하의 책을 검색합니다.)  ");
		int pri = s.nextInt();
		for(int i = 0; i < books.size(); i++){
			if(books.get(i).getPrice() <= pri){
				System.out.println(books.get(i).toString());
			}
		}
	}

	void searchPublisher(){
		System.out.print("검색하실 출판사를 입력해 주세요.  ");
		String publish = s.next();
		for(int i = 0; i < books.size(); i++){
			if(books.get(i).getPublisher().equals(publish)){
				System.out.println(books.get(i).toString());
			}
		}
	}

	void searchISBN(){
		System.out.print("검색하실 ISBN을 입력해 주세요.  ");
		String isbn = s.next();
		for(int i = 0; i < books.size(); i++){
			if(books.get(i).getIsbn().equals(isbn)){
				System.out.println(books.get(i).toString());
			}
		}
	}

	void searchPubyear(){
		System.out.print("검색하실 출판년도를 입력해 주세요.(입력하신 연도 이전에 출시된 책을 검색합니다.)  ");
		int year = s.nextInt();
		for(int i = 0; i < books.size(); i++){
			if(books.get(i).getPubyear() <= year){
				System.out.println(books.get(i).toString());
			}
		}
	}

	void searchPoint(){
		System.out.print("검색하실 인기도를 입력해 주세요.(입력하신 인기도 이상의 책을 검색합니다.)  ");
		int poin = s.nextInt();
		for(int i = 0; i < books.size(); i++){
			if(books.get(i).getPoint() >= poin){
				System.out.println(books.get(i).toString());
			}
		}
	}
	
	void start(){
		boolean go = true;
		while(go){
			System.out.print("1) 도서목록   2)도서검색   3)종료   ");
			int select = s.nextInt();
			switch(select){
			case 1:
				save();
				load();
				break;
			case 2:
				System.out.println("검색 방법을 선택해주세요");
				System.out.print("1) 저자명  2)단가  3)출판사  4)isbn  5)출판년도  6)인기도    ");
				int choice = s.nextInt();
				switch(choice){
				case 1 :
					searchAuthor();
					break;
				case 2 :
					searchPrice();
					break;
				case 3 :
					searchPublisher();
					break;
				case 4 :
					searchISBN();
					break;
				case 5 :
					searchPubyear();
					break;
				case 6 :
					searchPoint();
					break;
				}
				break;
			case 3:
				System.out.println("종료합니다.");
				go = false;
				break;
			}
		}
	}
	public static void main(String[] args) {
		BookManager t = new BookManager();
		t.start();
	}
}
