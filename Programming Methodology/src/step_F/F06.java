package step_F;

import java.util.Scanner;

public class F06 {
	void run(){
		Scanner s = new Scanner(System.in);
		int[][] number = new int[5][3];
		int newnum = 0;
		int total = 0;
		int ho = 0;
		int i = 0;
		int j = 0;
		for(i = 0; i < 5; i++){
			for(j = 0; j < 3; j++){
				ho = j + 1;
				System.out.print((i+1) + "0" + ho + "ȣ�� ��� �ִ� ����� ���ڸ� �Է��Ͻÿ�.");
				newnum = s.nextInt();
				number[i][j] = newnum;
				total += number[i][j];
			}
		}System.out.println("�� ����Ʈ�� ��� �����ڴ� ��� " + total + "�� �Դϴ�.");
		s.close();
	}
	public static void main(String[] args) {
		F06 t = new F06();
		t.run();
	}
}
