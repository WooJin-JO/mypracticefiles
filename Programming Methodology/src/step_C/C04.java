package step_C;

import java.util.Scanner;

public class C04 {
	void run () {
		Scanner s = new Scanner(System.in);
		System.out.print("아파트의 분양 면적(제곱미터)을 입력하시오.");
		double m2_area = s.nextDouble();
		double pyung_area = m2_area / 3.305;
		System.out.println("아파트의 평형은 " + String.format("%.1f", pyung_area) + "입니다.");
		s.close();
		if (pyung_area < 15) {
			System.out.println("소형 아파트 입니다.");
		} else if (pyung_area <30) {
			System.out.println("중소형 아파트 입니다.");
		} else if (pyung_area <50) {
			System.out.println("중형 아파트 입니다.");
		} else {
			System.out.println("대형 아파트 입니다.");
		}
	}
	public static void main(String[] args) {
		C04 t = new C04();
		t.run();
	}

}
