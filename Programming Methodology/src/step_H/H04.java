package step_H;

import java.util.Random;
import java.util.Scanner;

public class H04 {
	void run(){
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		int com_finger;
		int my_finger = -1;
		int[][] score = new int[2][3];
		//[0][0] com draw	[1][0] my draw
		//[0][1] com win	[1][1] my win
		//[0][2] com lose	[1][2] my lose
		while(my_finger != 0){
			com_finger = r.nextInt(3) + 1;
			System.out.println("����(1), ����(2), ��(3)�� �Է��ϼ���.  ");
			my_finger = s.nextInt();
			if(com_finger == my_finger){
				if(com_finger == 1){
					System.out.println("��ǻ�Ͱ� �� ���� ���� �Դϴ�. => ���~");
				}else if(com_finger == 2){
					System.out.println("��ǻ�Ͱ� �� ���� ���� �Դϴ�. => ���~");
				}else if(com_finger ==3){
					System.out.println("��ǻ�Ͱ� �� ���� �� �Դϴ�. => ���~");
				}
				score[0][0]++;
				score[1][0]++;
			}else if(com_finger == 1 && my_finger == 2){//com lose
				System.out.println("��ǻ�Ͱ� �� ���� �����Դϴ�. => ����� ��!");
				score[0][2]++;
				score[1][1]++;
			}else if(com_finger == 1 && my_finger == 3){//com win
				System.out.println("��ǻ�Ͱ� �� ���� �����Դϴ�. => ��ǻ�� ��");
				score[0][1]++;
				score[1][2]++;
			}else if(com_finger == 2 && my_finger == 1){//com win
				System.out.println("��ǻ�Ͱ� �� ���� �����Դϴ�. => ��ǻ�� ��");
				score[0][1]++;
				score[1][2]++;
			}else if(com_finger == 2 && my_finger == 3){//com lose
				System.out.println("��ǻ�Ͱ� �� ���� �����Դϴ�. => ����� ��!");
				score[0][2]++;
				score[1][1]++;
			}else if(com_finger == 3 && my_finger == 1){//com lose
				System.out.println("��ǻ�Ͱ� �� ���� ���Դϴ�. => ����� ��!");
				score[0][2]++;
				score[1][1]++;
			}else if(com_finger == 3 && my_finger == 2){//com win
				System.out.println("��ǻ�Ͱ� �� ���� ���Դϴ�. => ��ǻ�� ��");
				score[0][1]++;
				score[1][2]++;
			}
		}
		System.out.println("��ǻ�� : �̱� Ƚ���� " + score[0][1] + "ȸ, �� Ƚ���� " + score[0][2] + "ȸ, ��� Ƚ���� " + score[0][0] + "�Դϴ�.");
		System.out.println("����� : �̱� Ƚ���� " + score[1][1] + "ȸ, �� Ƚ���� " + score[1][2] + "ȸ, ��� Ƚ���� " + score[1][0] + "�Դϴ�.");
		s.close();
	}
	public static void main(String[] args) {
		H04 t = new H04();
		t.run();
	}
}
