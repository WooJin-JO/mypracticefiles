package midtestpractice2;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager extends BankAccount {
	Scanner s = new Scanner(System.in);
	ArrayList<AccountManager> account = new ArrayList<AccountManager>();
	int an = 0;
	public AccountManager(int an, String n, int aa, int c){
		super(an, n, aa, c);
	}
	void addAcount(){
		System.out.println("통장을 새로 개설합니다");
		System.out.println("예금주 이름을 입력해 주세요.");
		String n = s.next();
		System.out.println("통장 계설시 입금 할 금액을 입력해 주세요.");
		int aa = s.nextInt();
		System.out.println("신용등급을 입력해주세요.(1~3)");
		int c = s.nextInt();
		while(!(c == 1 || c == 2 || c == 3)){
			System.out.println("잘못 입력하셨습니다.");
			c = s.nextInt();
		}
		an++;
		AccountManager acc = new AccountManager(an, n, aa, c);
		account.add(acc);
	}
	void saveMoney(){
		int i = 0;
		System.out.println("입금 할 통장의 번호를 입력해 주세요.");
		i = s.nextInt() - 1;
		System.out.println("입금 할 금액을 입력해 주세요.");
		int save = s.nextInt();
		account.get(i).setAccount_amount(account.get(i).getAccount_amount() + save);
		System.out.println("현재 통장 잔액은 " + account.get(i).getAccount_amount() + "원 입니다.");
	}
	void drawMoney(){
		int i = 0;
		System.out.println("출금 할 통장의 번호를 입력해 주세요.");
		i = s.nextInt() - 1;
		System.out.println("출금 할 금액을 입력해 주세요.");
		int draw = s.nextInt();
		if(account.get(i).getAccount_amount() <= draw){
			if(account.get(i).getCredit() == 1){
				account.get(i).setAccount_amount(account.get(i).getAccount_amount() - draw);
			} else {
				System.out.println("잔액이 부족합니다.");
			}
		}
		System.out.println("현재 통장 잔액은 " + account.get(i).getAccount_amount() + "원 입니다.");
	}
	void printAccount(){
		System.out.println("통장번호	예금주	신용등급	잔액");
		for(int i = 0; i < account.size(); i++){
			System.out.println(account.get(i).getAccount_num() +"	" + account.get(i).getName() +"	[" + account.get(i).getCredit() + "]	" + account.get(i).getAccount_amount());
		}
	}
	void viewAccount(){
		System.out.println("확인하고자 하는 통장의 예금주를 입력하세요.");
		String f_name = s.next();
		for(int i = 0; i < account.size(); i++){
			if(account.get(i).getName().equals(f_name)){
				System.out.println("예금주 : " + account.get(i).getName());
				System.out.println("통장번호 : " + account.get(i).getAccount_num());
				System.out.println("신용등급 : " + account.get(i).getCredit());
				System.out.println("통장 잔액 : " + account.get(i).getAccount_amount());
			} else {
				System.out.println("해당 예금주가 없거나 잘못 입력하셨습니다.");
			}
		}
	}
	void transferMoney(){
		System.out.println("출금 통장 번호와 입금 통장 번호, 송금액을 순서대로 입력해주세요.");
		int draw = s.nextInt() - 1;
		int save = s.nextInt() - 1;
		int trans = s.nextInt();
		if(account.get(draw).getAccount_amount() <= trans){
			if(account.get(draw).getCredit() == 1){
				account.get(draw).setAccount_amount(account.get(draw).getAccount_amount() - trans);
				account.get(save).setAccount_amount(account.get(save).getAccount_amount() + trans);
			} else {
				System.out.println("잔액이 부족합니다.");
			}
		} else {
			account.get(draw).setAccount_amount(account.get(draw).getAccount_amount() - trans);
			account.get(save).setAccount_amount(account.get(save).getAccount_amount() + trans);
		}
		System.out.println("송금 되었습니다.");
		System.out.println(account.get(draw).getAccount_num() +"	" + account.get(draw).getName() +"	[" + account.get(draw).getCredit() + "]	" + account.get(draw).getAccount_amount());
		System.out.println(account.get(save).getAccount_num() +"	" + account.get(save).getName() +"	[" + account.get(save).getCredit() + "]	" + account.get(save).getAccount_amount());
	}
	void putInterest(){
		for(int i = 0; i < account.size(); i++){
			if(account.get(i).getCredit() == 1 && account.get(i).getAccount_amount() > 0){
				account.get(i).setAccount_amount(account.get(i).getAccount_amount() * 103 / 100);
			} else if(account.get(i).getCredit() == 2 && account.get(i).getAccount_amount() > 0) {
				account.get(i).setAccount_amount(account.get(i).getAccount_amount() * 102 / 100);
			} else if(account.get(i).getCredit() == 3 && account.get(i).getAccount_amount() > 0) {
				account.get(i).setAccount_amount(account.get(i).getAccount_amount() * 101 / 100);
			}
		}
	}
	void start(){
		boolean go = true;
		int menu;
		while(go){
			System.out.println("메뉴를 선택하세요 : 1.개설  2.입금  3.출금  4.송금  5.이자지급  6.통장내역출력  7.모든통장보기  8.종료");
			menu = s.nextInt();
			switch(menu){
			case 1 :
				addAcount();
				break;
			case 2 :
				saveMoney();
				break;
			case 3 :
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
		AccountManager test = new AccountManager(0, null, 0, 0);
		test.start();
	}
}
