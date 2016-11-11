package step_A;

import java.util.Scanner;

public class A04 {
	void run(){
		Scanner s = new Scanner(System.in);
		System.out.print("아파트의 분양 면적을 입력하시오.");
		double m2_area = s.nextDouble();
		double pyung_area = m2_area / 3.305;
		s.close();
		
		System.out.print("아파트의 평형은 " + String.format("%.1f", pyung_area) + "입니다.");
	}
	
	public static void main(String[] args) {
		A04 t = new A04();
		t.run();
	}

}
