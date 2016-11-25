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
		System.out.println("2���� 9 ������ ���� 5���� �Է��ϼ���.");
		for(i = 0; i < 5; i++){
			number[i] = s.nextInt();
			if(number[i] < 2 || number[i] > 9){
				i--;
				System.out.println("2���� 9 ������ ���� 5���� �Է��ϼ���.");
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
		System.out.println("�Է��Ͻ� 5���� ���� �������� �����...");
		System.out.println("���� ū ���� " + max_a + "�� " + max_b + "���� " + max + "�Դϴ�.");
		System.out.println("���� ���� ���� " + min_a + "�� " + min_b + "���� " + min + "�Դϴ�.");
		s.close();
	}
	public static void main(String[] args) {
		H06 t = new H06();
		t.run();
	}
}