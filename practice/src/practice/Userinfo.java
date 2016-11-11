package practice;

import java.util.Scanner;

public class Userinfo {
	Scanner s = new Scanner(System.in);
	int student = 0; // 등록할 학생수
	String [][] idpw = new String[100000][2]; //id와 pw를 저장할 배열 생성
	int i = 0;
	void input() {
		System.out.print("등록할 학생의 명수는? ");
		student = s.nextInt();
		for(i = 0; i < student; i++) {
			System.out.print((i+1) + "번 학생의 아이디, 비밀번호를 입력하시오 --> ");
			idpw[i][0] = s.next();
			idpw[i][1] = s.next();
		}
	}
	void print() {
		System.out.println("======================");
		System.out.println("등록된 " + student + "명의 학생 목록은 다음과 같습니다.");
		System.out.println("----------------------");
		System.out.printf("%s\t", "번호");
		System.out.printf("%s\t\t", "아이디");
		System.out.printf("%s\t", "비밀번호");
		System.out.println();
		for(i=0; i < student; i++) {
			System.out.printf("%s\t", i+1);
			System.out.printf("%s\t\t", idpw[i][0]);
			System.out.printf("%s\t", idpw[i][1]);
			System.out.println();
		}
	}

	public static void main(String[] args) {
	Userinfo t = new Userinfo();
	t.input();
	t.print();
	}
}

