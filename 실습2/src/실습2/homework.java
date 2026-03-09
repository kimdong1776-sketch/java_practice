package 실습2;

import java.util.Scanner;

public class homework {
	public static void main(String[] args) {
		System.out.println("pint \t one \n line.");
		
		System.out.println("another line.");
		int i = 0;
		while(i < 10) {
			i++;
			System.out.printf("%d\n", i);
		}
		/* scnaf 쓰는 법. ▽
		* Scanner input;
		* input = new Scanner (System.in);
		* 
		* Scanner input = new Scanner (System.in);
		*/
		int a;
		int b = 10;
		int c;
		Scanner input = new Scanner (System.in);
		
		System.out.print("enter an integer>>");
		a = input.nextInt();
		System.out.print("enter an integer>>");
		b = input.nextInt();
		
		System.out.print("result>> ");
		c = a + b;
		System.out.println("C = "+ c);
		
	}
}
