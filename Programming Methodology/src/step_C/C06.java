package step_C;

import java.util.Scanner;

public class C06 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("���� ������ �Է��ϼ���");
		int kor = s.nextInt();
		System.out.print("���� ������ �Է��ϼ���");
		int eng = s.nextInt();
		System.out.print("���� ������ �Է��ϼ���");
		int math = s.nextInt();
		s.close();
		int total = kor + eng + math;
		double average = total / 3.0;
		System.out.println("�Է��Ͻ� ������ ������ " + total + "�̰�,");
		System.out.println("����� " + String.format("%.1f", average) + "�Դϴ�.");

		if(average >= 90) {
			System.out.println("�� �Դϴ�.");
		} else if(average >= 80) {
			System.out.println("�� �Դϴ�.");
		} else if(average >= 70) {
			System.out.println("�� �Դϴ�.");
		} else if (average >= 60) {
			System.out.println("�� �Դϴ�.");
		} else {
			System.out.println("�� �Դϴ�.");
		}
	}
	public static void main(String[] args) {
		C06 t = new C06();
		t.run();
	}

}
