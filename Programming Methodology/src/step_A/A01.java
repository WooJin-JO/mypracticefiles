package step_A;

import java.util.Scanner;

public class A01 {
	void run(){
		Scanner s = new Scanner(System.in);
		System.out.print("�¾ �⵵�� �Է��Ͻÿ�.");
		int birth_year = s.nextInt();
		int age = 2016 - birth_year + 1;
		s.close();
		
		System.out.print("����� ���̴� "+ age + "�� �Դϴ�.");
		
	}
	public static void main(String[] args) {
		A01 t = new A01();
		t.run();
	}

}
