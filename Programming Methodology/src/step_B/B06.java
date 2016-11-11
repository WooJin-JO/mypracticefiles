package step_B;

import java.util.Scanner;

public class B06 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("국어 점수를 입력하세요");
		int kor = s.nextInt();
		System.out.print("영어 점수를 입력하세요");
		int eng = s.nextInt();
		System.out.print("수학 점수를 입력하세요");
		int math = s.nextInt();
		s.close();
		int total = kor + eng + math;
		double average = total / 3.0;
		System.out.println("입력하신 점수의 총점은 " + total + "이고,");
		System.out.println("평균은 " + String.format("%.1f", average) + "입니다.");

		if(kor >= 90) {
			System.out.println("국어점수가 우수합니다.");
		}
		if(eng >= 90) {
			System.out.println("영어점수가 우수합니다.");
		}
		if(math >= 90) {
			System.out.println("수학점수가 우수합니다.");
		}
	}
	public static void main(String[] args) {
		B06 t = new B06();
		t.run();
	}

}
