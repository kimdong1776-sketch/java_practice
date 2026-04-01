package 과제2;
import java.util.Scanner;
public class starprint {
	public static void a() {
		for(int i = 1; i <= 10; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
	
	public static void b() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10-i; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
	public static void c() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < 10 -i ; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
	
	public static void d() {
		for(int i = 0; i < 10; i++) {
			for(int j = 1; j < 10 -i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j <= i ; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
	
	public static void diamond() {
		for(int i = 1; i <= 5; i++) {
			for(int j = 0 ; j < 5 - i; j++) {
				System.out.print(" ");
			}
			for(int j = 0 ; j < (2*i)-1; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		for(int i = 5; i > 0; i--) {
			for(int j = 0 ; j <= 5 - i; j++) {
				System.out.print(" ");
			}
			for(int j = (2*(i-1))-1 ; j > 0 ; j--) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
	
	public static void diamond_m() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("odd number in the range 1 to 19 >>");
		int n = input.nextInt();
		int mid = (n / 2) + 1;
		for(int i = 1; i <=mid ; i++) {
			for(int j = 0 ; j < mid - i; j++) {
				System.out.print(" ");
			}
			for(int j = 0 ; j < (2*i)-1; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		for(int i = mid; i > 0; i--) {
			for(int j = 0 ; j <= mid - i; j++) {
				System.out.print(" ");
			}
			for(int j = (2*(i-1))-1 ; j > 0 ; j--) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
}
