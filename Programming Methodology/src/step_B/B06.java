package step_B;

import java.util.Scanner;

public class B06 {
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

		if(kor >= 90) {
			System.out.println("���������� ����մϴ�.");
		}
		if(eng >= 90) {
			System.out.println("���������� ����մϴ�.");
		}
		if(math >= 90) {
			System.out.println("���������� ����մϴ�.");
		}
	}
	public static void main(String[] args) {
		B06 t = new B06();
		t.run();
	}

}
