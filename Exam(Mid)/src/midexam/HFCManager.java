package midexam;


import java.text.SimpleDateFormat;	// 주문일시 자동입력을 위한 구문 (주문서 생성자 메소드 내)
import java.util.ArrayList;
import java.util.Date;					// 주문일시 자동입력을 위한 구문 (주문서 생성자 메소드 내)

/*
2016-2학기 프로그램설계방법론[담당교수 : 김광] 중간고사

학과 : 경제학부
학년 : 3학년
학번 : 2012048908
이름 : 조우진

주제 : 한양통닭 주문관리 프로그램 HFCManager 
 */

import java.util.Scanner;

class Order {
	int no, price; // 주문일련번호, 총주문가격
	int count[];		// 메뉴별 주문갯수 (count[0]:후라이드 count[1]:양념 count[2]:반반 count[3]:파닭 )
	String buyer, date;	//주문자성명, 주문일시(자동입력됨) 

	public Order(int n, int p, int c[], String b){ // 주문서 생성자.. 수정할 필요 없음  {
		this.no = n;
		this.price = p;
		this.count = new int[4];
		for (int i=0;i<4;i++){
			this.count[i] = c[i];
		}
		this.buyer = b;
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd, hh:mm:ss"); 
		this.date = sdf.format(dt).toString();
	}
	int getPrice(){
		return price;
	}
	int[] getCount(){
		return count;
	}
	String getBuyer(){
		return buyer;
	}
	String getDate(){
		return date;
	}
	void setPrice(int new_price){
		this.price = new_price;
	}
	void setCount(int[] new_count){
		this.count = new_count;
	}
}

class HFCManager {
	ArrayList<Order> order_list;	// 주문서 객체 리스트
	String menu_name[] = {"후라이드","양념","반반","파닭"};			// 메뉴이름
	int order_menu[];				// 메뉴별 총 주문갯수
	int price_menu[];				// 메뉴별 판매단가
	int orders;					// 현재까지의 주문서 갯수
	int income;					// 현재까지의 총 매출금액
	Scanner s = new Scanner(System.in);
	// 관리객체 생성자 
	public HFCManager(){
		order_list = new ArrayList<Order>();
		order_menu = new int[4];
		price_menu = new int[4];
		orders = 0;
		income = 0;
		for (int i=0;i<4;i++){
			order_menu[i]=0;
			price_menu[i]=0;
		}
	}
	// 관리작업 시작전에 메뉴별 단가 입력을 위한 메소드 
	void setPrice(){
		System.out.println("메뉴별 단가를 입력하시오.");
		for (int i=0;i<4;i++){
			System.out.print(menu_name[i]+" : ");
			price_menu[i]=s.nextInt();
		}
	}
	// 메뉴판(메뉴이름과 가격)을 보여주는 메소드 
	void printMenu(){
		System.out.print("메뉴판 : ");
		for (int i=0;i<4;i++){
			System.out.println("["+(i+1)+"] "+menu_name[i] + " - "+price_menu[i] + "원");
		}
		System.out.println();
	}
	//주문 추가
	void addOrder(){
		System.out.print("주문자 이름을 입력하세요 : ");
		String buyer = s.next();
		System.out.print("메뉴별 주문 갯수를 입력하세요 : [1]후라이드 [2]양념 [3]반반 [4]파닭 --> ");
		int amount[] = new int[4];		// 4가지 메뉴별 주문갯
		for (int i=0;i<4;i++){
			amount[i] = s.nextInt();		// 주문갯수 4번 입력받
		}
		int price = 0;						// 주문금액 초기화 
		for (int i=0;i<4;i++){
			price += amount[i] * price_menu[i];		// 주문금액 누산 
			order_menu[i] += amount[i];		// 메뉴별 총 주문갯수에 누적계산  
		}
		income += price; //총 주문금액에 추가
		orders++; // 주문 번호, 주문횟수 증가
		Order ord = new Order(orders, price, amount, buyer);
		order_list.add(ord);
	}
	//주문서변경
	void modifyOrder(){
		listOrder();
		System.out.print("변경할 주문서 번호는? (0 취소) : "); 
		int num = s.nextInt();
		if (num == 0) {
			System.out.println("취소하셨습니다.");
		}else if (num > orders){
			System.out.println("없는 주문서 번호입니다.");			
		} else {
			orders = order_list.get(num-1).no;
			int price = order_list.get(num-1).getPrice();
			income -= price; //수정하는 주문액 만큼 총액에서 감액
			String buyer = order_list.get(num-1).getBuyer();
			
			System.out.print("메뉴별 주문 갯수를 다시 입력하세요 : [1]후라이드 [2]양념 [3]반반 [4]파닭 --> ");
			int amount[] = new int[4];		// 4가지 메뉴별 주문갯
			for (int i=0;i<4;i++){
				order_menu[i] -= order_list.get(num-1).count[i];
				amount[i] = s.nextInt();		// 주문갯수 4번 입력받
			}
			price = 0;						// 주문금액 초기화 
			for (int i=0;i<4;i++){
				price += amount[i] * price_menu[i];		// 주문금액 누산 
				order_menu[i] += amount[i];		// 메뉴별 총 주문갯수에 누적계산  
			}
			income += price;
			Order ord = new Order(orders, price, amount, buyer);
			order_list.set(num-1, ord);
			System.out.println("변경되었습니다.");
		}
	}

