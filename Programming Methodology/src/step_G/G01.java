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
			System.out.print((i+1) + "��° ����� �¾ �⵵�� �Է��Ͻÿ�.");
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
			System.out.println((i+1) + "��° ����� ���̴� " + age[i] + " �Դϴ�.");
		}System.out.println("���ƴ� " + count_baby +"�� �Դϴ�.");
		System.out.println("��̴� " + count_child +"�� �Դϴ�.");
		System.out.println("û�ҳ�� " + count_youth +"�� �Դϴ�.");
		System.out.println("û��� " + count_young +"�� �Դϴ�.");
		System.out.println("�߳�� " + count_adult +"�� �Դϴ�.");
		System.out.println("���� " + count_old +"�� �Դϴ�.");
		s.close();
	}
	public static void main(String[] args) {
		G01 t = new G01();
		t.run();
	}
}
