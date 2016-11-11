package step_A;

import java.util.Scanner;

public class A01 {
	void run(){
		Scanner s = new Scanner(System.in);
		System.out.print("태어난 년도를 입력하시오.");
		int birth_year = s.nextInt();
		int age = 2016 - birth_year + 1;
		s.close();
		
		System.out.print("당신의 나이는 "+ age + "살 입니다.");
		
	}
	public static void main(String[] args) {
		A01 t = new A01();
		t.run();
	}

}
