package step_B;

import java.util.Scanner;

public class B07 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("���� �뷮�� �ް�����Ʈ ������ �Է��ϼ���");
		int megabytes = s.nextInt();
		System.out.print("USB ��Ʈ�� 2.0. �̸� Y, �ƴϸ� N�� �Է��ϼ���.");
		String usb2 = s.next();
		s.close();
		long bytes = megabytes * 1024 * 1024;
		if (usb2.equals("Y")) {
			int time = (int) (bytes / 60000000);
			System.out.println("���� ���� �ð��� " + time + "�� �Դϴ�.");
		} else if (usb2.equals("N")) {
			int time = (int) (bytes / 1500000);
			System.out.println("���� ���� �ð��� " + time + "�� �Դϴ�.");
		}
	}
	public static void main(String[] args) {
		B07 t = new B07();
		t.run();
	}

}