	void listOrder(){
		System.out.println("번호 	주문일시			주문자	주문금액	주문갯수(후라이드/양념/반반/파닭)");
		for(int i = 0; i < order_list.size(); i++){
			System.out.println(order_list.get(i).no + "	" + order_list.get(i).getDate() + "	" + order_list.get(i).getBuyer() + "	" + order_list.get(i).getPrice() + "	" + order_list.get(i).count[0] + "개 / " + order_list.get(i).count[1] + "개 / " + order_list.get(i).count[2] + "개 / " + order_list.get(i).count[3] + "개 / ");
		}
	}

	void listOrder(int price){
		System.out.println("검색할 최소 주문 금액은? :");
		price = s.nextInt();
		System.out.println(price+"원 이상 주문한 내역은 다음과 같습니다");
		System.out.println("번호 	주문일시			주문자	주문금액	주문갯수(후라이드/양념/반반/파닭)");
		for(int i = 0; i < order_list.size(); i++){
			if(order_list.get(i).getPrice() > price){
				System.out.println(order_list.get(i).no + "	" + order_list.get(i).getDate() + "	" + order_list.get(i).getBuyer() + "	" + order_list.get(i).getPrice() + "	" + order_list.get(i).count[0] + "개 / " + order_list.get(i).count[1] + "개 / " + order_list.get(i).count[2] + "개 / " + order_list.get(i).count[3] + "개 / ");
			}
		}
	}
	void listOrder(String name){
		System.out.println("검색할 고객 이름은?");
		name = s.next();
		System.out.println(name+" 고객님이 주문하신 내역은 다음과 같습니다");
		System.out.println("번호 	주문일시			주문자	주문금액	주문갯수(후라이드/양념/반반/파닭)");
		for(int i = 0; i < order_list.size(); i++){
			if(order_list.get(i).getBuyer().equals(name)){
				System.out.println(order_list.get(i).no + "	" + order_list.get(i).getDate() + "	" + order_list.get(i).getBuyer() + "	" + order_list.get(i).getPrice() + "	" + order_list.get(i).count[0] + "개 / " + order_list.get(i).count[1] + "개 / " + order_list.get(i).count[2] + "개 / " + order_list.get(i).count[3] + "개 / ");
			}
		}
	}
	//고객별검색
	void searchOrderByName(){
		String name = null;
		listOrder(name);
	}
	//금액별검색
	void searchOrderByPrice(){
		int price = 0;
		listOrder(price);
	}
	void findBestOrder(){
		int j = 0; //가장 높은 금액의 주문 위치 저장을 위한 변수
		int best = Integer.MIN_VALUE; //가장 높은 금액을 찾기위한 최저값 설정
		for(int i = 0; i < order_list.size(); i++){
			if(order_list.get(i).getPrice() > best){
				best = order_list.get(i).getPrice();
				j = i;
			}
		}System.out.println("가장 많은 금액을 주문한 주문서는 다음과 같습니다.");
		System.out.println("주문일시 : " + order_list.get(j).getDate());
		System.out.println("주문고객 : " + order_list.get(j).getBuyer());
		System.out.println("주문금액 : " + order_list.get(j).getPrice());
		System.out.println("주문내격 : " + "후라이드 " + order_list.get(j).count[0] + "개 /양념" + order_list.get(j).count[1] + "개 /반반" + order_list.get(j).count[2] + "개 /파닭" + order_list.get(j).count[3]);
	}
	void report(){
		System.out.println("매출보고 (주문횟수 : " + orders + "건)");
		listOrder();
		System.out.println("메뉴별 총 주문갯수");
		for(int i = 0; i < order_menu.length; i++){
			System.out.println(menu_name[i] + " : " + order_menu[i] + "개");
		}System.out.println("총 판매금액 : " + income + "원");
	}
	//주문관리작업진행(start)
	void start(){
		int menu;
		boolean go=true;

		setPrice();
		while(go){
			System.out.println("\n===============================================================");
			System.out.println("1.주문추가, 2.주문변경, 3.주문검색(고객별) 4.주문검색(금액별), 5.베스트, 6.매출, 7.종료");
			System.out.print("메뉴선택 : ");
			menu = s.nextInt();
			switch (menu){
			case 1 : 
				addOrder();	
				break;
			case 2 :
				modifyOrder();
				break;
			case 3 :
				searchOrderByName();
				break;
			case 4 :
				searchOrderByPrice();
				break;
			case 5 :
				findBestOrder();
				break;
			case 6 :
				report();
				break;
			case 7 :
				go=false;
				break;
			}
		}

	}
	public static void main(String[] args){
		HFCManager m = new HFCManager();
		m.start();
	}
}
