package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	Scanner s = new Scanner(System.in);
	ArrayList<Menu> addmenu = new ArrayList<>();
	int choice = 0;
	int no = 0;
	int price = 0;
	String menu;
	String origin;
	public Menu(int n, int p, String m, String o){
		this.no = n;
		this.price = p;
		this.menu = m;
		this.origin = o;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	void add(){
		System.out.println("�޴��� �޴���, ������, ������ �Է��Ͻÿ�.");
		setMenu(s.next());
		setOrigin(s.next());
		setPrice(s.nextInt());
		System.out.println("�ԷµǾ����ϴ�.");
		no++;
		Menu me = new Menu(no, getPrice(), getMenu(), getOrigin());
		addmenu.add(me);
	}
	void modify(){
		list();
		System.out.println("==> ������ ��ȣ�� �Է��ϼ���. : ");
		choice = s.nextInt();
		System.out.println("==> �޴��� �޴���, ������, ������ �Է��Ͻÿ�.");
		setMenu(s.next());
		setOrigin(s.next());
		setPrice(s.nextInt());
		System.out.println("�����Ǿ����ϴ�.");
		Menu me = new Menu(choice, getPrice(), getMenu(), getOrigin());
		addmenu.set(choice-1, me);
	}
	void delete(){
		list();
		System.out.println(" ==> ������ ��ȣ�� �Է��ϼ���. : ");
		choice = s.nextInt() - 1;
		addmenu.remove(choice);
		no--;
		System.out.println("�����Ǿ����ϴ�.");
	}
	void list(){
		System.out.println("�޴���ȣ	�޴��̸�	������	1�κа���");
		for(int i = 0; i < addmenu.size(); i++){
			System.out.println(addmenu.get(i).getNo() + "	" + addmenu.get(i).getMenu() + "	" + addmenu.get(i).getOrigin() + "	" + addmenu.get(i).getPrice());
		}
	}
	void num(){
		System.out.println(no + "���� �޴��� ��ϵǾ� �ֽ��ϴ�.");
	}
	void start(){
		boolean go=true;
		while(go){
			System.out.print("1)�߰�  2)����  3)����  4)����Ʈ  5)�Ѱ���  6)���� ==> ");
			choice = s.nextInt();
			System.out.println("-----------------------------------------------");
			switch (choice){
			case 1 : 
				add();
				break;
			case 2 :
				modify();				
				break;
			case 3 :
				delete();
				break;
			case 4 :
				list();
				break;
			case 5 :
				num();
				break;
			case 6 :
				go=false;
				break;
			}
		}
	}
	public static void main(String[] args) {
		Menu t = new Menu(0, 0, null, null);
		t.start();
	}
}
