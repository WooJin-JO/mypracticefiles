package step_B;

import java.util.Scanner;

public class B08 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("ù��° ���ڸ� �Է��ϼ���");
		int num1 = s.nextInt();
		System.out.print("�ι�° ���ڸ� �Է��ϼ���");
		int num2 = s.nextInt();
		System.out.print("����° ���ڸ� �Է��ϼ���");
		int num3 = s.nextInt();
		s.close();
		if (num1 == num2 | num2 == num3 | num3 == num1) {
			System.out.println("1�� ���� ���� : 3���� ���� �� ��� �� ���� ���� ����.");
		}
		if (num1 >50 & num2 > 50 | num2 > 50 & num3 > 50 | num3 > 50 & num1 > 50) {
			System.out.println("2�� ���� ���� : 3���� ���� �� ��� �� ���� ũ�Ⱑ ��� 50 ���� ũ��.");
		}
		if (num1 + num2 == num3 | num2 + num3 == num1 | num3 + num1 == num2) {
			System.out.println("3�� ���� ���� : 3���� ���� �� ��� �� ���� ũ�Ⱑ ��� 50 ���� ũ��");
		}
		if (num1 % num2 == 0 | num2 % num3 == 0 | num3 % num1 == 0) {
			System.out.println("4�� ���� ���� : 3���� ���� �� � �ϳ��� ���� �ٸ� �� ���� ������ ������ �������� �ܿ찡 �ִ�.");
		}
	}
	public static void main(String[] args) {
		B08 t = new B08();
		t.run();		
	}
}
