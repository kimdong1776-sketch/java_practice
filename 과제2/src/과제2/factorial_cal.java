package 과제2;

import java.util.Scanner;

public class factorial_cal {
	public static void a() {
		Scanner input = new Scanner(System.in);
		System.out.println("\n>>");
		int n = input.nextInt();
		int temp = 1;
		for(int i = 1 ; i <= n; i++) {
			temp *= i;
		}
		System.out.println("a : " + temp);
	}
	public static void b() {
		Scanner input = new Scanner(System.in);
		System.out.println(">>");
		int n = input.nextInt();
		int temp = 1;
		double result = 1;
		for(int i = 1 ; i <= n; i++) {
			temp *= i;
			result += 1/temp;
		}
		System.out.println("b : " + result);
	}
	public static void c() {
		Scanner input = new Scanner(System.in);
		System.out.println(">>");
		int n = input.nextInt();
		int x = input.nextInt();
		int temp = 1;
		double result = 1;
		for(int i = 1 ; i <= n; i++) {
			temp *= i;
			for(int j = 1; j <= x; j++) {
				x *= x;
			}
			result += x/temp;
		}
		System.out.println("c : " + result);
	}
	
}
