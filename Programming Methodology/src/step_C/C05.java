package step_C;

import java.util.Scanner;

public class C05 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("���� �Է��Ͻÿ�.");
		int month = s.nextInt();
		System.out.print("���� �Է��Ͻÿ�.");
		int day = s.nextInt();
		int day_count = 0;
		s.close();
		if (month == 1) {
			day_count = day;
			System.out.println("�� ��¥�� 1�� �� " + day_count + " ��° ���� �ش�˴ϴ�.");
		} else if (month == 2) {
			day_count = 31 + day;
			System.out.println("�� ��¥�� 1�� �� " + day_count + " ��° ���� �ش�˴ϴ�.");
		} else if (month == 3) {
			day_count = 31 + 28 + day;
			System.out.println("�� ��¥�� 1�� �� " + day_count + " ��° ���� �ش�˴ϴ�.");
		} else if (month == 4) {
			day_count = 31 + 28 + 31 + day;
			System.out.println("�� ��¥�� 1�� �� " + day_count + " ��° ���� �ش�˴ϴ�.");
		} else if (month == 5) {
			day_count = 31 + 28 + 31 + 30 + day;
			System.out.println("�� ��¥�� 1�� �� " + day_count + " ��° ���� �ش�˴ϴ�.");
		} else if (month == 6) {
			day_count = 31 + 28 + 31 + 30 + 31 + day;
			System.out.println("�� ��¥�� 1�� �� " + day_count + " ��° ���� �ش�˴ϴ�.");
		} else if (month == 7) {
			day_count = 31 + 28 + 31 + 30 + 31 + 30 + day;
			System.out.println("�� ��¥�� 1�� �� " + day_count + " ��° ���� �ش�˴ϴ�.");
		} else if (month == 8) {
			day_count = 31 + 28 + 31 + 30 + 31 + 30 + 31 + day;
			System.out.println("�� ��¥�� 1�� �� " + day_count + " ��° ���� �ش�˴ϴ�.");
		} else if (month == 9) {
			day_count = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + day;
			System.out.println("�� ��¥�� 1�� �� " + day_count + " ��° ���� �ش�˴ϴ�.");
		} else if (month == 10) {
			day_count = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + day;
			System.out.println("�� ��¥�� 1�� �� " + day_count + " ��° ���� �ش�˴ϴ�.");
		} else if (month == 11) {
			day_count = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + day;
			System.out.println("�� ��¥�� 1�� �� " + day_count + " ��° ���� �ش�˴ϴ�.");
		} else if (month == 12) {
			day_count = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + day;
			System.out.println("�� ��¥�� 1�� �� " + day_count + " ��° ���� �ش�˴ϴ�.");
		} else if (month < 1 | month > 12 | day < 1 | day > 31) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}
	public static void main(String[] args) {
		C05 t = new C05();
		t.run();
	}

}
