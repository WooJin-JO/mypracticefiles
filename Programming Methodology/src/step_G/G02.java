package step_G;

import java.util.Scanner;

public class G02 {
	void run(){
		Scanner s = new Scanner(System.in);
		double input_degree = 0;
		double[] degrees = new double[10];
		String[] degree_name = {"냉수", "미온수", "온수", "끓는물"};
		int[] count = {0, 0, 0, 0};
		int i = 0;
		int[] sel = new int[10];
		for(i = 0; i < 10; i++){
			System.out.print((i+1) + "번 물의 온도를 입력하시오. ");
			input_degree = s.nextDouble();
			degrees[i] = input_degree;
			if(input_degree < 25){
				count[0]++;
				sel[i] = 0;
			} else if(input_degree < 40){
				count[1]++;
				sel[i] = 1;
			} else if(input_degree < 80){
				count[2]++;
				sel[i] = 2;
			} else {
				count[3]++;
				sel[i] = 3;
			}
		}
		for(i = 0; i < 10; i++){
			System.out.println((i+1) + "번 물의 온도는 " + degrees[i] + "도 입니다. " + degree_name[sel[i]]);
		}
		for(i = 0; i < 4; i++){
			System.out.println(degree_name[i] + " 입력 횟수 : " + count[i]);
		}
		s.close();
	}
	public static void main(String[] args) {
		G02 t = new G02();
		t.run();
	}
}
