package practice;

import java.io.*;
import java.util.*;

public class AddFriend {
	Scanner s = new Scanner(System.in);
	ArrayList<AddFriend> friend = new ArrayList<>();
	String name;
	String phonenum;
	String address;
	int choice;
	public AddFriend(String n, String p, String a){
		this.name = n;
		this.phonenum = p;
		this.address = a;
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	void add(){
		System.out.println("이름 ==>");
		setName(s.next());
		System.out.println("전화번호 ==>");
		setPhonenum(s.next());
		System.out.println("주소 ==>");
		setAddress(s.next());
		AddFriend fri = new AddFriend(getName(), getPhonenum(), getAddress());
		friend.add(fri);
		System.out.println("친구 " + friend.size() + "명을 등록하였습니다.");
	}
	void showAll(){
		for(int i = 0; i < friend.size(); i++){
			System.out.println(friend.get(i).getName() + "	" + friend.get(i).getPhonenum() + "	" + friend.get(i).getAddress());
		}
	}
	void save(){
		FileWriter fw = null;
		try{
			fw = new FileWriter("C:\\Project\\practice\\src\\practice\\AddFriend.txt");
			for(int i = 0; i < friend.size(); i++){
				fw.write(friend.get(i).getName() + "	" + friend.get(i).getPhonenum() + "	" + friend.get(i).getAddress());
				fw.write("\n");
			}
			fw.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	void start(){
		boolean go=true;
		while(go){
			System.out.print("1)친구등록  2)전체보기  3)데이터저장  4)종료  ==> ");
			choice = s.nextInt();
			switch (choice){
			case 1 :
				add();
				break;
			case 2 :
				showAll();
				break;
			case 3 :
				save();
				break;
			case 4 :
				go = false;
				break;
			}
		}
	}
	public static void main(String[] args) {
		AddFriend t = new AddFriend(null, null, null);
		t.start();
	}
}