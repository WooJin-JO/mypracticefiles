package midtestpractice;

public class Score {
	private int no, home, away, h_score, a_score;
	// ����Ϸù�ȣ(int), Ȩ����ȣ(int), ��������ȣ(int), Ȩ������(int), ����������(int);
	String date; //�������(String)
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getHome() {
		return home;
	}
	public void setHome(int home) {
		this.home = home;
	}
	public int getAway() {
		return away;
	}
	public void setAway(int away) {
		this.away = away;
	}
	public int getH_score() {
		return h_score;
	}
	public void setH_score(int h_score) {
		this.h_score = h_score;
	}
	public int getA_score() {
		return a_score;
	}
	public void setA_score(int a_score) {
		this.a_score = a_score;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Score(int no, int home, int away, int h_score, int a_score, String date){
		setNo(no);
		setHome(home);
		setAway(away);
		setH_score(h_score);
		setA_score(a_score);
		setDate(date);
	}
	public String toString(){
		return getNo() + "	" + getDate() + "	" + getHome() + "		" + getH_score()+ (" : ") +getA_score() + "	" + getAway();
	}
}
