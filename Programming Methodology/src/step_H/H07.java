package step_H;

import java.util.Scanner;

public class H07 {
	void run(){
		Scanner s = new Scanner(System.in);
		String input = "";
		int i;
		while(!(input.equals("x"))){
			System.out.println("===============================");
			System.out.print("=> ���ڿ��� �Է��ϼ���.(x: ����) : ");
			input = s.next();
			if(!(input.equals("x"))){
				System.out.println("=> �� ������ ������ " + input.length() + "�� �Դϴ�.");
				for(i = 0; i < input.length(); i++){
					System.out.println("=> " + input.charAt(i));
				}System.out.println();
			}
		}System.out.println("* ����Ǿ����ϴ�.");
		s.close();
	}
	public static void main(String[] args) {
		H07 t = new H07();
		t.run();
	}
}
