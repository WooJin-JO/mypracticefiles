package step_C;

import java.util.Scanner;

public class C07 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("파일 용량을 메가바이트 단위로 입력하세요");
		int megabytes = s.nextInt();
		System.out.print("전송방식을 1: Wi-Fi, 2: BlueTooth, 3: LTE, 4: USB 에서 선택하여 입력하세요.");
		byte kind = s.nextByte();
		s.close();
		long bytes = megabytes * 1024 * 1024;
		double time = 0;
		if (kind == 1) {
			time = bytes / 1500000.0;
			System.out.println("파일 전송 시간은 " + String.format("%.1f", time) + "초 입니다.");
		} else if (kind == 2) {
			time = bytes / 300000.0;
			System.out.println("파일 전송 시간은 " + String.format("%.1f", time) + "초 입니다.");
		} else if (kind == 3) {
			time = bytes / 1000000.0;
			System.out.println("파일 전송 시간은 " + String.format("%.1f", time) + "초 입니다.");
		} else if (kind == 4) {
			time = bytes / 60000000.0;
			System.out.println("파일 전송 시간은 " + String.format("%.1f", time) + "초 입니다.");
		}
	}
	public static void main(String[] args) {
		C07 t = new C07();
		t.run();
	}

}
