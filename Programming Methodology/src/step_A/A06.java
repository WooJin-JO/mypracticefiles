package step_A;

import java.util.Scanner;

public class A06 {
	void run(){
		Scanner s = new Scanner(System.in);
		System.out.print("���� ������ �Է��ϼ���.");
		int kor = s.nextInt();
		
		System.out.print("������ ������ �Է��ϼ���.");
		int eng = s.nextInt();
		
		System.out.print("���� ������ �Է��ϼ���.");
		int math = s.nextInt();
		s.close();
		
		int total = kor + eng + math;
		double average = total / 3.0;
		
		System.out.print("�Է��Ͻ� ������ ������ " + total + " �̰�,");
		System.out.print("����� " + String.format("%.1f", average) + " �Դϴ�.");
	}
	public static void main(String[] args) {
		A06 t = new A06();
		t.run();
	}

}
