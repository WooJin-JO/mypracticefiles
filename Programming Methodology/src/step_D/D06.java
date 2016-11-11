package step_D;

import java.util.Scanner;

public class D06 {
	void run() {
		Scanner s = new Scanner(System.in);
		double m2_area = 0;
		double pyung_area = 0;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		for (int i = 0; i < 10; i++) {
			System.out.print("아파트의 분양 면적(제곱미터)을 입력하시오.");
			m2_area = s.nextDouble();
			pyung_area = m2_area / 3.305;
			System.out.println("--> 이 아파트의 평형은 " + String.format("%.1f", pyung_area) + " 입니다.");
			if (pyung_area < 15) {
				count1++;
			} else if (pyung_area < 30) {
				count2++;
			} else if (pyung_area < 50) {
				count3++;
			} else {
				count4++;
			}
		} s.close();
		System.out.println("\"소형아파트\"의 개수는 " + count1 + " 입니다.");
		System.out.println("\"중소형아파트\"의 개수는 " + count2 + " 입니다.");
		System.out.println("\"중형아파트\"의 개수는 " + count3 + " 입니다.");
		System.out.println("\"대형아파트\"의 개수는 " + count4 + " 입니다.");
	}
	public static void main(String[] args) {
		D06 t = new D06();
		t.run();
	}

}
