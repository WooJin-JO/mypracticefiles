package step_H;

import java.util.Random;
import java.util.Scanner;

public class H02 {
	void run(){
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		int[] lotto = new int[6];
		int count;
		String onemore = null;
		int i;
		for(i = 0; i < lotto.length; i++){
			lotto[i] = r.nextInt(45) + 1;
			for(count = 0; count < i; count++){
				if(lotto[count] == lotto[i]){
					lotto[i] = r.nextInt(45) + 1;
					count = -1;
				}
			}
		}
		System.out.print("������ �ζ� ��ȣ�� ");
		for(count = 0; count < lotto.length; count++){
			System.out.print(lotto[count] + "  ");
		}
		System.out.print("�Դϴ�.");
		System.out.println();
		System.out.print("�� ����ðڽ��ϱ�? (Y/N) ");
		onemore = s.next();
		while(!(onemore.equals("N"))){
			for(i = 0; i < lotto.length; i++){
				lotto[i] = r.nextInt(45) + 1;
				for(count = 0; count < i; count++){
					if(lotto[count] == lotto[i]){
						lotto[i] = r.nextInt(45) + 1;
						count = -1;
					}
				}
			}
			System.out.print("������ �ζ� ��ȣ�� ");
			for(count = 0; count < lotto.length; count++){
				System.out.print(lotto[count] + "  ");
			}
			System.out.print("�Դϴ�.");
			System.out.println();
			System.out.print("�� ����ðڽ��ϱ�? (Y/N) ");
			onemore = s.next();
		}
		s.close();
	}
	public static void main(String[] args) {
		H02 t = new H02();
		t.run();
	}
}