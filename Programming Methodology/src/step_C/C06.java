package step_C;

import java.util.Scanner;

public class C06 {
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

		if(average >= 90) {
			System.out.println("수 입니다.");
		} else if(average >= 80) {
			System.out.println("우 입니다.");
		} else if(average >= 70) {
			System.out.println("미 입니다.");
		} else if (average >= 60) {
			System.out.println("양 입니다.");
		} else {
			System.out.println("가 입니다.");
		}
	}
	public static void main(String[] args) {
		C06 t = new C06();
		t.run();
	}

}
