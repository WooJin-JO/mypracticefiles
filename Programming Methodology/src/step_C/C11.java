package step_C;

import java.util.Scanner;

public class C11 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("�⵵�� �Է��ϼ���");
		int year = s.nextInt();
		s.close();
		if (year % 4 == 0 & year % 100 != 0 | year % 400 == 0) {
			System.out.println("�Է��Ͻ� �⵵�� �����Դϴ�.");
		} else {
			System.out.println("�Է��Ͻ� �⵵�� ������ �ƴմϴ�.");
		}	
	}
	public static void main(String[] args) {
		C11 t = new C11();
		t.run();
	}
}
