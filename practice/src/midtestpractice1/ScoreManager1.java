package midtestpractice1;

import java.util.Scanner;
import java.util.ArrayList;

public class ScoreManager1 extends Score1{
	ArrayList<Score1> scores = new ArrayList<Score1>(); // �������ü��()
	String teamname[]; // ���̸�()
	int count_game[], count_win[], count_draw[], count_lose[], point[];
	// ��������(int[]), �����¸�����(int[]), �����й����(int[]), �������ºΰ���(int[]), ����������(int[])
	int gameno; //���� ���ӹ�ȣ
	int f_no;
	String name;
	Scanner s = new Scanner(System.in);
	public ScoreManager1(int n, int h, int a, int s1, int s2, String d){
		super(n, h, a, s1, s2, d);
		count_game = new int[4];
		count_win = new int[4];
		count_draw = new int[4];
		count_lose = new int[4];
		point = new int[4];
		teamname = new String[4];
		gameno = 0;
		for (int i=0;i<4;i++){
			count_game[i]=0;
			count_win[i]=0;
			count_draw[i]=0;
			count_lose[i]=0;
			point[i]=0;
		}
	}
	void printTeamname(){
		System.out.print("�� ��� : ");
		for (int i=0;i<4;i++){
			System.out.print("["+i+"]"+teamname[i] + " ");
		}
		System.out.println();
	}
	//��������
	void addScore(){
		printTeamname();
		System.out.print("������ڸ� �Է��ϼ��� : ");
		setDate(s.next());
		System.out.print("Ȩ�� ��ȣ�� ������ �Է��ϼ��� : ");
		setHome(s.nextInt());
		setH_score(s.nextInt());
		System.out.print("������ ��ȣ�� ������ �Է��ϼ��� : ");
		setAway(s.nextInt());
		setA_score(s.nextInt());
		setNo(++gameno);;
		Score1 sco = new Score1(getNo(), getHome(), getAway(), getH_score(), getA_score(), getDate());
		scores.add(sco);
		count_game[getHome()] += 1;
		count_game[getAway()] += 1;
		if(getH_score() > getA_score()) {
			count_win[getHome()] += 1;
			point[getHome()] += 3;
			count_lose[getAway()] += 1;
			point[getAway()] +=0;
		} else if (getH_score() < getA_score()) {
			count_lose[getHome()] += 1;
			point[getHome()] += 0;
			count_win[getAway()] += 1;
			point[getAway()] += 3;
		} else {
			count_draw[getHome()] += 1;
			point[getHome()] += 1;
			count_draw[getAway()] += 1;
			point[getAway()] += 1;
		}
	}
	//���������(modifyScore)
	void modifyScore(){
		System.out.println("������ ����ȣ�� �Է��ϼ���");
		int num = s.nextInt();
		num = num - 1;
		gameno = scores.get(num).getNo();
		int h = scores.get(num).getHome();
		int a = scores.get(num).getAway();
		int s1 = scores.get(num).getH_score();
		int s2 = scores.get(num).getA_score();
		if(s1 > s2) {
			count_win[h] -= 1;
			point[h] -= 3;
			count_lose[a] -= 1;
			point[a] -=0;
		} else if (s1 < s2) {
			count_lose[h] -= 1;
			point[h] -= 0;
			count_win[a] -= 1;
			point[a] -= 3;
		} else {
			count_draw[h] -= 1;
			point[h] -= 1;
			count_draw[a] -= 1;
			point[a] -= 1;
		}
		String d = scores.get(num).getDate();
		System.out.print("Ȩ��  ������ �Է��ϼ��� : ");
		s1 = s.nextInt();
		System.out.print("������ ������ �Է��ϼ��� : ");
		s2 = s.nextInt();
		Score1 sco = new Score1(gameno, h, a, s1, s2, d);
		scores.set(num, sco);
		if(s1 > s2) {
			count_win[h] += 1;
			point[h] += 3;
			count_lose[a] += 1;
			point[a] +=0;
		} else if (s1 < s2) {
			count_lose[h] += 1;
			point[h] += 0;
			count_win[a] += 1;
			point[a] += 3;
		} else {
			count_draw[h] += 1;
			point[h] += 1;
			count_draw[a] += 1;
			point[a] += 1;
		}
	}
	//��ϵȸ���������(listScores)
	void listScore(){
		System.out.println("����ȣ	��⳯¥		���̸�	����	���̸�");
		for(int i = 0; i < scores.size(); i++){
			System.out.println("[" + scores.get(i).getNo() + "]" + "	" + scores.get(i).getDate() + "	" + teamname[scores.get(i).getHome()] + "		" + scores.get(i).getH_score()+ (" : ") +scores.get(i).getA_score() + "	" + teamname[scores.get(i).getAway()]);
		}
	}
	//������˻�(findScores)
	void findScore(int f_no){
		int i = 0;
		System.out.println("�� ��ȣ�� �Է����ּ���. ");
		f_no = s.nextInt();
		System.out.println("����ȣ	��⳯¥		���̸�	����	���̸�");
		for(i = 0; i < scores.size(); i++){
			if(scores.get(i).getHome() == f_no || scores.get(i).getAway() == f_no){
				System.out.println("[" + scores.get(i).getNo() + "]" + "	" + scores.get(i).getDate() + "	" + teamname[scores.get(i).getHome()] + "		" + scores.get(i).getH_score()+ (" : ") +scores.get(i).getA_score() + "	" + teamname[scores.get(i).getAway()]);				}
		}System.out.println("�˻��Ͻ� ���� ���� ������ " + count_game[f_no] + "�� "+ count_win[f_no] + "�� " + count_draw[f_no] + "�� " + count_lose[f_no] + "��, ���� " + point[f_no] + "�� �Դϴ�.");
	}
	void findScore(String name){
		int i = 0;
		int j = i;
		System.out.println("�� �̸��� �Է����ּ���. ");
		name = s.next();
		System.out.println("����ȣ	��⳯¥		���̸�	����	���̸�");
		for(i = 0; i < teamname.length; i++){
			if(teamname[i].equals(name)){
				j = i;				}
		}
		for(i = 0; i < scores.size(); i++){
			if(scores.get(i).getHome() == j || scores.get(i).getAway() == j){
				System.out.println("[" + scores.get(i).getNo() + "]" + "	" + scores.get(i).getDate() + "	" + teamname[scores.get(i).getHome()] + "		" + scores.get(i).getH_score()+ (" : ") +scores.get(i).getA_score() + "	" + teamname[scores.get(i).getAway()]);				
			}
		}System.out.println("�˻��Ͻ� ���� ���� ������ " + count_game[j] + "�� "+ count_win[j] + "�� " + count_draw[j] + "�� " + count_lose[j] + "��, ���� " + point[j] + "�� �Դϴ�.");
	}
	//������(viewResult)
	void viewResult(){
		int max = Integer.MIN_VALUE;
		int i = 0;
		int j = 0;
		System.out.println("�� ��ȣ	�� �̸�	����	�¸�	���º�	�й�	����");
		for(i = 0; i < teamname.length; i++){
			System.out.println("[" + i + "]	" + teamname[i] + "	" + count_game[i] + "	 "+ count_win[i] + "	 " + count_draw[i] + "	 " + count_lose[i] + "	" + point[i]);
			if(point[i] > max){
				max = point[i];
				j = i;
			}
		}System.out.println("���� ���� 1�� ���� " + teamname[j] + "�Դϴ�.");
	}
	//�������(viewMatchScore)
	void viewMatchScore(){
		System.out.println("��� ������ �˻��Ϸ��� �� ��ȣ 2���� �Է��� �ּ���.");
		int team1 = s.nextInt();
		int team2 = s.nextInt();
		int win = 0;
		int draw = 0;
		int lose = 0;
		int i = 0;
		for(i = 0; i < scores.size(); i++){
			if(scores.get(i).getHome() == team1 && scores.get(i).getAway() == team2){
				if(scores.get(i).getH_score() > scores.get(i).getA_score()){
					win += 1;
				} else if (scores.get(i).getH_score() < scores.get(i).getA_score()){
					lose += 1;
				} else {
					draw += 1;
				}
			}if(scores.get(i).getHome() == team2 && scores.get(i).getAway() == team1){
				if(scores.get(i).getH_score() > scores.get(i).getA_score()){
					lose += 1;
				} else if (scores.get(i).getH_score() < scores.get(i).getA_score()){
					win += 1;
				} else {
					draw += 1;
				}
			}
		}System.out.println("[" + team1 + "]" + teamname[team1] + "�� " + "[" + team2 + "]" + teamname[team2] + " ��� ���� - "+ win + "�� " +lose + "�� " +draw + "��");
	}
	//�����۾�����(start)
	void start(){
		int menu = 0;
		boolean go=true;
		for (int i=0;i<4;i++){
			System.out.print((i+1) + "�� ���� �̸���?");
			teamname[i] = s.next();
		}
		while(go){
			System.out.println("1.���ھ���, 2.���ھ����, 3.��ü���ھ����, 4.���ھ�˻�, 5.������, 6.�������, 7.����");
			System.out.print("�޴����� : ");
			menu = s.nextInt();
			switch (menu){
			case 1 :
				addScore();
				break;
			case 2 :
				modifyScore();
				break;
			case 3 :
				listScore();
				break;
			case 4 :
				System.out.println("�˻� ����� �������ּ���. (�� ��ȣ : 1 / �� �̸� : 2)");
				int selet = s.nextInt();
				if(selet == 1){
					findScore(f_no);
				} else if(selet == 2) {
					findScore(name);
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}
				break;
			case 5 :
				viewResult();
				break;
			case 6 :
				viewMatchScore();
				break;
			case 7 :
				go=false;
				break;
			}
		}
	}
	public static void main(String[] args) {
		ScoreManager1 t = new ScoreManager1(0, 0, 0, 0, 0, null);
		t.start();
	}
}

