package step_B;

import java.util.Scanner;

public class B09 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("����(cm����)�� �Է��ϼ���");
		int height = s.nextInt();
		System.out.print("ü��(kg����)�� �Է��ϼ���");
		int weight = s.nextInt();
		s.close();
		int bmi = weight / ((height*height)/10000);
		if (bmi >= 25) {
			System.out.println("����� ���̽ʴϴ�.");
		} else {
			System.out.println("����� ���� �ƴϱ���.");
		}
		
	}
	public static void main(String[] args) {
		B09 t = new B09();
		t.run();
	}
}
