package step_F;

import java.util.Scanner;

public class F01 {
	void run() {
		Scanner s = new Scanner(System.in);
		int[] num = new int[10];
		int first = 0;
		int secound = 0;
		int secound_max_index = 0;
		int newnum = 0;
		int i = 0;
		for(i = 0; i < 10; i++) {
			System.out.print((i+1) + "��° ���� �Է��Ͻÿ�. ");
			num[i] = s.nextInt();
			if(num[i] > first) {
				newnum = first;
				first = num[i];
			}
			if (first >= num[i] & num[i] > newnum) {
				secound = newnum;
				secound_max_index = i;
			}
		} System.out.println("�� ��°�� ū ���� " + secound_max_index + "��° �� " + secound + "�Դϴ�.");
		s.close();
	}
	public static void main(String[] args) {
		F01 t = new F01();
		t.run();
	}

}
