package step_D;

import java.util.Scanner;

public class D10 {
	void run() {
		Scanner s = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;
		int i = 0;
		int j = 0;
		System.out.print("2개의 숫자를 입력하시오.");
		num1 = s.nextInt();
		num2 = s.nextInt();
		for(i = 1; num1 * i <= 100; i++) {
			for(j = 1; num2 * j <= 100; j++) {
				
			}
		}s.close();
	}
	public static void main(String[] args) {
		D10 t = new D10();
		t.run();
	}

}
