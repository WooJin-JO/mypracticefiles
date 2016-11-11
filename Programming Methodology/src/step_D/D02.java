package step_D;

import java.util.Scanner;

public class D02 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("0부터 100 사이의 숫자를 입력하세요");
		int number = s.nextInt();
		int max_num = Integer.MIN_VALUE;
		int min_num = Integer.MAX_VALUE;
		while (0 < number & number < 100) {
			System.out.print("0부터 100 사이의 숫자를 입력하세요");
			number = s.nextInt();
			if (number < 100 & number > max_num) {
				max_num = number;
			}
			if (number > 0 & number < min_num) {
				min_num = number;
			}
		} System.out.println("입력된 숫자들 중 가장 큰 수는 " + max_num + "이고, 가장 작은 수는 " + min_num + "입니다.");
		s.close();
	}
	public static void main(String[] args) {
		D02 t = new D02();
		t.run();
	}

}
