package step_H;

import java.util.Scanner;

public class H08 {
	void run() {
		Scanner s = new Scanner(System.in);
		String input;
		String findStr = new String();
		String replaceStr = new String();
		int i = 0;
		System.out.println("============================");
		System.out.println("=> 문자열을 입력하세요 (x : 종료) : ");
		input = s.nextLine();
		while(!input.equals("x")) {
			System.out.print("=> 찾을 문자열을 입력하세요 : ");
			findStr = s.nextLine();
			System.out.print("=> 바꿀 문자열을 입력하세요 : ");
			replaceStr = s.nextLine();
			while(input.indexOf(findStr) != -1) {
				input = input.replaceFirst(findStr, replaceStr);
				i++;
			}
			System.out.println("=> 총 " + i + "번 바뀌었습니다.");
			i = 0;
			System.out.println(input);
			System.out.println("============================");
			System.out.println("=> 문자열을 입력하세요 (x : 종료) : ");
			input = s.nextLine();
		}
		System.out.println("* 종료되었습니다.");
		s.close();
	}
	public static void main(String[] args) {
		H08 t = new H08();
		t.run();
	}
}
