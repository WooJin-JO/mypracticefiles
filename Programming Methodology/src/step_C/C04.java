package step_C;

import java.util.Scanner;

public class C04 {
	void run () {
		Scanner s = new Scanner(System.in);
		System.out.print("����Ʈ�� �о� ����(��������)�� �Է��Ͻÿ�.");
		double m2_area = s.nextDouble();
		double pyung_area = m2_area / 3.305;
		System.out.println("����Ʈ�� ������ " + String.format("%.1f", pyung_area) + "�Դϴ�.");
		s.close();
		if (pyung_area < 15) {
			System.out.println("���� ����Ʈ �Դϴ�.");
		} else if (pyung_area <30) {
			System.out.println("�߼��� ����Ʈ �Դϴ�.");
		} else if (pyung_area <50) {
			System.out.println("���� ����Ʈ �Դϴ�.");
		} else {
			System.out.println("���� ����Ʈ �Դϴ�.");
		}
	}
	public static void main(String[] args) {
		C04 t = new C04();
		t.run();
	}

}
