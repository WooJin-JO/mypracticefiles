package midexam;


import java.text.SimpleDateFormat;	// �ֹ��Ͻ� �ڵ��Է��� ���� ���� (�ֹ��� ������ �޼ҵ� ��)
import java.util.ArrayList;
import java.util.Date;					// �ֹ��Ͻ� �ڵ��Է��� ���� ���� (�ֹ��� ������ �޼ҵ� ��)

/*
2016-2�б� ���α׷���������[��米�� : �豤] �߰�����

�а� : �����к�
�г� : 3�г�
�й� : 2012048908
�̸� : ������

���� : �Ѿ���� �ֹ����� ���α׷� HFCManager 
 */

import java.util.Scanner;

class Order {
	int no, price; // �ֹ��Ϸù�ȣ, ���ֹ�����
	int count[];		// �޴��� �ֹ����� (count[0]:�Ķ��̵� count[1]:��� count[2]:�ݹ� count[3]:�Ĵ� )
	String buyer, date;	//�ֹ��ڼ���, �ֹ��Ͻ�(�ڵ��Էµ�) 

	public Order(int n, int p, int c[], String b){ // �ֹ��� ������.. ������ �ʿ� ����  {
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
	ArrayList<Order> order_list;	// �ֹ��� ��ü ����Ʈ
	String menu_name[] = {"�Ķ��̵�","���","�ݹ�","�Ĵ�"};			// �޴��̸�
	int order_menu[];				// �޴��� �� �ֹ�����
	int price_menu[];				// �޴��� �ǸŴܰ�
	int orders;					// ��������� �ֹ��� ����
	int income;					// ��������� �� ����ݾ�
	Scanner s = new Scanner(System.in);
	// ������ü ������ 
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
	// �����۾� �������� �޴��� �ܰ� �Է��� ���� �޼ҵ� 
	void setPrice(){
		System.out.println("�޴��� �ܰ��� �Է��Ͻÿ�.");
		for (int i=0;i<4;i++){
			System.out.print(menu_name[i]+" : ");
			price_menu[i]=s.nextInt();
		}
	}
	// �޴���(�޴��̸��� ����)�� �����ִ� �޼ҵ� 
	void printMenu(){
		System.out.print("�޴��� : ");
		for (int i=0;i<4;i++){
			System.out.println("["+(i+1)+"] "+menu_name[i] + " - "+price_menu[i] + "��");
		}
		System.out.println();
	}
	//�ֹ� �߰�
	void addOrder(){
		System.out.print("�ֹ��� �̸��� �Է��ϼ��� : ");
		String buyer = s.next();
		System.out.print("�޴��� �ֹ� ������ �Է��ϼ��� : [1]�Ķ��̵� [2]��� [3]�ݹ� [4]�Ĵ� --> ");
		int amount[] = new int[4];		// 4���� �޴��� �ֹ���
		for (int i=0;i<4;i++){
			amount[i] = s.nextInt();		// �ֹ����� 4�� �Է¹�
		}
		int price = 0;						// �ֹ��ݾ� �ʱ�ȭ 
		for (int i=0;i<4;i++){
			price += amount[i] * price_menu[i];		// �ֹ��ݾ� ���� 
			order_menu[i] += amount[i];		// �޴��� �� �ֹ������� �������  
		}
		income += price; //�� �ֹ��ݾ׿� �߰�
		orders++; // �ֹ� ��ȣ, �ֹ�Ƚ�� ����
		Order ord = new Order(orders, price, amount, buyer);
		order_list.add(ord);
	}
	//�ֹ�������
	void modifyOrder(){
		listOrder();
		System.out.print("������ �ֹ��� ��ȣ��? (0 ���) : "); 
		int num = s.nextInt();
		if (num == 0) {
			System.out.println("����ϼ̽��ϴ�.");
		}else if (num > orders){
			System.out.println("���� �ֹ��� ��ȣ�Դϴ�.");			
		} else {
			orders = order_list.get(num-1).no;
			int price = order_list.get(num-1).getPrice();
			income -= price; //�����ϴ� �ֹ��� ��ŭ �Ѿ׿��� ����
			String buyer = order_list.get(num-1).getBuyer();
			
			System.out.print("�޴��� �ֹ� ������ �ٽ� �Է��ϼ��� : [1]�Ķ��̵� [2]��� [3]�ݹ� [4]�Ĵ� --> ");
			int amount[] = new int[4];		// 4���� �޴��� �ֹ���
			for (int i=0;i<4;i++){
				order_menu[i] -= order_list.get(num-1).count[i];
				amount[i] = s.nextInt();		// �ֹ����� 4�� �Է¹�
			}
			price = 0;						// �ֹ��ݾ� �ʱ�ȭ 
			for (int i=0;i<4;i++){
				price += amount[i] * price_menu[i];		// �ֹ��ݾ� ���� 
				order_menu[i] += amount[i];		// �޴��� �� �ֹ������� �������  
			}
			income += price;
			Order ord = new Order(orders, price, amount, buyer);
			order_list.set(num-1, ord);
			System.out.println("����Ǿ����ϴ�.");
		}
	}

	void listOrder(){
		System.out.println("��ȣ 	�ֹ��Ͻ�			�ֹ���	�ֹ��ݾ�	�ֹ�����(�Ķ��̵�/���/�ݹ�/�Ĵ�)");
		for(int i = 0; i < order_list.size(); i++){
			System.out.println(order_list.get(i).no + "	" + order_list.get(i).getDate() + "	" + order_list.get(i).getBuyer() + "	" + order_list.get(i).getPrice() + "	" + order_list.get(i).count[0] + "�� / " + order_list.get(i).count[1] + "�� / " + order_list.get(i).count[2] + "�� / " + order_list.get(i).count[3] + "�� / ");
		}
	}

	void listOrder(int price){
		System.out.println("�˻��� �ּ� �ֹ� �ݾ���? :");
		price = s.nextInt();
		System.out.println(price+"�� �̻� �ֹ��� ������ ������ �����ϴ�");
		System.out.println("��ȣ 	�ֹ��Ͻ�			�ֹ���	�ֹ��ݾ�	�ֹ�����(�Ķ��̵�/���/�ݹ�/�Ĵ�)");
		for(int i = 0; i < order_list.size(); i++){
			if(order_list.get(i).getPrice() > price){
				System.out.println(order_list.get(i).no + "	" + order_list.get(i).getDate() + "	" + order_list.get(i).getBuyer() + "	" + order_list.get(i).getPrice() + "	" + order_list.get(i).count[0] + "�� / " + order_list.get(i).count[1] + "�� / " + order_list.get(i).count[2] + "�� / " + order_list.get(i).count[3] + "�� / ");
			}
		}
	}
	void listOrder(String name){
		System.out.println("�˻��� ���� �̸���?");
		name = s.next();
		System.out.println(name+" �������� �ֹ��Ͻ� ������ ������ �����ϴ�");
		System.out.println("��ȣ 	�ֹ��Ͻ�			�ֹ���	�ֹ��ݾ�	�ֹ�����(�Ķ��̵�/���/�ݹ�/�Ĵ�)");
		for(int i = 0; i < order_list.size(); i++){
			if(order_list.get(i).getBuyer().equals(name)){
				System.out.println(order_list.get(i).no + "	" + order_list.get(i).getDate() + "	" + order_list.get(i).getBuyer() + "	" + order_list.get(i).getPrice() + "	" + order_list.get(i).count[0] + "�� / " + order_list.get(i).count[1] + "�� / " + order_list.get(i).count[2] + "�� / " + order_list.get(i).count[3] + "�� / ");
			}
		}
	}
	//�������˻�
	void searchOrderByName(){
		String name = null;
		listOrder(name);
	}
	//�ݾ׺��˻�
	void searchOrderByPrice(){
		int price = 0;
		listOrder(price);
	}
	void findBestOrder(){
		int j = 0; //���� ���� �ݾ��� �ֹ� ��ġ ������ ���� ����
		int best = Integer.MIN_VALUE; //���� ���� �ݾ��� ã������ ������ ����
		for(int i = 0; i < order_list.size(); i++){
			if(order_list.get(i).getPrice() > best){
				best = order_list.get(i).getPrice();
				j = i;
			}
		}System.out.println("���� ���� �ݾ��� �ֹ��� �ֹ����� ������ �����ϴ�.");
		System.out.println("�ֹ��Ͻ� : " + order_list.get(j).getDate());
		System.out.println("�ֹ����� : " + order_list.get(j).getBuyer());
		System.out.println("�ֹ��ݾ� : " + order_list.get(j).getPrice());
		System.out.println("�ֹ����� : " + "�Ķ��̵� " + order_list.get(j).count[0] + "�� /���" + order_list.get(j).count[1] + "�� /�ݹ�" + order_list.get(j).count[2] + "�� /�Ĵ�" + order_list.get(j).count[3]);
	}
	void report(){
		System.out.println("���⺸�� (�ֹ�Ƚ�� : " + orders + "��)");
		listOrder();
		System.out.println("�޴��� �� �ֹ�����");
		for(int i = 0; i < order_menu.length; i++){
			System.out.println(menu_name[i] + " : " + order_menu[i] + "��");
		}System.out.println("�� �Ǹűݾ� : " + income + "��");
	}
	//�ֹ������۾�����(start)
	void start(){
		int menu;
		boolean go=true;

		setPrice();
		while(go){
			System.out.println("\n===============================================================");
			System.out.println("1.�ֹ��߰�, 2.�ֹ�����, 3.�ֹ��˻�(������) 4.�ֹ��˻�(�ݾ׺�), 5.����Ʈ, 6.����, 7.����");
			System.out.print("�޴����� : ");
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