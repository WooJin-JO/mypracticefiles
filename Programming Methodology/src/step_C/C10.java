package step_C;

import java.util.Scanner;

public class C10 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("숫자1을 입력하세요");
		int num1 = s.nextInt();
		System.out.print("숫자2을 입력하세요");
		int num2 = s.nextInt();
		System.out.print("연산기호문자('+', '-', '*', '/' 중 1개)를 입력하세요");
		String operator = s.next();
		s.close();
		if (operator.equals("+")) {
			System.out.println("계산식의 결과 값은 " + num1+num2 + "입니다.");
		} else if (operator.equals("-")) {
			System.out.println("계산식의 결과 값은 " + (int)(num1-num2) + "입니다.");
		} else if (operator.equals("*")) {
			System.out.println("계산식의 결과 값은 " + num1*num2 + "입니다.");
		} else if (operator.equals("/")) {
			System.out.println("계산식의 결과 값은 " + num1/num2 + "입니다.");
		}
	}
	public static void main(String[] args) {
		C10 t = new C10();
		t.run();
	}

}
