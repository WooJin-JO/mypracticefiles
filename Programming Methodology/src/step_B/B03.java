package step_B;

import java.util.Scanner;

public class B03 {
	void run(){
		Scanner s = new Scanner(System.in);
		System.out.print("���簢���� ���� ũ�⸦ �����Ͻÿ�.");
		int width = s.nextInt();
		
		System.out.print("���簢���� ���� ũ�⸦ �Է��Ͻÿ�.");
		int height = s.nextInt();
		int area = width * height;
		System.out.println("���簢���� ���̴� " + area + "�̰�");
		s.close();
		if(width == height){
			System.out.print("���簢���Դϴ�.");
		} else {
			System.out.print("���簢���� �ƴմϴ�.");
		}
	}
	public static void main(String[] args){
		B03 t = new B03();
		t.run();
	}

}
