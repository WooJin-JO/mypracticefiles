package step_B;

import java.util.Scanner;

public class B04 {
	void run(){
		Scanner s = new Scanner(System.in);
		System.out.print("����Ʈ�� �о� ����(��������)�� �Է��Ͻÿ�.");
		double m2_area = s.nextDouble();
		double pyung_area = m2_area / 3.305;
		s.close();
		System.out.println("����Ʈ�� ������ " + String.format("%.1f", pyung_area) + "�̰�.");
		
		if(pyung_area < 30) {
			System.out.print("30�� �̸��̹Ƿ� ���� ����Ʈ�Դϴ�.");
		} else {
			System.out.print("30�� �̻��̹Ƿ� ū ����Ʈ�Դϴ�.");
		}
	}
	public static void main(String[] args){
		B04 t = new B04();
		t.run();
	}

}
