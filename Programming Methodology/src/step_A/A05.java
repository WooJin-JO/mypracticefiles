package step_A;

import java.util.Scanner;

public class A05 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("�� ���� �Է��ϼ���.");
		int days = s.nextInt();
		int seconds = days * 24 * 60 * 60;
		s.close();
		
		System.out.print("������ �ش�Ǵ� �ð��� ���" + seconds + " �� �Դϴ�.");	
	}
	public static void main(String[] args) {
		A05 t = new A05();
		t.run();
	}

}
