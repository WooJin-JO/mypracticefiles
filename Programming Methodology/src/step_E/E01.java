package step_E;

import java.util.Scanner;

public class E01 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("���簢���� ũ�⸦ �Է��Ͻÿ�.");
		int length = s.nextInt();
		s.close();
		for (int i = 1; i <= length; i++) {
			for (int j = 1; j <= length; j++) {
				System.out.print("#");
			}System.out.println("");
		}
	}
	public static void main(String[] args) {
		E01 t = new E01();
		t.run();
	}

}
