package step_E;

import java.util.Scanner;

public class E02 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("���� �ﰢ���� ���̿� ���� ������ ũ�⸦ �Է��Ͻÿ�.");
		int height = s.nextInt();
		int blank = s.nextInt();
		s.close();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < height+blank-i-1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			} System.out.println();
		}
	}
	public static void main(String[] args) {
		E02 t = new E02();
		t.run();
	}

}
