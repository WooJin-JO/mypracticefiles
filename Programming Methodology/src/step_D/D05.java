package step_D;

import java.util.Scanner;

public class D05 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("���簢���� ���� ũ��� ���� ũ�⸦ �Է��Ͻÿ�. : ");
		int width = s.nextInt();
		int height = s.nextInt();
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		while (width > 0 & height > 0) {
			System.out.print("���簢���� ���� ũ��� ���� ũ�⸦ �Է��Ͻÿ�. : ");
			width = s.nextInt(); height = s.nextInt();
			if (width == height) {
				count1++;
			} else if (width > 2*height) {
				count2++;
			} else if (2*width < height) {
				count3++;
			} else if (width > height) {
				count4++;
			} else {
				count5++;
			}
		} s.close();
		System.out.println("\"���簢��\"�� ������ " + count1 + " �Դϴ�.");
		System.out.println("\"�¿�� ������ ���簢��\"�� ������ " + count2 + " �Դϴ�.");
		System.out.println("\"���Ʒ��� ������ ���簢��\"�� ������ " + count3 + " �Դϴ�.");
		System.out.println("\"�Ϲ����� ������ ���簢��\"�� ������ " + count4 + " �Դϴ�.");
		System.out.println("\"�Ϲ����� ������ ���簢��\"�� ������ " + count5 + " �Դϴ�.");

	}
	public static void main(String[] args) {
		D05 t = new D05();
		t.run();
	}
}
