package step_B;

import java.util.Scanner;

public class B05 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("������ �Է��ϼ���");
		int days = s.nextInt();
		int seconds = days * 24 * 60 * 60;
		System.out.println("������ �ش�Ǵ� �Ⱓ�� ��� " + seconds + " ���Դϴ�.");
		s.close();
		int m_count = seconds / 1000000;
		if(m_count > 0) {
			System.out.println("100�� �ʰ� ��� " + m_count + " ���̳� ���Ե˴ϴ�.");
		}
		
	}
	public static void main(String[] args) {
		B05 t = new B05();
		t.run();
	}

}
