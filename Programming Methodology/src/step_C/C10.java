package step_C;

import java.util.Scanner;

public class C10 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("����1�� �Է��ϼ���");
		int num1 = s.nextInt();
		System.out.print("����2�� �Է��ϼ���");
		int num2 = s.nextInt();
		System.out.print("�����ȣ����('+', '-', '*', '/' �� 1��)�� �Է��ϼ���");
		String operator = s.next();
		s.close();
		if (operator.equals("+")) {
			System.out.println("������ ��� ���� " + num1+num2 + "�Դϴ�.");
		} else if (operator.equals("-")) {
			System.out.println("������ ��� ���� " + (int)(num1-num2) + "�Դϴ�.");
		} else if (operator.equals("*")) {
			System.out.println("������ ��� ���� " + num1*num2 + "�Դϴ�.");
		} else if (operator.equals("/")) {
			System.out.println("������ ��� ���� " + num1/num2 + "�Դϴ�.");
		}
	}
	public static void main(String[] args) {
		C10 t = new C10();
		t.run();
	}

}
