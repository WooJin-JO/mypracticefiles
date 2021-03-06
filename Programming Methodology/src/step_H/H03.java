package step_H;

import java.util.Random;
import java.util.Scanner;

public class H03 {
	void run(){
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		int[] lotto_com = new int[6];
		int[] lotto_user = new int[6];
		int user;
		int i;
		int count;
		int match_count = 0;
		for(i = 0; i < lotto_com.length; i++){
			lotto_com[i] = r.nextInt(45) + 1;
			for(count = 0; count < i; count++){
				if(lotto_com[count] == lotto_com[i]){
					lotto_com[i] = r.nextInt(45) + 1;
					count = -1;
				}
			}
		}
		for(i = 0; i < lotto_user.length; i++){
			System.out.print("원하는 " + (i+1) + "번째 로또 숫자를 입력하세요.  ");
			user = s.nextInt();
			if(user < 0 || user > 45){
				System.out.println("잘못 입력하셨습니다.");
				i--;
			}else{
				lotto_user[i] = user;
			}
			for(count = 0; count < i; count++){
				if(lotto_user[count] == user){
					System.out.println("잘못 입력하셨습니다.");
					i--;
					break;
				}else{
					lotto_user[i] = user;
				}
			}
		}
		System.out.println();
		System.out.print("이번 주의 로또 당첨 번호는 ");
		for(i = 0; i < lotto_com.length; i++){
			System.out.print(lotto_com[i] + "  ");
		}
		System.out.println("입니다.");
		
		for(i = 0; i < lotto_com.length; i++){
			for(count = 0; count < lotto_user.length; count++){
				if(lotto_com[i] == lotto_user[count]){
					match_count++;
				}
			}
		}
		System.out.println("일치하는 로또 번호는 " + match_count + "개 입니다.");
		s.close();
	}
	public static void main(String[] args) {
		H03 t = new H03();
		t.run();
	}
}
