package step_G;

import java.util.Scanner;

public class G05 {
	void run(){
		Scanner s = new Scanner(System.in);
		int hour = 1;//�̿�ð�
		int minute = 1;//�̿� ��
		int charge = 0;//�̿��
		int total_charge = 0;//�̿�� �Ѿ�
		while(hour != 0 || minute != 0){
			System.out.print("����� �ð���  �ð��� ������ �Է��ϼ���. : ");
			hour = s.nextInt();
			minute = s.nextInt();
			if(hour < 0 || minute < 0 || minute > 59){
				System.out.print("����� �ð���  �ð��� ������ �Է��ϼ���. : ");
				hour = s.nextInt();
				minute = s.nextInt();
			}else if(hour == 0 && minute == 0){
				break;
			}
			
			if(minute == 0){
				charge = 2 * hour * 1000;
			}else if(minute <= 30){
				charge = 2 * hour * 1000 + 1000;
			}else if(minute < 60){
				charge = 2 * hour * 1000 + 2000;
			}
			
			if(hour < 2){
				charge = (int)(charge * 1.00);
				total_charge += charge;
			}else if(hour >= 2 && hour < 3){
				charge = (int)(charge * 0.95);
				total_charge += charge;
			}else if(hour < 5){
				charge = (int)(charge * 0.90);
				total_charge += charge;
			}else{
				charge = (int)(charge * 0.80);
				total_charge += charge;
			}
			System.out.println("�������� �̿���  " + charge + "���Դϴ�.");
		}
		System.out.println("���ݱ����� �̿�� �� �ݾ��� " + total_charge + "���Դϴ�.");
		s.close();
	}
	public static void main(String[] args) {
		G05 t = new G05();
		t.run();
	}
}