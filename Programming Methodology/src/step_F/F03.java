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
			System.out.print((i+1) + "�� �л� ����, ����, ���� ������ �Է��Ͻÿ�.");
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
		}System.out.println("������ ������ " + sum[0] + " �̰�, ����� " + average[0] + " �Դϴ�.");
		System.out.println("������ ������ " + sum[1] + " �̰�, ����� " + average[1] + " �Դϴ�.");
		System.out.println("������ ������ " + sum[2] + " �̰�, ����� " + average[2] + " �Դϴ�.");
		s.close();
	}
	public static void main(String[] args) {
		F03 t = new F03();
		t.run();
	}
}
