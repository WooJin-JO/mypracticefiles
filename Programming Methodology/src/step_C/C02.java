package step_C;

import java.util.Scanner;

public class C02 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("���� �µ��� �Է��ϼ���");
		double input_degree = s.nextDouble();
		s.close();
		if (input_degree < 0) {
			System.out.println("�߸��Է��ϼ̽��ϴ�.");
		} else if (input_degree < 25) {
			System.out.println("�ü��Դϴ�.");
		} else if (input_degree < 40) {
			System.out.println("�̿¼��Դϴ�.");
		} else if (input_degree < 80) {
			System.out.println("�¼��Դϴ�.");
		} else {
			System.out.println("���� ���Դϴ�.");
		}
	}
	public static void main(String[] args) {
		C02 t = new C02();
		t.run();
	}

}
