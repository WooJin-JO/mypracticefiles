package step_D;

import java.util.Scanner;

public class D03 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("0부터 100 사이의 숫자를 입력하세요");
		int count = 0;
		int totalsum = 0;
		int number = s.nextInt();
		while (number > 0 & number < 100) {
			totalsum = totalsum + number;
			count++;
			System.out.print("0부터 100 사이의 숫자를 입력하세요");
			number = s.nextInt();
			double average = (double)(totalsum) / (double)(count);
			if (number < 0 | number > 100) {
			System.out.println("입력한 " + count + " 개의 숫자들의 총합계는 " + totalsum + "이고, 평균 값은 " + average + " 입니다.");
			}
		} s.close();
	}
	public static void main(String[] args) {
		D03 t = new D03();
		t.run();
	}

}
