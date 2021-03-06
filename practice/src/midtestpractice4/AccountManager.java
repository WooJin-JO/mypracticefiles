package midtestpractice4;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager {
	Scanner s = new Scanner(System.in);
	ArrayList<BankAccount> bank = new ArrayList<BankAccount>();
	int account_count = 0;
	int an = 0;
	public AccountManager(){
	}
	//통장개설(addAccount)
	void addAccount(){
		String n = null;
		int aa = 0;
		int c = 0;
		System.out.println("새로운 통장을 개설합니다.");
		System.out.println("예금주 이름을 입력해주세요");
		n = s.next();
		System.out.println("개설시 입금할 금액을 입력해주세요.");
		aa = s.nextInt();
		System.out.println("신용등급을 입력해주세요.");
		c =s.nextInt();
		while(c != 1 && c != 2 && c != 3){
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			c = s.nextInt();
		}
		an++;
		account_count++;
		BankAccount account = new BankAccount(an, n, aa, c);
		bank.add(account);
	}
	//특정통장에입금하기(saveMoney)
	void saveMoney(){
		System.out.println("입금하실 통장번호를 입력해주세요.");
		int num = s.nextInt() - 1;
		System.out.println("입금하실 금액을 입력해주세요.");
		int save = s.nextInt();
		bank.get(num).account_amount += save;
		System.out.println((num + 1) + "번 통장의 현재 잔액은 " + bank.get(num).account_amount + "원 입니다.");
	}
	//정통장에서출금하기(drawMoney)
	void drawMoney(){
		System.out.println("출금하실 통장번호를 입력해주세요.");
		int num = s.nextInt() - 1;
		System.out.println("출금하실 금액을 입력해주세요.");
		int draw = s.nextInt();
		if(bank.get(num).account_amount < draw){
			if(bank.get(num).credit == 1){
				bank.get(num).account_amount -= draw;
			} else {
				System.out.println("잔액이 부족합니다.");
			}
		} else {
			bank.get(num).account_amount -= draw;
		}
//		if(bank.get(num).credit == 1){
//			bank.get(num).account_amount -= draw;
//			} else {
//				if(bank.get(num).account_amount < draw){
//					System.out.println("잔액이 부족합니다.");
//				} else {
//					bank.get(num).account_amount -= draw;
//				}
//			}
		System.out.println("현재 잔액은 " + bank.get(num).account_amount + "원 입니다.");
	}
	//송금하기(transferMoney)
	void transferMoney(){
		System.out.println("출금 통장번호와 입금통장번호, 송금액을 순서대로 입력해주세요");
		int draw = s.nextInt() - 1;
		int save = s.nextInt() - 1;
		int transfer = s.nextInt();
		if(bank.get(draw).account_amount <= transfer){
			if(bank.get(draw).credit == 1){
				bank.get(draw).account_amount -= transfer;
				bank.get(save).account_amount += transfer;
				System.out.println("송금 되었습니다.");
			} else {
				System.out.println("잔액이 부족합니다.");
				System.out.println("현재 잔액은 " + bank.get(draw).account_amount + "원 입니다.");
			}
		} else {
			bank.get(draw).account_amount -= transfer;
			bank.get(save).account_amount += transfer;
			System.out.println("송금 되었습니다.");
		}
		System.out.println("[" + bank.get(draw).account_num + "]	" + bank.get(draw).name + "	" + bank.get(draw).account_amount);
		System.out.println("[" + bank.get(save).account_num + "]	" + bank.get(save).name + "	" + bank.get(save).account_amount);
	}
	//모든통장이자지급하기(putInterest)
	void putInterest(){
		System.out.println("이자를 지급합니다.");
		for(int i = 0; i < bank.size(); i++){
			if(bank.get(i).credit == 1 && bank.get(i).account_amount > 0){
				bank.get(i).account_amount *= 103;
				bank.get(i).account_amount /= 100;
			} else if(bank.get(i).credit == 2 && bank.get(i).account_amount > 0){
				bank.get(i).account_amount *= 102;
				bank.get(i).account_amount /= 100;
			} else if(bank.get(i).credit == 3 && bank.get(i).account_amount > 0){
				bank.get(i).account_amount *= 101;
				bank.get(i).account_amount /= 100;
			}
		}
	}
	//통장정보확인(viewAccount)
	void viewAccount(){
		System.out.println("예금주 이름을 입력해주세요.");
		String name = s.next();
		for(int i = 0; i < bank.size(); i++){
			if(bank.get(i).name.equals(name)){
				System.out.println("통장 번호 : " + bank.get(i).account_num);
				System.out.println("예금주 : " + bank.get(i).name);
				System.out.println("신용등급 : " + bank.get(i).credit);
				System.out.println("잔액 : " + bank.get(i).account_amount);
			}
		}
	}
	//통장내역출력(printAccount)
	void printAccount(){
		System.out.println("모든 통장을 출력합니다.");
		System.out.println("통장 번호	예금주	신용등급	잔액");
		for(int i = 0; i < bank.size(); i++){
			System.out.println("[" + bank.get(i).account_num + "]	" + bank.get(i).name + "	" + bank.get(i).credit + "	" + bank.get(i).account_amount);
		}System.out.println("총 " + account_count + "개의 통장이 개설되어 있습니다.");
	}
	void start(){
		boolean go = true;
		int select;
		while(go){
			System.out.println("메뉴를 선택하세요. (1:개설  2:입금  3:출금 4:송금  5:이자지급  6:통장정보확인  7:통장내역출력  8:종료)");
			select = s.nextInt();
			switch(select){
			case 1 :
				addAccount();
				break;
			case 2 :
				saveMoney();
				break;
			case 3:
				drawMoney();
				break;
			case 4 :
				transferMoney();
				break;
			case 5 :
				putInterest();
				break;
			case 6 :
				viewAccount();
				break;
			case 7 :
				printAccount();
				break;
			case 8 :
				go = false;
				break;
			}
		}
	}
	public static void main(String[] args) {
		AccountManager t = new AccountManager();
		t.start();
	}
}
