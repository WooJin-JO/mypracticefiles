package midtestpractice;

import java.util.Scanner;
import java.util.ArrayList;

public class ScoreManager extends Score{
	ArrayList<Score> scores = new ArrayList<Score>(); // 경기결과객체들()
	String teamname[]; // 팀이름()
	int count_game[], count_win[], count_draw[], count_lose[], point[];
	// 팀별경기수(int[]), 팀별승리경기수(int[]), 팀별패배경기수(int[]), 팀별무승부경기수(int[]), 팀별승점수(int[])
	int gameno; //현재 게임번호
	int f_no;
	String name;
	Scanner s = new Scanner(System.in);
	public ScoreManager(int n, int h, int a, int s1, int s2, String d){
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
		System.out.print("팀 목록 : ");
		for (int i=0;i<4;i++){
			System.out.print("["+i+"]"+teamname[i] + " ");
		}
		System.out.println();
	}
	//경기결과등록
	void addScore(){
		printTeamname();
		System.out.print("경기일자를 입력하세요 : ");
		setDate(s.next());
		System.out.print("홈팀 번호와 점수를 입력하세요 : ");
		setHome(s.nextInt());
		setH_score(s.nextInt());
		System.out.print("원정팀 번호와 점수를 입력하세요 : ");
		setAway(s.nextInt());
		setA_score(s.nextInt());
		setNo(++gameno);;
		Score sco = new Score(getNo(), getHome(), getAway(), getH_score(), getA_score(), getDate());
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
	//경기결과수정(modifyScore)
	void modifyScore(){
		System.out.println("수정할 경기번호를 입력하세요");
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
		System.out.print("홈팀  점수를 입력하세요 : ");
		s1 = s.nextInt();
		System.out.print("원정팀 점수를 입력하세요 : ");
		s2 = s.nextInt();
		Score sco = new Score(gameno, h, a, s1, s2, d);
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
	//등록된모든경기결과출력(listScores)
	void listScore(){
		System.out.println("경기번호	경기날짜		팀이름	점수	팀이름");
		for(int i = 0; i < scores.size(); i++){
			System.out.println("[" + scores.get(i).getNo() + "]" + "	" + scores.get(i).getDate() + "	" + teamname[scores.get(i).getHome()] + "		" + scores.get(i).getH_score()+ (" : ") +scores.get(i).getA_score() + "	" + teamname[scores.get(i).getAway()]);
		}
	}
	//경기결과검색(findScores)
	class FindScores{
		void findScore(int f_no){
			int i = 0;
			System.out.println("팀 번호를 입력해주세요. ");
			f_no = s.nextInt();
			System.out.println("경기번호	경기날짜		팀이름	점수	팀이름");
			for(i = 0; i < scores.size(); i++){
				if(scores.get(i).getHome() == f_no || scores.get(i).getAway() == f_no){
					System.out.println("[" + scores.get(i).getNo() + "]" + "	" + scores.get(i).getDate() + "	" + teamname[scores.get(i).getHome()] + "		" + scores.get(i).getH_score()+ (" : ") +scores.get(i).getA_score() + "	" + teamname[scores.get(i).getAway()]);
				}
			}System.out.println("검색하신 팀의 현재 전적은 " + count_game[f_no] + "전 "+ count_win[f_no] + "승 " + count_draw[f_no] + "무 " + count_lose[f_no] + "패, 승점 " + point[f_no] + "점 입니다.");
		}
		void findScore(String name){
			int i = 0;
			int j = i;
			System.out.println("팀 이름을 입력해주세요. ");
			name = s.next();
			System.out.println("경기번호	경기날짜		팀이름	점수	팀이름");
			for(i = 0; i < teamname.length; i++){
				if(teamname[i].equals(name)){
					j = i;
				}
			}
			for(i = 0; i < scores.size(); i++){
				if(scores.get(i).getHome() == j || scores.get(i).getAway() == j){
					System.out.println("[" + scores.get(i).getNo() + "]" + "	" + scores.get(i).getDate() + "	" + teamname[scores.get(i).getHome()] + "		" + scores.get(i).getH_score()+ (" : ") +scores.get(i).getA_score() + "	" + teamname[scores.get(i).getAway()]);
				}
			}System.out.println("검색하신 팀의 현재 전적은 " + count_game[j] + "전 "+ count_win[j] + "승 " + count_draw[j] + "무 " + count_lose[j] + "패, 승점 " + point[j] + "점 입니다.");
		}
	}
	//경기통계(viewResult)
	void viewResult(){
		int max = Integer.MIN_VALUE;
		int i = 0;
		int j = 0;
		System.out.println("팀 번호	팀 이름	경기수	승리	무승부	패배	승점");
		for(i = 0; i < teamname.length; i++){
			System.out.println("[" + i + "]	" + teamname[i] + "	" + count_game[i] + "	 "+ count_win[i] + "	 " + count_draw[i] + "	 " + count_lose[i] + "	" + point[i]);
			if(point[i] > max){
				max = point[i];
				j = i;
			}
		}System.out.println("현재 승점 1위 팀은 " + teamname[j] + "입니다.");
	}
	//상대전적(viewMatchScore)
	void viewMatchScore(){
		System.out.println("상대 전적을 검색하려는 팀 번호 2개를 입력해 주세요.");
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
		}System.out.println("[" + team1 + "]" + teamname[team1] + "의 " + "[" + team2 + "]" + teamname[team2] + " 상대 전적 - "+ win + "승 " +lose + "패 " +draw + "무");
	}
	//관리작업진행(start)
	void start(){
		int menu = 0;
		boolean go=true;
		for (int i=0;i<4;i++){
			System.out.print((i+1) + "번 팀의 이름은?");
			teamname[i] = s.next();
		}
		while(go){
			System.out.println("1.스코어등록, 2.스코어수정, 3.전체스코어출력, 4.스코어검색, 5.경기통계, 6.상대전적, 7.종료");
			System.out.print("메뉴선택 : ");
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
				FindScores fi = new FindScores();
				System.out.println("검색 방법을 선택해주세요. (팀 번호 : 1 / 팀 이름 : 2)");
				int selet = s.nextInt();
				if(selet == 1){
					fi.findScore(f_no);
				} else if(selet == 2) {
					fi.findScore(name);
				} else {
					System.out.println("잘못 입력하셨습니다.");
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
		ScoreManager t = new ScoreManager(0, 0, 0, 0, 0, null);
		t.start();
	}
}






/*void findScore(int teamno){
	
}
void findScore(String name){
	
}*/
