package step_D;

import java.util.Scanner;

public class D01 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("숫자를 입력하세요");
		int number = s.nextInt();
		int totalsum = 0;
		s.close();
		for (int i = 1; i <= number; i++) {
			totalsum = totalsum + i;
		} System.out.println("1부터 입력한 숫자까지의 모든 정수를 더한 값은 " + totalsum + "입니다.");
	}
	public static void main(String[] args) {
		D01 t = new D01();
		t.run();
	}

}
