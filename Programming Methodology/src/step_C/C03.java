package step_C;

import java.util.Scanner;

public class C03 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("���簢���� ���� ũ�⸦ �Է��Ͻÿ�.");
		int width = s.nextInt();
		System.out.print("���簢���� ���� ũ�⸦ �Է��Ͻÿ�.");
		int height = s.nextInt();
		s.close();
		if (width == height) {
			System.out.println("���簢���Դϴ�.");
		} else if (width > 2*height) {
			System.out.println("�¿�� ������ ���簢���Դϴ�.");
		} else if (2*width < height) {
			System.out.println("���Ʒ��� ������ ���簢���Դϴ�.");
		} else if (width > height) {
			System.out.println("�Ϲ����� ������ ���簢���Դϴ�.");
		} else {
			System.out.println("�Ϲ����� ������ ���簢���Դϴ�.");
		}
	}
	public static void main(String[] args) {
		C03 t = new C03();
		t.run();
		
	}

}
