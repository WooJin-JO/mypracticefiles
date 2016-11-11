package step_A;

import java.util.Scanner;

public class A03 {
	void run(){
		Scanner s = new Scanner(System.in);
		System.out.print("직사각형의 가로 크기를 입력하시오.");
		int width = s.nextInt();
				
		System.out.print("직사각형의 세로 크기를 입력하시오.");
		int height = s.nextInt();
		int area = width * height;
		s.close();
		
		System.out.print("직사각형의 넓이는 " + area + "입니다.");
	}

	public static void main(String[] args) {
		A03 t = new A03();
		t.run();

	}

}
