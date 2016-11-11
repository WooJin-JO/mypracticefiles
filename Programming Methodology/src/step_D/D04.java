package step_D;

import java.util.Scanner;

public class D04 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("가족이 몇 명인지 입력하세요");
		int count_all = s.nextInt();
		int count_young = 0;
		for (int i = 0; i < count_all; i++) {
			System.out.print("태어난 년도를 입력하세요");
			int birth_year = s.nextInt();
			int age = 2016 - birth_year + 1;
			if (age < 20) {
				count_young++;
			}
		} System.out.println("가족들 중에 미성년자는 모두 " + count_young + "명입니다.");
		s.close();
	}
	public static void main(String[] args) {
		D04 t = new D04();
		t.run();
	}
}