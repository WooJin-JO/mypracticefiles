package step_D;

import java.util.Scanner;

public class D05 {
	void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("직사각형의 가로 크기와 세로 크기를 입력하시오. : ");
		int width = s.nextInt();
		int height = s.nextInt();
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		while (width > 0 & height > 0) {
			System.out.print("직사각형의 가로 크기와 세로 크기를 입력하시오. : ");
			width = s.nextInt(); height = s.nextInt();
			if (width == height) {
				count1++;
			} else if (width > 2*height) {
				count2++;
			} else if (2*width < height) {
				count3++;
			} else if (width > height) {
				count4++;
			} else {
				count5++;
			}
		} s.close();
		System.out.println("\"정사각형\"의 개수는 " + count1 + " 입니다.");
		System.out.println("\"좌우로 길쭉한 직사각형\"의 개수는 " + count2 + " 입니다.");
		System.out.println("\"위아래로 길쭉한 직사각형\"의 개수는 " + count3 + " 입니다.");
		System.out.println("\"일반적인 가로형 직사각형\"의 개수는 " + count4 + " 입니다.");
		System.out.println("\"일반적인 세로형 직사각형\"의 개수는 " + count5 + " 입니다.");

	}
	public static void main(String[] args) {
		D05 t = new D05();
		t.run();
	}
}
