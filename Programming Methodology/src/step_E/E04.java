package step_E;

import java.util.Scanner;

public class E04 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("�������� ��¸��(1: Ȧ����, 2:¦����)�� �Է��Ͻÿ�.");
		int mode = s.nextInt();
		s.close();
		if(mode == 1) {
			for(int i = 1; 2*i+1<10; i++) {
				for(int j = 1; j < 10; j++) {
					System.out.print((2*i+1) + "x" + j + "=" + (2*i+1)*j + "	");
					if (j%3 == 0) {
						System.out.println();
					}
				}System.out.println();
			}
		} else if(mode ==2) {
			for(int i =1; 2*i<10; i++) {
				for(int j = 1; j < 10; j++) {
					System.out.print((2*i) + "x" + j + "=" + (2*i)*j + "	");
					if(j%3 ==0) {
						System.out.println();
					}
				}System.out.println();
			}
		}
	}
	public static void main(String[] args) {
		E04 t = new E04();
		t.run();
	}

}
