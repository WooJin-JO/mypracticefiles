package step_C;

import java.util.Scanner;

public class C07 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("���� �뷮�� �ް�����Ʈ ������ �Է��ϼ���");
		int megabytes = s.nextInt();
		System.out.print("���۹���� 1: Wi-Fi, 2: BlueTooth, 3: LTE, 4: USB ���� �����Ͽ� �Է��ϼ���.");
		byte kind = s.nextByte();
		s.close();
		long bytes = megabytes * 1024 * 1024;
		double time = 0;
		if (kind == 1) {
			time = bytes / 1500000.0;
			System.out.println("���� ���� �ð��� " + String.format("%.1f", time) + "�� �Դϴ�.");
		} else if (kind == 2) {
			time = bytes / 300000.0;
			System.out.println("���� ���� �ð��� " + String.format("%.1f", time) + "�� �Դϴ�.");
		} else if (kind == 3) {
			time = bytes / 1000000.0;
			System.out.println("���� ���� �ð��� " + String.format("%.1f", time) + "�� �Դϴ�.");
		} else if (kind == 4) {
			time = bytes / 60000000.0;
			System.out.println("���� ���� �ð��� " + String.format("%.1f", time) + "�� �Դϴ�.");
		}
	}
	public static void main(String[] args) {
		C07 t = new C07();
		t.run();
	}

}
