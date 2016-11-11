package step_B;

import java.util.Scanner;

public class B08 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("첫번째 숫자를 입력하세요");
		int num1 = s.nextInt();
		System.out.print("두번째 숫자를 입력하세요");
		int num2 = s.nextInt();
		System.out.print("세번째 숫자를 입력하세요");
		int num3 = s.nextInt();
		s.close();
		if (num1 == num2 | num2 == num3 | num3 == num1) {
			System.out.println("1번 조건 만족 : 3개의 숫자 중 적어도 두 수의 값이 같다.");
		}
		if (num1 >50 & num2 > 50 | num2 > 50 & num3 > 50 | num3 > 50 & num1 > 50) {
			System.out.println("2번 조건 만족 : 3개의 숫자 중 적어도 두 수의 크기가 모두 50 보다 크다.");
		}
		if (num1 + num2 == num3 | num2 + num3 == num1 | num3 + num1 == num2) {
			System.out.println("3번 조건 만족 : 3개의 숫자 중 적어도 두 수의 크기가 모두 50 보다 크다");
		}
		if (num1 % num2 == 0 | num2 % num3 == 0 | num3 % num1 == 0) {
			System.out.println("4번 조건 만족 : 3개의 숫자 중 어떤 하나의 수로 다른 두 수를 나누면 나누어 떨어지는 겨우가 있다.");
		}
	}
	public static void main(String[] args) {
		B08 t = new B08();
		t.run();		
	}
}
