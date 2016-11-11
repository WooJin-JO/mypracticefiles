package step_C;

import java.util.Scanner;

public class C01 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("태어난 년도를 입력하세요");
		int birth_year = s.nextInt();
		int age = 2016 - birth_year + 1;
		s.close();
		if (age < 7) {
			System.out.println("유아입니다.");
		} else if (age < 13) {
			System.out.println("어린이 입니다.");
		} else if (age < 20) {
			System.out.println("청소년 입니다.");
		} else if (age < 30) {
			System.out.println("청년 입니다.");
		} else if (age < 60) {
			System.out.println("중년 입니다.");
		} else {
			System.out.println("노년 입니다.");
		}
	}
	public static void main(String[] args) {
		C01 t = new C01();
		t.run();
	}

}
