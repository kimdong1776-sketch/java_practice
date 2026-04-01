package 과제2;

import java.util.Scanner;

public class factorial_cal {
	public static void a() {
		Scanner input = new Scanner(System.in);
		System.out.println("항의 개수(n)을 입력하세요>> ");
		int n = input.nextInt();
		long temp = 1;
		for(int i = 1 ; i <= n; i++) {
			temp *= i;
		}
		System.out.println("a : " + temp);
	}
	public static void b() {
		Scanner input = new Scanner(System.in);
		System.out.print("항의 개수(n)를 입력하세요 (예: 10)>> ");
		int n = input.nextInt();
		double temp = 1.0;
		double result = 1.0;
		for(int i = 1 ; i <= n; i++) {
			temp *= i;
			result += 1.0/temp;
		}
		System.out.println("b : " + result);
	}
	public static void c() {
		Scanner input = new Scanner(System.in);
	    System.out.print("항의 개수(n)와 x를 입력하세요 (예: 10 2)>> ");
	    
	    int n = input.nextInt();
	    double x = input.nextDouble();
	    
	    double result = 1.0;   
	    double factorial = 1.0;
	    double powerOfX = 1.0;  
	    
	    for (int i = 1; i <= n; i++) {
	        factorial *= i;    
	        powerOfX *= x;    
	        
	        result += (powerOfX / factorial);
	    }
		System.out.println("c : " + result);
	}
	
}
