package step_F;

import java.util.Scanner;

public class F08 {
	void run(){
		Scanner s = new Scanner(System.in);
		int[] number = new int[10];
		int newnum = 0;
		int count = 0;
		//boolean dup;
		int i = 0;
		System.out.println("1���� 100������ ���ڸ� �Է��Ͻÿ�.");
		while(0 <= newnum && newnum <= 100 && count < 10){
			for(count = 0; count < 10; count++){
				System.out.print((count+1) + "��° ���ڸ� �Է��Ͻÿ�.");
				newnum = s.nextInt();
				number[count] = newnum;
				if (newnum == number[count-1]){
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է��ϼ���.");
				System.out.print((count+1) + "��° ���ڸ� �Է��Ͻÿ�.");
				newnum = s.nextInt();
				number[count] = newnum;
				} else {
					continue;
					}
				}
			}
		for(i = 0; i < 10; i++){
			System.out.println((i+1) + "��° ���ڴ� " + number[i] + "�Դϴ�.");
		}s.close();
	}
	public static void main(String[] args) {
		F08 t = new F08();
		t.run();
	}
}
