package step_D;

import java.util.Scanner;

public class D04 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("������ �� ������ �Է��ϼ���");
		int count_all = s.nextInt();
		int count_young = 0;
		for (int i = 0; i < count_all; i++) {
			System.out.print("�¾ �⵵�� �Է��ϼ���");
			int birth_year = s.nextInt();
			int age = 2016 - birth_year + 1;
			if (age < 20) {
				count_young++;
			}
		} System.out.println("������ �߿� �̼����ڴ� ��� " + count_young + "���Դϴ�.");
		s.close();
	}
	public static void main(String[] args) {
		D04 t = new D04();
		t.run();
	}
}