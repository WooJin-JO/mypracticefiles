package practice;

import java.util.Scanner;

public class C05fix_t {
	void run()
	{Scanner s = new Scanner(System.in);
	//월(month)과 일(day)을 입력받음
	int month = s.nextInt();
	int day = s.nextInt();
	s.close();
	//만약 1월이면 날짜(day_count)는 day
	int daycount=0;
	//숫자 목록을 준비{31,28,31,30,31,30,31,31,30,31,30,31}
	int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
	//월까지를 반복하면서
	for (int i = 0; i < month-1; i++) {
		daycount += days[i];
	}
	//숫자목록의 수를 누적해서 합산
	//예: 5월이면... 숫자목록중에서 4개를 합산 31+28+31+30
	//합산된 숫자에 day를 더함
	daycount += day;
	/*if (month == 1) daycount = day;
	//만약 2월이면 날짜는 day + 31
	else if (month == 2) daycount = day +31;
	//만약 3월이면 날짜는 day + 31 + 28
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
	//만약 12월이면 날짜는 day + 31 + 28 + 31 + ... + 30
	else if (month == 12) daycount = day +31+28+31+30+31+30+31+31+30+31+30;*/
	//날짜를 출력
	System.out.println(daycount + "번째 날입니다.");
	}
	public static void main(String[] args) {
		C05fix_t t = new C05fix_t();
		t.run();
	}

}
