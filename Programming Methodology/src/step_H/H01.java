package step_H;

import java.util.Random;
import java.util.Scanner;

public class H01 {
	void run(){
		int answer;
		int number_try;
		int count = 0;
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		answer = r.nextInt(99) + 1;
		System.out.print("1���� 100������ ���� �ϳ��� ���纸����. ");
		number_try = s.nextInt();
		while(answer != number_try){
			if(answer > number_try){
				System.out.println("�� �� ū ���Դϴ�.");
				count++;
				System.out.print("1���� 100������ ���� �ϳ��� ���纸����. ");
				number_try = s.nextInt();
			}else if(answer < number_try){
				System.out.println("�� �� ���� ���Դϴ�.");
				count++;
				System.out.print("1���� 100������ ���� �ϳ��� ���纸����. ");
				number_try = s.nextInt();
			}
		}
		if(answer == number_try){
			count++;
			System.out.println(count + "������ ���ڸ� ���߼̽��ϴ�.");
		}s.close();
	}
	public static void main(String[] args) {
		H01 t = new H01();
		t.run();
	}
}