package step_A;

import java.util.Scanner;

public class A02 {
	void run(){
		Scanner s = new Scanner(System.in);
		System.out.print("���� �µ��� �Է��Ͻÿ�.");
		double c_degree = s.nextDouble();
		double f_degree = c_degree * 1.8 + 32;
		s.close();
		
		System.out.print("ȭ�� �µ��� " + f_degree + " �� �Դϴ�.");
	}

	public static void main(String[] args) {
		A02 t = new A02();
		t.run();
	}

}
