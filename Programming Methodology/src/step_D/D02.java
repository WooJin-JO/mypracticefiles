package step_D;

import java.util.Scanner;

public class D02 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("0���� 100 ������ ���ڸ� �Է��ϼ���");
		int number = s.nextInt();
		int max_num = Integer.MIN_VALUE;
		int min_num = Integer.MAX_VALUE;
		while (0 < number & number < 100) {
			System.out.print("0���� 100 ������ ���ڸ� �Է��ϼ���");
			number = s.nextInt();
			if (number < 100 & number > max_num) {
				max_num = number;
			}
			if (number > 0 & number < min_num) {
				min_num = number;
			}
		} System.out.println("�Էµ� ���ڵ� �� ���� ū ���� " + max_num + "�̰�, ���� ���� ���� " + min_num + "�Դϴ�.");
		s.close();
	}
	public static void main(String[] args) {
		D02 t = new D02();
		t.run();
	}

}
