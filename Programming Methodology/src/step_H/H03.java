package step_H;

import java.util.Random;
import java.util.Scanner;

public class H03 {
	void run(){
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		int[] lotto_com = new int[6];
		int[] lotto_user = new int[6];
		int user;
		int i;
		int count;
		int match_count = 0;
		for(i = 0; i < lotto_com.length; i++){
			lotto_com[i] = r.nextInt(45) + 1;
			for(count = 0; count < i; count++){
				if(lotto_com[count] == lotto_com[i]){
					lotto_com[i] = r.nextInt(45) + 1;
					count = -1;
				}
			}
		}
		
		
		
		for(i = 0; i < lotto_com.length; i++){
			System.out.print(lotto_com[i] + "  ");
		}
		
		
		
		for(i = 0; i < lotto_user.length; i++){
			System.out.print("���ϴ� " + (i+1) + "��° �ζ� ���ڸ� �Է��ϼ���.  ");
			user = s.nextInt();
			if(user < 0 || user > 45){
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				i--;
			}else{
				lotto_user[i] = user;
			}
			for(count = 0; count < i; count++){
				if(lotto_user[count] == user){
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
					i--;
					break;
				}else{
					lotto_user[i] = user;
				}
			}
		}
		System.out.println();
		System.out.print("�̹� ���� �ζ� ��÷ ��ȣ�� ");
		for(i = 0; i < lotto_com.length; i++){
			System.out.print(lotto_com[i] + "  ");
		}
		System.out.println("�Դϴ�.");
		
		for(i = 0; i < lotto_com.length; i++){
			for(count = 0; count < i; count++){
				if(lotto_user[count] == lotto_com[i]){
					match_count++;
				}
			}
		}
		System.out.println("��ġ�ϴ� �ζ� ��ȣ�� " + match_count + "�� �Դϴ�.");
		s.close();
	}
	public static void main(String[] args) {
		H03 t = new H03();
		t.run();
	}
}