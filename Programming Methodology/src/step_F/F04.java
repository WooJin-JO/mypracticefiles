package step_F;

import java.util.Scanner;

public class F04 {
	void run() {
		Scanner s = new Scanner(System.in);
		int[][] jumsu = new int[5][3];
		int[] sum = new int[5];
		double[] average = new double[5];
		int kor = 0;
		int eng = 0;
		int mat = 0;
		int i = 0;
		int j = 0;
		for(i = 0; i < 5; i++) {
			System.out.print((i+1) + "�� �л� ����, ����, ����, ������ �Է��Ͻÿ�.");
			kor = s.nextInt();
			eng = s.nextInt();
			mat = s.nextInt();
			jumsu[i][0] = kor;
			jumsu[i][1] = eng;
			jumsu[i][2] = mat;
			for(j = 0; j < 3; j++) {
				sum[i] += jumsu[i][j];
				average[i] = sum[i] / (double)(3);
			}
		}for(i = 0; i < 5; i++) {
			System.out.println((i+1) + "�� �л��� ������ " + sum[i] + "�̰�, ����� " + String.format("%.1f", average[i]) + " �Դϴ�.");
		}s.close();
	}
	public static void main(String[] args) {
		F04 t = new F04();
		t.run();
	}
}
