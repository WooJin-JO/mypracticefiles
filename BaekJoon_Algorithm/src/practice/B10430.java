package practice;

import java.util.Scanner;

public class B10430 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
		int j = s.nextInt();
		int k = s.nextInt();
		System.out.println((i + j) % k);
		System.out.println((i % k + j % k) % k);
		System.out.println((i * j) % k);
		System.out.println((i % k * j % k) % k);
		s.close();
	}
}
