package step_G;

import java.util.Scanner;

public class G04 {
	void run(){
		Scanner s = new Scanner(System.in);
		int kind = 1;//�ŷ�����(1:�Ÿ�, 2:�Ӵ�, 0:�������)
		int money = 0;//�ŷ��ݾ�
		int charge = 0;//�߰� ������
		int total_charge = 0;//������ �Ѿ�
		while(kind != 0){
			System.out.print("�ε��� �ŷ�����(1:�Ÿ�, 2:�Ӵ�, 0:�������)�� �Է��ϼ���. :  ");
			kind = s.nextInt();
			if(kind != 1 && kind != 2 && kind != 0){
				System.out.print("�ε��� �ŷ�����(1:�Ÿ�, 2:�Ӵ�, 0:�������)�� �Է��ϼ���. :  ");
				kind = s.nextInt();
			}
			if(kind == 1){
				System.out.print("�ε��� �ŷ��ݾ�(��)�� �Է��ϼ��� :  ");
				money = s.nextInt();
				if(money < 50000000){
					charge = (int)(money * 0.006);
					if(charge > 250000){
						charge = 250000;
					}
					total_charge += charge;
				}else if(money < 200000000){
					charge = (int)(money * 0.005);
					if(charge > 800000){
						charge = 800000;
					}
					total_charge += charge;
				}else{
					charge = (int)(money * 0.004);
					total_charge += charge;
				}
			}else if(kind == 2){
				System.out.print("�ε��� �ŷ��ݾ�(��)�� �Է��ϼ��� :  ");
				money = s.nextInt();
				if(money < 20000000){
					charge = (int)(money * 0.005);
					if(charge > 70000){
						charge = 70000;
					}
					total_charge += charge;
				}else if(money < 50000000){
					charge = (int)(money * 0.005);
					if(charge > 200000){
						charge = 200000;
					}
					total_charge += charge;
				}else if(money < 100000000){
					charge = (int)(money * 0.004);
					if(charge > 300000){
						charge = 300000;
					}
					total_charge += charge;
				}else{
					charge = (int)(money * 0.003);
					total_charge += charge;
				}
			}else if(kind == 0){
				break;
			}
			System.out.println("�̿� ���� �߰� ������� " + charge + "���Դϴ�.");
		}System.out.println("���ݱ����� ������ �Ѿ��� " + total_charge + "�� �Դϴ�.");
		s.close();
	}
	public static void main(String[] args) {
		G04 t = new G04();
		t.run();
	}
}