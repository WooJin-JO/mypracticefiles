package step_B;

import java.util.Scanner;

public class B01 {
	void run(){
		Scanner s = new Scanner(System.in);
		System.out.print("�¾ ������ �Է��ϼ���.");
		int birth_year = s.nextInt();
		int age = 2016 - birth_year + 1;
		s.close();
		
		if(age > 20){
			System.out.println("�̼����ڰ� �ƴմϴ�.");
		} else {
			System.out.println("�̼������Դϴ�.");
		}
	}
	public static void main(String[] args){
		B01 t = new B01();
		t.run();
	}

}
