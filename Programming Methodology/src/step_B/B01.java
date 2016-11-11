package step_B;

import java.util.Scanner;

public class B01 {
	void run(){
		Scanner s = new Scanner(System.in);
		System.out.print("태어난 연도를 입력하세요.");
		int birth_year = s.nextInt();
		int age = 2016 - birth_year + 1;
		s.close();
		
		if(age > 20){
			System.out.println("미성년자가 아닙니다.");
		} else {
			System.out.println("미성년자입니다.");
		}
	}
	public static void main(String[] args){
		B01 t = new B01();
		t.run();
	}

}
