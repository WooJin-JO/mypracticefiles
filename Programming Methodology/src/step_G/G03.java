package step_G;

import java.util.Scanner;

public class G03 {
	void run(){
		Scanner s = new Scanner(System.in);
		int[][] jumsu = new int[5][3];
		double[] c_average = new double[3];
		String[] dass_name = {"국어", "영어", "수학"};
		int kor = 0;
		int eng = 0;
		int mat = 0;
		double[] sum = new double[5];
		double[] average = new double[5];
		int[] grade = new int[5];
		int i = 0;
		int j = 0;
		for(i = 0; i < 5; i++){
			System.out.print((i+1) + "번 학생의 국어, 영어, 수학 점수는? ");
			kor = s.nextInt();
			eng = s.nextInt();
			mat = s.nextInt();
			jumsu[i][0] = kor;
			jumsu[i][1] = eng;
			jumsu[i][2] = mat;
			for(j = 0; j < 3; j++){
				c_average[j] += jumsu[i][j];
				sum[i] += jumsu[i][j];
				average[i] = sum[i] / 3;
				if(average[i] < 60){
					grade[i] = 'F';
				} else if(average[i] < 70){
					grade[i] = 'D';
				} else if(average[i] < 80){
					grade[i] = 'C';
				} else if(average[i] < 90){
					grade[i] = 'B';
				} else {
					grade[i] = 'A';
				}
			}
		}
		System.out.println("1) 각 과목별 총점과 평균 점수");
		for(i = 0; i < 3; i++){
			System.out.println(dass_name[i] + " 과목 총점은 " + String.format("%.0f", c_average[i]) + " 평균은 " + String.format("%.1f", c_average[i] / 5) + "입니다.");
		}
		System.out.println();
		System.out.println("2) 각 학생별 총점과 평균 점수");
		for(i = 0; i < 5; i++){
			System.out.println((i+1) + "번 학생 점수 : 총점 " + String.format("%.0f", sum[i]) + ", 평균 " + String.format("%.1f", average[i]) + ", 등급 " + (char)grade[i]);
		}s.close();
	}
	public static void main(String[] args) {
		G03 t = new G03();
		t.run();
	}
}
