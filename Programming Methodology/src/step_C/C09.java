package step_C;

import java.util.Scanner;

public class C09 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("����(�� ����)�� ���ڷ� �Է��ϼ���");
		int income = s.nextInt();
		int tax = 0;
		s.close();
		if (income < 10000000) {
			tax = income/1000 * 95;
		} else if (income < 40000000) {
			tax = income/100 * 19;
		} else if (income < 80000000) {
			tax = income/100 * 28;
		} else {
			tax = income/100 * 37;
		} System.out.println("���� �ݾ׿� ���� �ҵ漼�� " + tax + "�� �Դϴ�.");
	}
	public static void main(String[] args) {
		C09 t = new C09();
		t.run();
	}

}
