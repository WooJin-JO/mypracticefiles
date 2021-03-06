package step_G;

import java.util.Scanner;

public class G05 {
	void run(){
		Scanner s = new Scanner(System.in);
		int hour = 1;//이용시간
		int minute = 1;//이용 분
		int charge = 0;//이용료
		int total_charge = 0;//이용료 총액
		while(hour != 0 || minute != 0){
			System.out.print("사용한 시간을  시간과 분으로 입력하세요. : ");
			hour = s.nextInt();
			minute = s.nextInt();
			if(hour < 0 || minute < 0 || minute > 59){
				System.out.print("사용한 시간을  시간과 분으로 입력하세요. : ");
				hour = s.nextInt();
				minute = s.nextInt();
			}else if(hour == 0 && minute == 0){
				break;
			}
			
			if(minute == 0){
				charge = 2 * hour * 1000;
			}else if(minute <= 30){
				charge = 2 * hour * 1000 + 1000;
			}else if(minute < 60){
				charge = 2 * hour * 1000 + 2000;
			}
			
			if(hour < 2){
				charge = (int)(charge * 1.00);
				total_charge += charge;
			}else if(hour >= 2 && hour < 3){
				charge = (int)(charge * 0.95);
				total_charge += charge;
			}else if(hour < 5){
				charge = (int)(charge * 0.90);
				total_charge += charge;
			}else{
				charge = (int)(charge * 0.80);
				total_charge += charge;
			}
			System.out.println("고객님의 이용료는  " + charge + "원입니다.");
		}
		System.out.println("지금까지의 이용료 총 금액은 " + total_charge + "원입니다.");
		s.close();
	}
	public static void main(String[] args) {
		G05 t = new G05();
		t.run();
	}
}
