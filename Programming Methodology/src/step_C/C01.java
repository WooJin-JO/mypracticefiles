package step_C;

import java.util.Scanner;

public class C01 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("�¾ �⵵�� �Է��ϼ���");
		int birth_year = s.nextInt();
		int age = 2016 - birth_year + 1;
		s.close();
		if (age < 7) {
			System.out.println("�����Դϴ�.");
		} else if (age < 13) {
			System.out.println("��� �Դϴ�.");
		} else if (age < 20) {
			System.out.println("û�ҳ� �Դϴ�.");
		} else if (age < 30) {
			System.out.println("û�� �Դϴ�.");
		} else if (age < 60) {
			System.out.println("�߳� �Դϴ�.");
		} else {
			System.out.println("��� �Դϴ�.");
		}
	}
	public static void main(String[] args) {
		C01 t = new C01();
		t.run();
	}

}
