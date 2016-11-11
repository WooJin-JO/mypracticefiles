package step_B;

import java.util.Scanner;

public class B09 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("신장(cm단위)을 입력하세요");
		int height = s.nextInt();
		System.out.print("체중(kg단위)를 입력하세요");
		int weight = s.nextInt();
		s.close();
		int bmi = weight / ((height*height)/10000);
		if (bmi >= 25) {
			System.out.println("당신은 비만이십니다.");
		} else {
			System.out.println("당신은 비만이 아니군요.");
		}
		
	}
	public static void main(String[] args) {
		B09 t = new B09();
		t.run();
	}
}
