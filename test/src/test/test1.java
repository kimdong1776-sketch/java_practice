package test;

import java.security.SecureRandom;

public class test1 {
	public static void main(String[] args) {
		int[] A;
		A = new int[30];
		SecureRandom randomNumbers = new SecureRandom();
		
		for (int i = 0; i < 30; i++) {
			A[i] = randomNumbers.nextInt(100);
		}
		for (int i = 0; i < 30; i++) {
			System.out.println(A[i]);
		}
	}
}