package midtestpractice2;

import java.util.Scanner;

public class BankAccount{
	private int account_num = 0;
	private String name;
	private int account_amount = 0;
	private int credit = 0;
	Scanner s = new Scanner(System.in);
	public BankAccount(int an, String n, int aa, int c){
		account_num = an;
		name = n;
		account_amount = aa;
		credit =c;
	}
	public int getAccount_num() {
		return account_num;
	}
	public void setAccount_num(int account_num) {
		this.account_num = account_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccount_amount() {
		return account_amount;
	}
	public void setAccount_amount(int account_amount) {
		this.account_amount = account_amount;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	void save(){
		int save;
		System.out.println("입금 할 금액을 입력해 주세요.");
		save = s.nextInt();
		account_amount += save;
	}
	void draw(){
		int draw;
		System.out.println("출금 할 금액을 입력해 주세요.");
		draw = s.nextInt();
		account_amount -= draw;
	}
	
	void getAmount(){
		System.out.println("현재 통자의 잔액은 " + account_amount + "원 입니다.");
	}
}

