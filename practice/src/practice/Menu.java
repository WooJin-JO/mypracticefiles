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
		System.out.println("메뉴의 메뉴명, 원산지, 가격을 입력하시오.");
		setMenu(s.next());
		setOrigin(s.next());
		setPrice(s.nextInt());
		System.out.println("입력되었습니다.");
		no++;
		Menu me = new Menu(no, getPrice(), getMenu(), getOrigin());
		addmenu.add(me);
	}
	void modify(){
		list();
		System.out.println("==> 수정할 번호를 입력하세요. : ");
		choice = s.nextInt();
		System.out.println("==> 메뉴의 메뉴명, 원산지, 가격을 입력하시오.");
		setMenu(s.next());
		setOrigin(s.next());
		setPrice(s.nextInt());
		System.out.println("수정되었습니다.");
		Menu me = new Menu(choice, getPrice(), getMenu(), getOrigin());
		addmenu.set(choice-1, me);
	}
	void delete(){
		list();
		System.out.println(" ==> 삭제할 번호를 입력하세요. : ");
		choice = s.nextInt() - 1;
		addmenu.remove(choice);
		no--;
		System.out.println("삭제되었습니다.");
	}
	void list(){
		System.out.println("메뉴번호	메뉴이름	원산지	1인분가격");
		for(int i = 0; i < addmenu.size(); i++){
			System.out.println(addmenu.get(i).getNo() + "	" + addmenu.get(i).getMenu() + "	" + addmenu.get(i).getOrigin() + "	" + addmenu.get(i).getPrice());
		}
	}
	void num(){
		System.out.println(no + "개의 메뉴가 등록되어 있습니다.");
	}
	void start(){
		boolean go=true;
		while(go){
			System.out.print("1)추가  2)수정  3)삭제  4)리스트  5)총개수  6)종료 ==> ");
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
