package midtestpractice3;

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreManager{
	Scanner s = new Scanner(System.in);
	ArrayList<Score> scores; // 경기결과객체들()
	String teamname[]; // 팀이름()
	int count_game[], count_win[], count_draw[], count_lose[], point[];
	// 팀별경기수(int[]), 팀별승리경기수(int[]), 팀별패배경기수(int[]), 팀별무승부경기수(int[]), 팀별승점수(int[])
	int gameno; //현재 게임번호
	public ScoreManager(){
		scores = new ArrayList<Score>();
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
		String d = s.next();
		System.out.print("홈팀 번호와 점수를 입력하세요 : ");
		int h = s.nextInt();
		int s1 = s.nextInt();
		System.out.print("원정팀 번호와 점수를 입력하세요 : ");
		int a = s.nextInt();
		int s2 = s.nextInt();
		gameno++;
		count_game[h]++;
		count_game[a]++;
		Score sco = new Score(gameno, h, a, s1, s2, d);
		scores.add(sco);
		if(s1 > s2){
			count_win[h] += 1;
			count_lose[a] += 1;
			point[h] += 3;
		}else if(s1 < s2){
			count_win[a] += 1;
			count_lose[h] += 1;
			point[a] += 3;			
		}else{
			count_draw[h] += 1;
			count_draw[a] += 1;
			point[h] += 1;
			point[a] += 1;
		}
	}
	//경기결과수정(modifyScore)
	void modifyScore(){
		System.out.println("수정 할 경기번호를 입력해 주세요.");
		int modify_num = s.nextInt() - 1;
		int gameno = scores.get(modify_num).no;
		int h = scores.get(modify_num).home;
		int a = scores.get(modify_num).away;
		int s1 = scores.get(modify_num).h_score;
		int s2 = scores.get(modify_num).a_score;
		String d = scores.get(modify_num).date;
		if(s1 > s2){
			count_win[h] -= 1;
			count_lose[a] -= 1;
			point[h] -= 3;
		}else if(s1 < s2){
			count_win[a] -= 1;
			count_lose[h] -= 1;
			point[a] -= 3;			
		}else{
			count_draw[h] -= 1;
			count_draw[a] -= 1;
			point[h] -= 1;
			point[a] -= 1;
		}
		System.out.println("수정된 홈팀의 점수를 입력해 주세요.");
		s1 = s.nextInt();
		System.out.println("수정된 원정팀의 점수를 입력해 주세요.");
		s2 = s.nextInt();
		Score sco = new Score(gameno, h, a, s1, s2, d);
		scores.set(modify_num, sco);
		if(s1 > s2){
			count_win[h] += 1;
			count_lose[a] += 1;
			point[h] += 3;
		}else if(s1 < s2){
			count_win[a] += 1;
			count_lose[h] += 1;
			point[a] += 3;			
		}else{
			count_draw[h] += 1;
			count_draw[a] += 1;
			point[h] += 1;
			point[a] += 1;
		}
	}
	//등록된모든경기결과출력(listScores)
	void listScores(){
		System.out.println("경기일련번호	경기일자	홈팀	스코어	원정팀");
		for(int i = 0; i < scores.size(); i++){
			System.out.println("[" + scores.get(i).no + "]	" + scores.get(i).date + "	" + teamname[scores.get(i).home] + "	" + scores.get(i).h_score + " : " + scores.get(i).a_score + "	" + teamname[scores.get(i).away]);
		}
	}
	//경기결과검색(findScores)
	void findScores(int no){
		System.out.println("검색 할 팀 번호를 입력해주세요.");
		no = s.nextInt();
		for(int i = 0; i < scores.size(); i++){
			if(scores.get(i).home == no || scores.get(i).away == no){
				System.out.println("[" + scores.get(i).no + "]	" + scores.get(i).date + "	" + teamname[scores.get(i).home] + "	" + scores.get(i).h_score + " : " + scores.get(i).a_score + "	" + teamname[scores.get(i).away]);
			}
		}System.out.println("검색하신 " + teamname[no] + "의 현재 전적은 " + count_win[no] + "승 " + count_draw[no] + "무 " + count_lose[no] + "패 입니다.");
	}
	void findScores(String name){
		int i = 0;
		int j = 0;
		System.out.println("검색 할 팀 이름을 입력해주세요.");
		name = s.next();
		for(i = 0; i < teamname.length; i++){
			if(teamname[i].equals(name)){
				j = i;
			}
		}
		for(i = 0; i < scores.size(); i++){
			if(scores.get(i).home == j || scores.get(i).away == j){
				System.out.println("[" + scores.get(i).no + "]	" + scores.get(i).date + "	" + teamname[scores.get(i).home] + "	" + scores.get(i).h_score + " : " + scores.get(i).a_score + "	" + teamname[scores.get(i).away]);
			}
		}System.out.println("검색하신 " + teamname[j] + "의 현재 전적은 " + count_win[j] + "승 " + count_draw[j] + "무 " + count_lose[j] + "패 입니다.");
	}
	//경기통계(viewResult)
	void viewResult(){
		int j = 0;
		int first = Integer.MIN_VALUE;
		System.out.println("팀번호	팀이름	승리	무승부	패배	승점");
		for(int i = 0; i < teamname.length; i++){
			System.out.println("[" + i + "]	" + teamname[i] + "	" + count_win[i] + "	" + count_draw[i] + "	" + count_lose[i] + "	" + point[i]);
			if(point[i] > first){
				first = point[i];
				j = i;
			}
		}System.out.println("현재 1위 팀은 " + teamname[j] + "입니다.");
	}
	//상대전적(viewMatchScore)
	void viewMatchScore(){
		int t1 = 0;
		int t2 = 0;
		int win = 0;
		int draw = 0;
		int lose = 0;
		System.out.println("상대전적을 알고 싶은 팀 번호 2개를 입력해 주세요.");
		t1 = s.nextInt();
		t2 = s.nextInt();
		for(int i = 0; i < scores.size(); i++){
			if(scores.get(i).home == t1 && scores.get(i).away == t2){
				if(scores.get(i).h_score > scores.get(i).a_score){
					win += 1;
				} else if (scores.get(i).h_score < scores.get(i).a_score){
					lose += 1;
				} else {
					draw += 1;
				}
			}if(scores.get(i).home == t2 && scores.get(i).away == t1){
				if(scores.get(i).h_score > scores.get(i).a_score){
					lose += 1;
				} else if(scores.get(i).h_score < scores.get(i).a_score){
					win += 1;
				} else {
					draw += 1;
				}
			}if((scores.get(i).home == t1 && scores.get(i).away == t2) || (scores.get(i).home == t2 && scores.get(i).away == t1)){
				System.out.println("[" + scores.get(i).no + "]	" + scores.get(i).date + "	" + teamname[scores.get(i).home] + "	" + scores.get(i).h_score + " : " + scores.get(i).a_score + "	" + teamname[scores.get(i).away]);
			}
		}System.out.println("[" + t1 + "] " + teamname[t1] + "의 " + "[" + t2 + "] " + teamname[t2] + "에 대한 상대 전적은 " + win + "승 " + draw + "무 " + lose + "패 입니다.");
		
	}
	//관리작업진행(start)
	void start(){
		int menu;
		Boolean go = true;
		for (int i=0;i<4;i++){
			System.out.print((i+1) + "번 팀의 이름은?");
			teamname[i] = s.next();
		}
		while(go){
			System.out.println("1.스코어등록, 2.스코어수정, 3.전체스코어출력, 4.스코어검색,5.경기통계, 6.상대전적, 7.종료");
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
				listScores();
				break;
			case 4 :
				String name = null;
				int no = 0;
				int select;
				System.out.println("검색 방법을 선택해주세요. (1: 팀 번호 / 2: 팀 이름)");
				select = s.nextInt();
				if(select == 1){
					findScores(no);
				} else if(select == 2){
					findScores(name);
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
		ScoreManager t = new ScoreManager();
		t.start();
	}
}