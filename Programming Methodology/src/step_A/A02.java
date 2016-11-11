package step_A;

import java.util.Scanner;

public class A02 {
	void run(){
		Scanner s = new Scanner(System.in);
		System.out.print("섭씨 온도를 입력하시오.");
		double c_degree = s.nextDouble();
		double f_degree = c_degree * 1.8 + 32;
		s.close();
		
		System.out.print("화씨 온도는 " + f_degree + " 도 입니다.");
	}

	public static void main(String[] args) {
		A02 t = new A02();
		t.run();
	}

}
