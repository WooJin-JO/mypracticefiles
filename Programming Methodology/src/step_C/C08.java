package step_C;

import java.util.Scanner;

public class C08 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("ù��° ���ڸ� �Է��ϼ���");
		int num1 = s.nextInt();
		System.out.print("�ι�° ���ڸ� �Է��ϼ���");
		int num2 = s.nextInt();
		System.out.print("����° ���ڸ� �Է��ϼ���");
		int num3 = s.nextInt();
		int max_num = 0;
		int min_num = 0;
		s.close();
		if (num1 >= num2 & num1 >= num3) {
			 max_num = num1;
		} else if (num2 >= num1 & num2 >= num3) {
			 max_num = num2;
		} else if (num3 >= num1 & num3 >= num2) {
			max_num = num3;
		}
		if (num1 <= num2 & num1 <= num3) {
			min_num = num1;
		} else if (num2 <= num1 & num2 <= num3) {
			min_num = num2;
		} else if (num3 <= num2 & num3 <= num1) {
			min_num = num3;
		}System.out.print("���� ū���� " + max_num + " �̰�, ");
		System.out.println("���� ���� ���� " + min_num + "�Դϴ�.");
	}
	public static void main(String[] args) {
		C08 t = new C08();
		t.run();
	}

}
