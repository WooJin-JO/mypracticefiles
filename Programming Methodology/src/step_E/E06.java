package step_E;

import java.util.Scanner;

public class E06 {
	void run(){
		Scanner s = new Scanner(System.in);
		System.out.print("����Ϸ��� ���� ũ��� ���� ũ�⸦ �Է��Ͻÿ�.");
		int rows = s.nextInt();
		int columns = s.nextInt();
		int number = 0;
		s.close();
		for(int i = 1; i <= rows; i++) {
			for(int j = 1; j<= columns; j++) {
				number = i * j;
				System.out.printf("%6d", number);
			}System.out.println();
		}
	}
	public static void main(String[] args) {
		E06 t = new E06();
		t.run();
	}

}
