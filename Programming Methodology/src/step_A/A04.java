package step_A;

import java.util.Scanner;

public class A04 {
	void run(){
		Scanner s = new Scanner(System.in);
		System.out.print("����Ʈ�� �о� ������ �Է��Ͻÿ�.");
		double m2_area = s.nextDouble();
		double pyung_area = m2_area / 3.305;
		s.close();
		
		System.out.print("����Ʈ�� ������ " + String.format("%.1f", pyung_area) + "�Դϴ�.");
	}
	
	public static void main(String[] args) {
		A04 t = new A04();
		t.run();
	}

}
