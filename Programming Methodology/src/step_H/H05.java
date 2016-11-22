package step_H;

import java.util.Random;
import java.util.Scanner;

public class H05 {
	void run(){
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		int coins;
		int[] number = new int[3];
		@SuppressWarnings("unused")
		int dummy;
		int count = 1;
		int i;
		System.out.print("사용하실 코인의 개수를 입력하세요.  ");
		coins = s.nextInt();
		while(coins > 0){
			for(i = 0; i < number.length; i++){
				number[i] = r.nextInt(9)+1;
			}
			System.out.print("게임 " + count + "회  Start!!! (아무 숫자나 입력하세요.)");
			dummy = s.nextInt();
			count++;
			coins--;
			System.out.print("게임 결과 : " + number[0] + "  " + number[1] + "  " + number[2] + "  =>");
			if(number[0] == number[1] && number[1] == number[2]){
				System.out.println("숫자 3개 일치... 코인 4개 증정");
				coins += 4;
				System.out.println("남아있는 코인은" + coins + "개 입니다.");
			}else if(number[0] == number[1] || number[1] == number[2] || number[2] == number[0]){
				System.out.println("숫자 2개 일치... 코인 2개 증정");
				coins += 2;
				System.out.println("남아있는 코인은" + coins + "개 입니다.");
			}else{
				System.out.println("꽝입니다... 아쉽군요...");
				System.out.println("남아있는 코인은" + coins + "개 입니다.");
			}
		}System.out.println();
		System.out.println("게임 종료!!");
		s.close();
	}
	public static void main(String[] args) {
		H05 t = new H05();
		t.run();
	}
}
