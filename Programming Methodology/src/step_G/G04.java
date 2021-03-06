package step_G;

import java.util.Scanner;

public class G04 {
	void run(){
		Scanner s = new Scanner(System.in);
		int kind = 1;//거래종류(1:매매, 2:임대, 0:계산종료)
		int money = 0;//거래금액
		int charge = 0;//중개 수수료
		int total_charge = 0;//수수료 총액
		while(kind != 0){
			System.out.print("부동산 거래종류(1:매매, 2:임대, 0:계산종료)를 입력하세요. :  ");
			kind = s.nextInt();
			if(kind != 1 && kind != 2 && kind != 0){
				System.out.print("부동산 거래종류(1:매매, 2:임대, 0:계산종료)를 입력하세요. :  ");
				kind = s.nextInt();
			}
			if(kind == 1){
				System.out.print("부동산 거래금액(원)을 입력하세요 :  ");
				money = s.nextInt();
				if(money < 50000000){
					charge = (int)(money * 0.006);
					if(charge > 250000){
						charge = 250000;
					}
					total_charge += charge;
				}else if(money < 200000000){
					charge = (int)(money * 0.005);
					if(charge > 800000){
						charge = 800000;
					}
					total_charge += charge;
				}else{
					charge = (int)(money * 0.004);
					total_charge += charge;
				}
			}else if(kind == 2){
				System.out.print("부동산 거래금액(원)을 입력하세요 :  ");
				money = s.nextInt();
				if(money < 20000000){
					charge = (int)(money * 0.005);
					if(charge > 70000){
						charge = 70000;
					}
					total_charge += charge;
				}else if(money < 50000000){
					charge = (int)(money * 0.005);
					if(charge > 200000){
						charge = 200000;
					}
					total_charge += charge;
				}else if(money < 100000000){
					charge = (int)(money * 0.004);
					if(charge > 300000){
						charge = 300000;
					}
					total_charge += charge;
				}else{
					charge = (int)(money * 0.003);
					total_charge += charge;
				}
			}else if(kind == 0){
				break;
			}
			System.out.println("이에 대한 중개 수수료는 " + charge + "원입니다.");
		}System.out.println("지금까지의 수수료 총액은 " + total_charge + "원 입니다.");
		s.close();
	}
	public static void main(String[] args) {
		G04 t = new G04();
		t.run();
	}
}
