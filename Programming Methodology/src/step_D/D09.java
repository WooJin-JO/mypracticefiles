package step_D;

import java.util.Scanner;

public class D09 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("����ϰ� ���� �������� �� ���� �Է��Ͻÿ�(2~9).");
		int dan = s.nextInt();
		while (dan > 9 | dan < 2) {
			System.out.println("�߸� �Է��Ͽ����ϴ�.");
			System.out.print("����ϰ� ���� �������� �� ���� �Է��Ͻÿ�(2~9).");
			dan = s.nextInt();
		}
		for (int i = 1; i < 10; i++) {
			System.out.println(dan + " x " + i + " = " + dan*i);
		} s.close();
	}
	public static void main(String[] args) {
		D09 t = new D09();
		t.run();
	}

}
