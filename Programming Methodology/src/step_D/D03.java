package step_D;

import java.util.Scanner;

public class D03 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("0���� 100 ������ ���ڸ� �Է��ϼ���");
		int count = 0;
		int totalsum = 0;
		int number = s.nextInt();
		while (number > 0 & number < 100) {
			totalsum = totalsum + number;
			count++;
			System.out.print("0���� 100 ������ ���ڸ� �Է��ϼ���");
			number = s.nextInt();
			double average = (double)(totalsum) / (double)(count);
			if (number < 0 | number > 100) {
			System.out.println("�Է��� " + count + " ���� ���ڵ��� ���հ�� " + totalsum + "�̰�, ��� ���� " + average + " �Դϴ�.");
			}
		} s.close();
	}
	public static void main(String[] args) {
		D03 t = new D03();
		t.run();
	}

}
