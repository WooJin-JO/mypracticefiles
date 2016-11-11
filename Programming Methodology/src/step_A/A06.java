package step_A;

import java.util.Scanner;

public class A06 {
	void run(){
		Scanner s = new Scanner(System.in);
		System.out.print("국어 점수를 입력하세요.");
		int kor = s.nextInt();
		
		System.out.print("영어의 점수를 입력하세요.");
		int eng = s.nextInt();
		
		System.out.print("수학 점수를 입력하세요.");
		int math = s.nextInt();
		s.close();
		
		int total = kor + eng + math;
		double average = total / 3.0;
		
		System.out.print("입력하신 점수의 총점은 " + total + " 이고,");
		System.out.print("평균은 " + String.format("%.1f", average) + " 입니다.");
	}
	public static void main(String[] args) {
		A06 t = new A06();
		t.run();
	}

}
