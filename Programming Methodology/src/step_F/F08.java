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
		System.out.println("1부터 100사이의 숫자를 입력하시오.");
		while(0 <= newnum && newnum <= 100 && count < 10){
			for(count = 0; count < 10; count++){
				System.out.print((count+1) + "번째 숫자를 입력하시오.");
				newnum = s.nextInt();
				number[count] = newnum;
				if (newnum == number[count-1]){
				System.out.println("잘못 입력하였습니다. 다시 입력하세요.");
				System.out.print((count+1) + "번째 숫자를 입력하시오.");
				newnum = s.nextInt();
				number[count] = newnum;
				} else {
					continue;
					}
				}
			}
		for(i = 0; i < 10; i++){
			System.out.println((i+1) + "번째 숫자는 " + number[i] + "입니다.");
		}s.close();
	}
	public static void main(String[] args) {
		F08 t = new F08();
		t.run();
	}
}
