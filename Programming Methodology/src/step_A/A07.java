package step_A;

import java.util.Scanner;

public class A07 {
	void run(){
		Scanner s = new Scanner(System.in);
		System.out.print("���� �뷮�� �Ⱑ����Ʈ ������ �Է��ϼ���.");
		int gigabytes = s.nextInt();
		int megabytes = gigabytes * 1024;
		int kilobytes = megabytes * 1024;
		long bytes = kilobytes * 1024L;
		s.close();
		
		System.out.println("�Է��Ͻ� ���� �뷮��");
		System.out.println(megabytes + "�ް�����Ʈ,");
		System.out.println(kilobytes + "ų�ι���Ʈ,");
		System.out.println(bytes + "����Ʈ �Դϴ�.");		
	}
	public static void main(String[] args){
		A07 t = new A07();
		t.run();
	}

}
