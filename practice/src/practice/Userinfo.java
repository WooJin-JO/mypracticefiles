package practice;

import java.util.Scanner;

public class Userinfo {
	Scanner s = new Scanner(System.in);
	int student = 0; // ����� �л���
	String [][] idpw = new String[100000][2]; //id�� pw�� ������ �迭 ����
	int i = 0;
	void input() {
		System.out.print("����� �л��� �����? ");
		student = s.nextInt();
		for(i = 0; i < student; i++) {
			System.out.print((i+1) + "�� �л��� ���̵�, ��й�ȣ�� �Է��Ͻÿ� --> ");
			idpw[i][0] = s.next();
			idpw[i][1] = s.next();
		}
	}
	void print() {
		System.out.println("======================");
		System.out.println("��ϵ� " + student + "���� �л� ����� ������ �����ϴ�.");
		System.out.println("----------------------");
		System.out.printf("%s\t", "��ȣ");
		System.out.printf("%s\t\t", "���̵�");
		System.out.printf("%s\t", "��й�ȣ");
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

