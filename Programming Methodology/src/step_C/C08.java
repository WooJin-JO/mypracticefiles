package step_C;

import java.util.Scanner;

public class C08 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("첫번째 숫자를 입력하세요");
		int num1 = s.nextInt();
		System.out.print("두번째 숫자를 입력하세요");
		int num2 = s.nextInt();
		System.out.print("세번째 숫자를 입력하세요");
		int num3 = s.nextInt();
		int max_num = 0;
		int min_num = 0;
		s.close();
		if (num1 >= num2 & num1 >= num3) {
			 max_num = num1;
		} else if (num2 >= num1 & num2 >= num3) {
			 max_num = num2;
		} else if (num3 >= num1 & num3 >= num2) {
			max_num = num3;
		}
		if (num1 <= num2 & num1 <= num3) {
			min_num = num1;
		} else if (num2 <= num1 & num2 <= num3) {
			min_num = num2;
		} else if (num3 <= num2 & num3 <= num1) {
			min_num = num3;
		}System.out.print("가장 큰수는 " + max_num + " 이고, ");
		System.out.println("가장 작은 수는 " + min_num + "입니다.");
	}
	public static void main(String[] args) {
		C08 t = new C08();
		t.run();
	}

}
