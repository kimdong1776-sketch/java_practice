package 수업10;

import java.util.Scanner;

public class MainClass {
	
	public static int getDivision (int numerator, int denominator) throws ArithmeticException{
		int result;
		result = numerator / denominator;
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		System.out.println("Enter two numbers : ");
		int num1, num2, result;
		num1= scanner.nextInt();
		num2= scanner.nextInt();
		try {
			result = getDivision(num1, num2);
			System.out.println("result = " + result);
		}catch(ArithmeticException e) {
			System.out.println(e);
		} finally {
			System.out.println("--------->");
		}
	}
}
