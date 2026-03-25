package 실습4;

import java.util.Scanner;

public class Classaverage {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int total;
		int gradeCounter;
		
		total = 0;
		gradeCounter = 1;
		
		
		while(gradeCounter <= 10) {
			System.out.print("Enter grade : ");
			int grade = input.nextInt();
			
			total += grade;
			gradeCounter++;
		}
		int average = total /10;
		System.out.println("Total : "+ total);
		System.out.print("Average : " + average);
		
	}
	/* scope of a variable  lifetime of a variable
	 *
	 * 
	 * 
	 */
	
}
