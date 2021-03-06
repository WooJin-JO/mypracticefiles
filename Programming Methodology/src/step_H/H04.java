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
			System.out.println("가위(1), 바위(2), 보(3)를 입력하세요.  ");
			my_finger = s.nextInt();
			if(com_finger == my_finger){
				if(com_finger == 1){
					System.out.println("컴퓨터가 낸 것은 가위 입니다. => 비김~");
				}else if(com_finger == 2){
					System.out.println("컴퓨터가 낸 것은 바위 입니다. => 비김~");
				}else if(com_finger ==3){
					System.out.println("컴퓨터가 낸 것은 보 입니다. => 비김~");
				}
				score[0][0]++;
				score[1][0]++;
			}else if(com_finger == 1 && my_finger == 2){//com lose
				System.out.println("컴퓨터가 낸 것은 가위입니다. => 사용자 승!");
				score[0][2]++;
				score[1][1]++;
			}else if(com_finger == 1 && my_finger == 3){//com win
				System.out.println("컴퓨터가 낸 것은 가위입니다. => 컴퓨터 승");
				score[0][1]++;
				score[1][2]++;
			}else if(com_finger == 2 && my_finger == 1){//com win
				System.out.println("컴퓨터가 낸 것은 바위입니다. => 컴퓨터 승");
				score[0][1]++;
				score[1][2]++;
			}else if(com_finger == 2 && my_finger == 3){//com lose
				System.out.println("컴퓨터가 낸 것은 바위입니다. => 사용자 승!");
				score[0][2]++;
				score[1][1]++;
			}else if(com_finger == 3 && my_finger == 1){//com lose
				System.out.println("컴퓨터가 낸 것은 보입니다. => 사용자 승!");
				score[0][2]++;
				score[1][1]++;
			}else if(com_finger == 3 && my_finger == 2){//com win
				System.out.println("컴퓨터가 낸 것은 보입니다. => 컴퓨터 승");
				score[0][1]++;
				score[1][2]++;
			}
		}
		System.out.println("컴퓨터 : 이긴 횟수는 " + score[0][1] + "회, 진 횟수는 " + score[0][2] + "회, 비긴 횟수는 " + score[0][0] + "입니다.");
		System.out.println("사용자 : 이긴 횟수는 " + score[1][1] + "회, 진 횟수는 " + score[1][2] + "회, 비긴 횟수는 " + score[1][0] + "입니다.");
		s.close();
	}
	public static void main(String[] args) {
		H04 t = new H04();
		t.run();
	}
}
