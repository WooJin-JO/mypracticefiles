package step_F;

import java.util.Scanner;

public class F05 {
	void run() {
		Scanner s = new Scanner(System.in);
		int height = 0;
		int weight = 0;
		double bmi = 0;
		double[][] bmilist = new double[10][3];
		int count = 0;
		int i = 0;
		for(i = 0; i < 10; i++) {
			System.out.print((i+1) + "��° ����� ����(cm)�� ü��(kg)�� �Է��Ͻÿ�.");
			height = s.nextInt();
			weight = s.nextInt();
			bmilist[i][0] = height;
			bmilist[i][1] = weight;
			bmi = weight / (Math.pow(height, 2)/10000);
			bmilist[i][2] = bmi;
		}for(i = 0; i <10; i++) {
			if(bmilist[i][2] > 25) {
			count++;
			System.out.println((i+1) + "��° ����� ���Դϴ�.");
			}
		}System.out.println();
		System.out.println("�� " + count + "���� ����� ���Դϴ�.");
		s.close();
	}
	public static void main(String[] args) {
		F05 t = new F05();
		t.run();
	}
}
