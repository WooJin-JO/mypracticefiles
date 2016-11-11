package step_B;

import java.util.Scanner;

public class B07 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("파일 용량을 메가바이트 단위로 입력하세요");
		int megabytes = s.nextInt();
		System.out.print("USB 포트가 2.0. 이면 Y, 아니면 N을 입력하세요.");
		String usb2 = s.next();
		s.close();
		long bytes = megabytes * 1024 * 1024;
		if (usb2.equals("Y")) {
			int time = (int) (bytes / 60000000);
			System.out.println("파일 전송 시간은 " + time + "초 입니다.");
		} else if (usb2.equals("N")) {
			int time = (int) (bytes / 1500000);
			System.out.println("파일 전송 시간은 " + time + "초 입니다.");
		}
	}
	public static void main(String[] args) {
		B07 t = new B07();
		t.run();
	}

}
