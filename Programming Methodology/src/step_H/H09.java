package step_H;

import java.util.Scanner;

public class H09 {
	void run(){
		Scanner s = new Scanner(System.in);
		String input = "";
		String[] userList = new String[100];
		String[] userInfo = new String[100];
		int i;
		while(!(input.equals("x"))){
			System.out.println("============================");
			System.out.println("=> ���ڿ��� �Է��ϼ��� (x : ����) : ");
			input = s.nextLine();
			userList = input.split("\\###");
			if(!(input.equals("x"))){
				System.out.println("");
				System.out.println("=> �� " + userList.length + "���� ��� �Ǿ����ϴ�.");
				for(i = 0; i < userList.length; i++){
					userInfo = userList[i].split("\\|");
					System.out.println((i+1) + "  " + userInfo[0] + "  " + userInfo[1]);
				}
			}
		}System.out.println("* ����Ǿ����ϴ�.");
		s.close();
	}
	public static void main(String[] args) {
		H09 t = new H09();
		t.run();
	}
}