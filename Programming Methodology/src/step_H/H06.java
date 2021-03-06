package step_H;

import java.util.Scanner;

public class H06 {
	void run(){
		Scanner s = new Scanner(System.in);
		int[] number = new int[5];
		int[][] pow_value = new int[5][5];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int max_a = 0;
		int max_b = 0;
		int min_a = 0;
		int min_b = 0;
		int i;
		int j;
		System.out.println("2에서 9 사이의 숫자 5개를 입력하세요.");
		for(i = 0; i < 5; i++){
			number[i] = s.nextInt();
			if(number[i] < 2 || number[i] > 9){
				i--;
				System.out.println("2에서 9 사이의 숫자 5개를 입력하세요.");
			}
		}
		for(i = 0; i < 5; i++){
			for(j = 0; j < 5; j++){
				if(number[i] != number[j]){
					pow_value[i][j] = (int)Math.pow(number[i], number[j]);
					if(max < pow_value[i][j]){
						max = pow_value[i][j];
						max_a = number[i];
						max_b = number[j];
					}
					if(min > pow_value[i][j]){
						min = pow_value[i][j];
						min_a = number[i];
						min_b = number[j];
					}
				}
			}
		}
		System.out.println();
		System.out.println("입력하신 5개의 수로 제곱수를 만들면...");
		System.out.println("가장 큰 수는 " + max_a + "의 " + max_b + "승인 " + max + "입니다.");
		System.out.println("가장 작은 수는 " + min_a + "의 " + min_b + "승인 " + min + "입니다.");
		s.close();
	}
	public static void main(String[] args) {
		H06 t = new H06();
		t.run();
	}
}
