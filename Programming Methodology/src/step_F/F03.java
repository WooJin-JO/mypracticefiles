package step_F;

import java.util.Scanner;

public class F03 {
	void run() {
		Scanner s = new Scanner(System.in);
		int [][] jumsu = new int[5][3];
		int [] sum = new int[3];
		double[] average = new double[3];
		int kor = 0;
		int eng = 0;
		int mat = 0;
		int i = 0;
		int j = 0;
		for(i = 0; i < 5; i++) {
			System.out.print((i+1) + "번 학생 국어, 영어, 수학 점수를 입력하시오.");
			kor = s.nextInt();
			eng = s.nextInt();
			mat = s.nextInt();
			jumsu[i][0] = kor;
			jumsu[i][1] = eng;
			jumsu[i][2] = mat;
			for(j = 0; j < 3; j++){
				sum[j] += jumsu[i][j];
				average[j] = sum[j] / (double)5;
			}
		}System.out.println("국어의 총점은 " + sum[0] + " 이고, 평균은 " + average[0] + " 입니다.");
		System.out.println("영어의 총점은 " + sum[1] + " 이고, 평균은 " + average[1] + " 입니다.");
		System.out.println("수학의 총점은 " + sum[2] + " 이고, 평균은 " + average[2] + " 입니다.");
		s.close();
	}
	public static void main(String[] args) {
		F03 t = new F03();
		t.run();
	}
}
