package step_D;

import java.util.Scanner;

public class D08 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("2차 함수 y=ax^2+bx+c의 계수 a와 b, c를 입력하시오.");
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		System.out.print("x좌표의 시작 값과 끝 값을 입력하시오.");
		for (int x_begin = s.nextInt(), x_end = s.nextInt(); x_begin <= x_end; x_begin++) {
			int x = x_begin, y = (int) (a * Math.pow(x_begin, 2) + b * x_begin + c);
			System.out.println("좌표 ("+ x + ", " + y + ")");
		} s.close();
	}
	public static void main(String[] args) {
		D08 t = new D08();
		t.run();
	}

}
