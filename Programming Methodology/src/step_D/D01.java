package step_D;

import java.util.Scanner;

public class D01 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("���ڸ� �Է��ϼ���");
		int number = s.nextInt();
		int totalsum = 0;
		s.close();
		for (int i = 1; i <= number; i++) {
			totalsum = totalsum + i;
		} System.out.println("1���� �Է��� ���ڱ����� ��� ������ ���� ���� " + totalsum + "�Դϴ�.");
	}
	public static void main(String[] args) {
		D01 t = new D01();
		t.run();
	}

}
