package step_H;

import java.util.Scanner;

public class H07 {
	void run(){
		Scanner s = new Scanner(System.in);
		String input = "";
		int i;
		while(!(input.equals("x"))){
			System.out.println("===============================");
			System.out.print("=> 문자열을 입력하세요.(x: 종료) : ");
			input = s.next();
			if(!(input.equals("x"))){
				System.out.println("=> 총 문자의 개수는 " + input.length() + "개 입니다.");
				for(i = 0; i < input.length(); i++){
					System.out.println("=> " + input.charAt(i));
				}System.out.println();
			}
		}System.out.println("* 종료되었습니다.");
		s.close();
	}
	public static void main(String[] args) {
		H07 t = new H07();
		t.run();
	}
}
