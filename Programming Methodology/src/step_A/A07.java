package step_A;

import java.util.Scanner;

public class A07 {
	void run(){
		Scanner s = new Scanner(System.in);
		System.out.print("파일 용량을 기가바이트 단위로 입력하세요.");
		int gigabytes = s.nextInt();
		int megabytes = gigabytes * 1024;
		int kilobytes = megabytes * 1024;
		long bytes = kilobytes * 1024L;
		s.close();
		
		System.out.println("입력하신 파일 용량은");
		System.out.println(megabytes + "메가바이트,");
		System.out.println(kilobytes + "킬로바이트,");
		System.out.println(bytes + "바이트 입니다.");		
	}
	public static void main(String[] args){
		A07 t = new A07();
		t.run();
	}

}
