package step_G;

import java.util.Scanner;

public class G06 {
	void run(){
		Scanner s = new Scanner(System.in);
		int[] order = {1, 1, 1};//�Է¹޴� ���� ��ǰ ����(�����尩, ���尩, ����尩)
		int[] total_order = {0, 0, 0};//�� �Ǹ� ����(�����尩, ���尩, ����尩)
		int sale = 0;//�����
		int total_sale = 0;//�� �����
		int[] price = {10000, 6000, 3000};//��ǰ�� ����
		int i;
		System.out.println("�� ������ ��ǰ�� �ֽ��ϴ�.");
		System.out.println("(1.�����尩 1����,  2.���尩 6õ��,  3.����尩 3õ��)");
		while(order[0] != 0 || order[1] != 0 || order[2] != 0){
			if(order[0] == 0 && order[1] == 0 && order[2] == 0){
				break;
			}
			System.out.println();
			for(i = 0; i < order.length; i++){
				System.out.print((i+1) + "�� ��ǰ�� ��� �����ϽǷ���?");
				order[i] = s.nextInt();
				total_order[i] += order[i];
				sale += (order[i] * price[i]);
			}
			if(order[0] != 0 || order[1] != 0 || order[2] != 0){
				System.out.println("�Ǹ� �ݾ��� " + sale + "�� �Դϴ�.");
			}
			total_sale += sale;
			sale = 0;
		}System.out.println("���ݱ����� �� ���� �ݾ��� " + total_sale + "�� �Դϴ�.");
		for(i = 0; i < order.length; i++){
			System.out.println((i+1) + "�� ��ǰ�� �� �Ǹ� ������ " + total_order[i] + "�� �Դϴ�.");
		}s.close();
	}
	public static void main(String[] args) {
		G06 t = new G06();
		t.run();
	}
}
