package step_G;

import java.util.Scanner;

public class G07 {
	void run() {
		Scanner s = new Scanner(System.in);
		int team_count = 0;
		int[] charge = {5000, 10000, 15000, 3000};
		int[] count = new int[4];
		int[] v_count = new int[4];
		int total_count = 0;
		int sum = 0;
		int total_sum = 0;
		int membership = 0;
		int i = 0;
		int j = 0;
		System.out.print("오늘 방문한 팀 수를 입력하세요.");
		team_count = s.nextInt();
		for(i = 0; i < team_count; i++) {
			System.out.print((i+1) + "번팀 인원수 (초등학생, 청소년, 일반, 경로대상)을 입력하세요.");
			for(j = 0; j < count.length; j++) {
				count[j] = s.nextInt();
				total_count += count[j];
				v_count[j] += count[j];
			}sum = count[0] * charge[0] + count[1] * charge[1] + count[2] * charge[2] + count[3] * charge[3];
			System.out.print((i+1) + "번팀 할인카드 종류(카드없음 : 0, 일반등급 : 1, VIP등급 : 2)를 입력하세요.");
			membership = s.nextInt();
			if(membership == 0) {
				sum = sum * 1;
			} else if(membership == 1) {
				sum = sum * 90 / 100;
			} else if(membership == 2) {
				sum = sum * 80 / 100;
			}System.out.println((i+1) + "번팀 입장료는 " + sum + "원입니다.");
			total_sum += sum;
		}System.out.println("오늘 총 방문자 수는 " + total_count + "명입니다.");
		System.out.println("초등학생 수는 " + v_count[0] + "명입니다.");
		System.out.println("청소년 수는 " + v_count[1] + "명입니다.");
		System.out.println("일반인 수는 " + v_count[2] + "명입니다.");
		System.out.println("경로대상 수는 " + v_count[3] + "명입니다.");
		System.out.println();
		System.out.println("총 입장료는 " + total_sum + "원입니다.");
		s.close();
	}
	public static void main(String[] args) {
		G07 t = new G07();
		t.run();
	}

}
