package practice;

import java.util.Scanner;

public class H08 {
	void run() {
		Scanner s = new Scanner(System.in);
		String input;
		String findStr = new String();
		String replaceStr = new String();
		int i = 0;
		System.out.println("============================");
		System.out.println("=> ���ڿ��� �Է��ϼ��� (x : ����) : ");
		input = s.nextLine();
		while(!input.equals("x")) {
			System.out.print("=> ã�� ���ڿ��� �Է��ϼ��� : ");
			findStr = s.nextLine();
			System.out.print("=> �ٲ� ���ڿ��� �Է��ϼ��� : ");
			replaceStr = s.nextLine();
			while(input.indexOf(findStr) != -1) {
				input = input.replaceFirst(findStr, replaceStr);
				i++;
			}
			System.out.println("=> �� " + i + "�� �ٲ�����ϴ�.");
			i = 0;
			System.out.println(input);
			System.out.println("============================");
			System.out.println("=> ���ڿ��� �Է��ϼ��� (x : ����) : ");
			input = s.nextLine();
		}
		System.out.println("* ����Ǿ����ϴ�.");
		s.close();
	}
	public static void main(String[] args) {
		H08 t = new H08();
		t.run();
	}
}
