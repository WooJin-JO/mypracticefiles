package step_F;

import java.util.Scanner;

public class F02 {
	void run() {
		Scanner s = new Scanner(System.in);
		double[] score = new double[10];
		double maxscore = Integer.MIN_VALUE;
		double minscore = Integer.MAX_VALUE;
		double total = 0;
		double average = 0;
		for(int i = 0; i < 10; i++) {
			System.out.print((i+1) + "�� �ɻ������� �Է��Ͻÿ�.");
			score[i] = s.nextDouble();
			if(score[i] > maxscore) {
				maxscore = score[i];
			}
			if(score[i] < minscore) {
				minscore = score[i];
			}
		}
		for(int i = 0; i < 10; i++) {
			total += score[i];
			average = (total - maxscore - minscore) / 8;
		}System.out.println("���� ū ������ ���� ���� ������ ������ 8���� ������ ���� ����� " + String.format("%.1f", average) + " �Դϴ�.");
		s.close();
	}
	public static void main(String[] args) {
		F02 t = new F02();
		t.run();
	}
}
