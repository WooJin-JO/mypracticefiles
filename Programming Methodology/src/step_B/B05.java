package step_B;

import java.util.Scanner;

public class B05 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("날수를 입력하세요");
		int days = s.nextInt();
		int seconds = days * 24 * 60 * 60;
		System.out.println("날수에 해당되는 기간은 모두 " + seconds + " 초입니다.");
		s.close();
		int m_count = seconds / 1000000;
		if(m_count > 0) {
			System.out.println("100만 초가 모두 " + m_count + " 번이나 포함됩니다.");
		}
		
	}
	public static void main(String[] args) {
		B05 t = new B05();
		t.run();
	}

}
