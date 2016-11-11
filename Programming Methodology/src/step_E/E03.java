package step_E;

import java.util.Scanner;

public class E03 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("이등변 삼각형의 높이를 입력하시오.");
		int height = s.nextInt();
		s.close();
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < height-i-1; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < (2*i+1); j++) {
				System.out.print("*");
			}System.out.println();
		}
	}
	public static void main(String[] args) {
		E03 t = new E03();
		t.run();
	}

}
