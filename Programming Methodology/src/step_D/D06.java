package step_D;

import java.util.Scanner;

public class D06 {
	void run() {
		Scanner s = new Scanner(System.in);
		double m2_area = 0;
		double pyung_area = 0;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		for (int i = 0; i < 10; i++) {
			System.out.print("����Ʈ�� �о� ����(��������)�� �Է��Ͻÿ�.");
			m2_area = s.nextDouble();
			pyung_area = m2_area / 3.305;
			System.out.println("--> �� ����Ʈ�� ������ " + String.format("%.1f", pyung_area) + " �Դϴ�.");
			if (pyung_area < 15) {
				count1++;
			} else if (pyung_area < 30) {
				count2++;
			} else if (pyung_area < 50) {
				count3++;
			} else {
				count4++;
			}
		} s.close();
		System.out.println("\"��������Ʈ\"�� ������ " + count1 + " �Դϴ�.");
		System.out.println("\"�߼�������Ʈ\"�� ������ " + count2 + " �Դϴ�.");
		System.out.println("\"��������Ʈ\"�� ������ " + count3 + " �Դϴ�.");
		System.out.println("\"��������Ʈ\"�� ������ " + count4 + " �Դϴ�.");
	}
	public static void main(String[] args) {
		D06 t = new D06();
		t.run();
	}

}
