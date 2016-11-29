package practice;

import java.util.Scanner;

public class B2441 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for(int i = n; i > 0; i--){
			for(int j = n; j - i > 0; j--){
				System.out.print(" ");
			}
			for(int j = i; j > 0; j--){
				System.out.print("*");
			}System.out.println();
		}s.close();
	}
}
