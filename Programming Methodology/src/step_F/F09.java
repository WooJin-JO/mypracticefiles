package step_F;

import java.util.Scanner;

public class F09 {
	void run() {
		Scanner s = new Scanner(System.in);
		int[] monthdays = {31,28,31,30,31,30,31,31,30,31,30,31};
		int month = 0;
		int day = 0;
		int day_count = 0;
		int i = 0;
		System.out.print("���� �Է��Ͻÿ�.");
		month = s.nextInt();
		System.out.print("���� �Է��Ͻÿ�.");
		day = s.nextInt();
		if ((month < 1 || month > 12 || day < 1 || day > 31) || (month == 2 && day >28)){
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		} else {
			for(i = 1; i < month; i++){
				day_count += monthdays[i];
			}day_count = day_count + day;
			System.out.println("�� ��¥�� 1�� �� " + day_count + "��° ���� �ش�˴ϴ�.");
		}
		s.close();
	}
	public static void main(String[] args) {
		F09 t = new F09();
		t.run();
	}
}
