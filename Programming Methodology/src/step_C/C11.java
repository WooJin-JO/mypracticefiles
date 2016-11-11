package step_C;

import java.util.Scanner;

public class C11 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("년도를 입력하세요");
		int year = s.nextInt();
		s.close();
		if (year % 4 == 0 & year % 100 != 0 | year % 400 == 0) {
			System.out.println("입력하신 년도는 윤년입니다.");
		} else {
			System.out.println("입력하신 년도는 윤년이 아닙니다.");
		}	
	}
	public static void main(String[] args) {
		C11 t = new C11();
		t.run();
	}
}
