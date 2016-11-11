package step_G;

import java.util.Scanner;

public class G02 {
	void run(){
		Scanner s = new Scanner(System.in);
		double input_degree = 0;
		double[] degrees = new double[10];
		String[] degree_name = {"�ü�", "�̿¼�", "�¼�", "���¹�"};
		int[] count = {0, 0, 0, 0};
		int i = 0;
		int[] sel = new int[10];
		for(i = 0; i < 10; i++){
			System.out.print((i+1) + "�� ���� �µ��� �Է��Ͻÿ�. ");
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
			System.out.println((i+1) + "�� ���� �µ��� " + degrees[i] + "�� �Դϴ�. " + degree_name[sel[i]]);
		}
		for(i = 0; i < 4; i++){
			System.out.println(degree_name[i] + " �Է� Ƚ�� : " + count[i]);
		}
		s.close();
	}
	public static void main(String[] args) {
		G02 t = new G02();
		t.run();
	}
}
