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
		System.out.print("1부터 100까지의 숫자 하나를 맞춰보세요. ");
		number_try = s.nextInt();
		while(answer != number_try){
			if(answer > number_try){
				System.out.println("좀 더 큰 수입니다.");
				count++;
				System.out.print("1부터 100까지의 숫자 하나를 맞춰보세요. ");
				number_try = s.nextInt();
			}else if(answer < number_try){
				System.out.println("좀 더 작은 수입니다.");
				count++;
				System.out.print("1부터 100까지의 숫자 하나를 맞춰보세요. ");
				number_try = s.nextInt();
			}
		}
		if(answer == number_try){
			count++;
			System.out.println(count + "번만에 숫자를 맞추셨습니다.");
		}s.close();
	}
	public static void main(String[] args) {
		H01 t = new H01();
		t.run();
	}
}
