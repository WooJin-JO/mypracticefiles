package step_A;

import java.util.Scanner;

public class A03 {
	void run(){
		Scanner s = new Scanner(System.in);
		System.out.print("���簢���� ���� ũ�⸦ �Է��Ͻÿ�.");
		int width = s.nextInt();
				
		System.out.print("���簢���� ���� ũ�⸦ �Է��Ͻÿ�.");
		int height = s.nextInt();
		int area = width * height;
		s.close();
		
		System.out.print("���簢���� ���̴� " + area + "�Դϴ�.");
	}

	public static void main(String[] args) {
		A03 t = new A03();
		t.run();

	}

}
