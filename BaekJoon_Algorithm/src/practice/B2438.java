package practice;

import java.util.Scanner;

public class B2438 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= i; j++){
				System.out.print("*");
			}System.out.println();
		}
		s.close();
	}
}
