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
		System.out.print("���� �湮�� �� ���� �Է��ϼ���.");
		team_count = s.nextInt();
		for(i = 0; i < team_count; i++) {
			System.out.print((i+1) + "���� �ο��� (�ʵ��л�, û�ҳ�, �Ϲ�, ��δ��)�� �Է��ϼ���.");
			for(j = 0; j < count.length; j++) {
				count[j] = s.nextInt();
				total_count += count[j];
				v_count[j] += count[j];
			}sum = count[0] * charge[0] + count[1] * charge[1] + count[2] * charge[2] + count[3] * charge[3];
			System.out.print((i+1) + "���� ����ī�� ����(ī����� : 0, �Ϲݵ�� : 1, VIP��� : 2)�� �Է��ϼ���.");
			membership = s.nextInt();
			if(membership == 0) {
				sum = sum * 1;
			} else if(membership == 1) {
				sum = sum * 90 / 100;
			} else if(membership == 2) {
				sum = sum * 80 / 100;
			}System.out.println((i+1) + "���� ������ " + sum + "���Դϴ�.");
			total_sum += sum;
		}System.out.println("���� �� �湮�� ���� " + total_count + "���Դϴ�.");
		System.out.println("�ʵ��л� ���� " + v_count[0] + "���Դϴ�.");
		System.out.println("û�ҳ� ���� " + v_count[1] + "���Դϴ�.");
		System.out.println("�Ϲ��� ���� " + v_count[2] + "���Դϴ�.");
		System.out.println("��δ�� ���� " + v_count[3] + "���Դϴ�.");
		System.out.println();
		System.out.println("�� ������ " + total_sum + "���Դϴ�.");
		s.close();
	}
	public static void main(String[] args) {
		G07 t = new G07();
		t.run();
	}

}
