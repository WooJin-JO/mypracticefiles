package step_D;

import java.util.Scanner;

public class D08 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("2�� �Լ� y=ax^2+bx+c�� ��� a�� b, c�� �Է��Ͻÿ�.");
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		System.out.print("x��ǥ�� ���� ���� �� ���� �Է��Ͻÿ�.");
		for (int x_begin = s.nextInt(), x_end = s.nextInt(); x_begin <= x_end; x_begin++) {
			int x = x_begin, y = (int) (a * Math.pow(x_begin, 2) + b * x_begin + c);
			System.out.println("��ǥ ("+ x + ", " + y + ")");
		} s.close();
	}
	public static void main(String[] args) {
		D08 t = new D08();
		t.run();
	}

}
