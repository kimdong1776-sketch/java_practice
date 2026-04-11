package 실습3_과제;

import java.util.Scanner;
import java.security.SecureRandom;
public class Main {
	public static void main(String[] args) {
		
		//6.18
		practice.squareOfAsterisks6_18(4);
		
		System.out.println();
		System.out.println();
		//6.19
		Scanner input = new Scanner(System.in);
		char c = input .next().charAt(0);
		practice.squareOfAsterisks6_19(5, c);
		System.out.println();
		System.out.println();
		//6.24
		int temp = 0;
		for(int pn = 1; pn <= 1000; pn++) {
			
			if(practice.isPerfect(pn)) {
				System.out.print(pn +  " = ");
				System.out.print("1");
				for(int i = 2; i < pn; i++) {
					if((pn % i) == 0) {
						temp = i;
						System.out.print(" + ");
						System.out.print(temp );
					}
				}
				System.out.println();			
				
			}
			
		}
		System.out.println();
		System.out.println();
		
		//6.25
		int count;
		int tcount = 0 ;
		for(int i = 0 ; i < 10000; i++) {
			if((count = practice.isPrime(i, 0)) > 0) {
				tcount += count;
			}
		}
		System.out.printf("Squreroot Cal_count : %d\n", tcount);
		tcount = 0;
		
		for(int i = 0 ; i < 10000; i++) {
			if((count = practice.isPrime(i, 1)) > 0) {
				tcount += count;
			}
		}
		System.out.printf("n/2 Cal_count : %d\n", tcount);
		System.out.println();
		System.out.println();
		
		
		//6.26
		Scanner input1 = new Scanner(System.in);
		int num = input1.nextInt();
		System.out.printf("result : %d\n" , practice.get_reversed_digits(num));
		System.out.println();
		System.out.println();
		
		
		//6.30
		practice.Guess_number();
	
		
		//6.33
		practice.playCraps_6_33();
		
	}
	
}
