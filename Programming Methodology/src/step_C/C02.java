package step_C;

import java.util.Scanner;

public class C02 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("물의 온도를 입력하세요");
		double input_degree = s.nextDouble();
		s.close();
		if (input_degree < 0) {
			System.out.println("잘못입력하셨습니다.");
		} else if (input_degree < 25) {
			System.out.println("냉수입니다.");
		} else if (input_degree < 40) {
			System.out.println("미온수입니다.");
		} else if (input_degree < 80) {
			System.out.println("온수입니다.");
		} else {
			System.out.println("끓는 물입니다.");
		}
	}
	public static void main(String[] args) {
		C02 t = new C02();
		t.run();
	}

}
