package step_D;

import java.util.Scanner;

public class D07 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("1�� �Լ� y=ax+b�� ��� a�� b�� �Է��Ͻÿ�.");
		int a = s.nextInt();
		int b = s.nextInt();
		System.out.print("x��ǥ�� ���� ���� �� ���� �Է��Ͻÿ�.");
		for (int x_begin = s.nextInt(), x_end = s.nextInt(); x_begin <= x_end; x_begin++) {
			int x = x_begin, y = a * x_begin + b;
			System.out.println("��ǥ ("+ x + ", " + y + ")");
		} s.close();
	}
	public static void main(String[] args) {
		D07 t = new D07();
		t.run();
	}
	
}
