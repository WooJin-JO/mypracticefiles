package step_D;

import java.util.Scanner;

public class D07 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("1차 함수 y=ax+b의 계수 a와 b를 입력하시오.");
		int a = s.nextInt();
		int b = s.nextInt();
		System.out.print("x좌표의 시작 값과 끝 값을 입력하시오.");
		for (int x_begin = s.nextInt(), x_end = s.nextInt(); x_begin <= x_end; x_begin++) {
			int x = x_begin, y = a * x_begin + b;
			System.out.println("좌표 ("+ x + ", " + y + ")");
		} s.close();
	}
	public static void main(String[] args) {
		D07 t = new D07();
		t.run();
	}
	
}
