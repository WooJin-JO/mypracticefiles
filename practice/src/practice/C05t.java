package practice;

import java.util.Scanner;

public class C05t {
	void run()
	{Scanner s = new Scanner(System.in);
	//��(month)�� ��(day)�� �Է¹���
	int month = s.nextInt();
	int day = s.nextInt();
	s.close();
	//���� 1���̸� ��¥(day_count)�� day
	int daycount=0;
	if (month == 1) daycount = day;
	//���� 2���̸� ��¥�� day + 31
	else if (month == 2) daycount = day +31;
	//���� 3���̸� ��¥�� day + 31 + 28
	else if (month == 3) daycount = day +31+28;
	//...
	else if (month == 4) daycount = day +31+28+31;
	else if (month == 5) daycount = day +31+28+31+30;
	else if (month == 6) daycount = day +31+28+31+30+31;
	else if (month == 7) daycount = day +31+28+31+30+31+30;
	else if (month == 8) daycount = day +31+28+31+30+31+30+31;
	else if (month == 9) daycount = day +31+28+31+30+31+30+31+31;
	else if (month == 10) daycount = day +31+28+31+30+31+30+31+31+30;
	else if (month == 11) daycount = day +31+28+31+30+31+30+31+31+30+31;
	//���� 12���̸� ��¥�� day + 31 + 28 + 31 + ... + 30
	else if (month == 12) daycount = day +31+28+31+30+31+30+31+31+30+31+30;
	//��¥�� ���
	System.out.println(daycount + "��° ���Դϴ�.");
	}
	public static void main(String[] args) {
		C05t t = new C05t();
		t.run();
	}

}
