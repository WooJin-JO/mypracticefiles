package step_B;

import java.util.Scanner;

public class B02 {
	void run(){
		Scanner s = new Scanner(System.in);
		System.out.print("�µ��� �Է��ϼ���.");
		double input_degree = s.nextDouble();
		
		System.out.print("�Է��Ͻ� �µ��� �����µ��̸� C��, ȭ���µ��̸� F�� �Է��ϼ���.");
		String kind = s.next();
		if(kind.equals("C")){
			double output_degree = input_degree * 1.8 + 32;
			System.out.println("��ȯ�� �µ��� " + output_degree + " �Դϴ�.");
		} else {
			double output_degree = (input_degree - 32) / 1.8;
			System.out.println("��ȯ�� �µ���" + output_degree + " �Դϴ�.");
		}
		s.close();
	}
	public static void main(String[] args){
		B02 t = new B02();
		t.run();
	}

}
