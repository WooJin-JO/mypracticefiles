package step_G;

import java.util.Scanner;

public class G01 {
	void run(){
		Scanner s = new Scanner(System.in);
		int birth_year = 0;
		int[] age = new int[100];
		int count_person = 0;
		int count_baby = 0;
		int count_child = 0;
		int count_youth = 0;
		int count_young = 0;
		int count_adult = 0;
		int count_old = 0;
		int i = 0;
		for(i = 0; i < 100; i++){
			System.out.print((i+1) + "번째 사람의 태어난 년도를 입력하시오.");
			birth_year = s.nextInt();
			if(birth_year > 2016){
				break;
			}age[i] = 2016 - birth_year + 1;
			if(age[i] < 7){
				count_baby++;
			} else if(age[i] < 13){
				count_child++;
			} else if(age[i] < 20){
				count_youth++;
			} else if(age[i] < 30){
				count_young++;
			} else if(age[i] < 60){
				count_adult++;
			} else {
				count_old++;
			} count_person++;
		}for(i = 0; i < count_person; i++){
			System.out.println((i+1) + "번째 사람의 나이는 " + age[i] + " 입니다.");
		}System.out.println("유아는 " + count_baby +"명 입니다.");
		System.out.println("어린이는 " + count_child +"명 입니다.");
		System.out.println("청소년는 " + count_youth +"명 입니다.");
		System.out.println("청년는 " + count_young +"명 입니다.");
		System.out.println("중년는 " + count_adult +"명 입니다.");
		System.out.println("노년는 " + count_old +"명 입니다.");
		s.close();
	}
	public static void main(String[] args) {
		G01 t = new G01();
		t.run();
	}
}
