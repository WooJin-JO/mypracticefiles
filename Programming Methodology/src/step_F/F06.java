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
				System.out.print((i+1) + "0" + ho + "호에 살고 있는 사람의 숫자를 입력하시오.");
				newnum = s.nextInt();
				number[i][j] = newnum;
				total += number[i][j];
			}
		}System.out.println("이 아파트에 사는 거주자는 모두 " + total + "명 입니다.");
		s.close();
	}
	public static void main(String[] args) {
		F06 t = new F06();
		t.run();
	}
}
