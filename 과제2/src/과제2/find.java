package 과제2;

import java.util.Scanner;

public class find {
	public static void largest_number() {
		Scanner input = new Scanner(System.in);
		System.out.println(">>");
		int num, max, max_2=0;
		max = 0;
		for(int i = 0; i < 10; i++) {
			num = input.nextInt();
			
			if(max < num) {
				max_2 = max;
				max = num;
			}
			else if(num > max_2) {
				max_2 = num;
			}
		}
		System.out.printf("4.3\n");
		System.out.printf("largest : %d \n", max);
		System.out.printf("second largest : %d", max_2);
	}
}
