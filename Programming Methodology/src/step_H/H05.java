package step_H;

import java.util.Random;
import java.util.Scanner;

public class H05 {
	void run(){
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		int coins;
		int[] number = new int[3];
		@SuppressWarnings("unused")
		int dummy;
		int count = 1;
		int i;
		System.out.print("����Ͻ� ������ ������ �Է��ϼ���.  ");
		coins = s.nextInt();
		while(coins > 0){
			for(i = 0; i < number.length; i++){
				number[i] = r.nextInt(9)+1;
			}
			System.out.print("���� " + count + "ȸ  Start!!! (�ƹ� ���ڳ� �Է��ϼ���.)");
			dummy = s.nextInt();
			count++;
			coins--;
			System.out.print("���� ��� : " + number[0] + "  " + number[1] + "  " + number[2] + "  =>");
			if(number[0] == number[1] && number[1] == number[2]){
				System.out.println("���� 3�� ��ġ... ���� 4�� ����");
				coins += 4;
				System.out.println("�����ִ� ������" + coins + "�� �Դϴ�.");
			}else if(number[0] == number[1] || number[1] == number[2] || number[2] == number[0]){
				System.out.println("���� 2�� ��ġ... ���� 2�� ����");
				coins += 2;
				System.out.println("�����ִ� ������" + coins + "�� �Դϴ�.");
			}else{
				System.out.println("���Դϴ�... �ƽ�����...");
				System.out.println("�����ִ� ������" + coins + "�� �Դϴ�.");
			}
		}System.out.println();
		System.out.println("���� ����!!");
		s.close();
	}
	public static void main(String[] args) {
		H05 t = new H05();
		t.run();
	}
}