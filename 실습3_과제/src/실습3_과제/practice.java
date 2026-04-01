package 실습3_과제;

import java.security.SecureRandom;
import java.util.Scanner;

public class practice {
	public static void squareOfAsterisks6_18(int side) {
        
        squareOfAsterisks6_19(side, '*'); 
    }

    public static void squareOfAsterisks6_19(int side, char fill_c) {
        for(int i = 0; i < side ; i++) {
            for(int j = 0; j < side ; j++) {
                System.out.printf("%c", fill_c);
            }
            System.out.println();
        }
    }
	
	public static boolean isPerfect(int num) {
		int result = 0;
		for(int i = 1; i < num; i++) {
			if((num % i) == 0) {
				result += i;
			}
		}
		if(result == num ) {
			return true;
		}
		return false;
	}
	public static int isPrime(int num, int mod) {
		int count = 0;
		if(mod == 1) {
			for(int i = 2 ; i <= num / 2; i++ ) {
				if(num % i == 0) { //not prime number
					count = 0;
					break;
				}
				count++;
			}
			return count;
		}
		
		for(int i = 2 ; i * i<= num; i++ ) {
			if(num % i == 0) { //not prime number
				count = 0;
				break;
			}
			count++;
		}
		return count;
	}
	public static int get_reversed_digits(int n) {
		    int result_n = 0;
		    
		    while (n > 0) {
		        int cur_digit = n % 10;  
		        
		       
		        result_n = (result_n * 10) + cur_digit; 
		        
		        n /= 10;             
		    }
		    
		    return result_n;
	}
	
	private static final SecureRandom randomNumbers = new SecureRandom();
	public static void Guess_number() {

	
		System.out.println("Guess a number between 1 and 1000.\n");
		int rn = 1 + randomNumbers.nextInt(1000);
		
		Scanner input1 = new Scanner(System.in);
		int gnum;
		
		while(true) {
			
			gnum = input1.nextInt();
			if(gnum < rn) {
				System.out.println("Too low. Try again.");
			}
			else if(gnum > rn) {
				System.out.println("Too high. Try again.");
			}
			else {
				System.out.println("Congratulations. You guessed the number!");
				System.out.println("Try again? Yes : 1; NO : 0");
				gnum = input1.nextInt();
				if(gnum == 1) {
					System.out.println("Guess a number between 1 and 1000.\n");
					rn = 1 + randomNumbers.nextInt(1000);
					continue;
				}
				break;
			}
		}
		
		
	}
	
	public static void Guess_number_6_31() {
	    Scanner input1 = new Scanner(System.in);
	    
	    while(true) {
	        System.out.println("Guess a number between 1 and 1000.");
	        int rn = 1 + randomNumbers.nextInt(1000);
	        int gnum;
	        int try_count = 0; 

	        while(true) {
	            gnum = input1.nextInt();
	            try_count++; 

	            if(gnum < rn) {
	                System.out.println("Too low. Try again.");
	            }
	            else if(gnum > rn) {
	                System.out.println("Too high. Try again.");
	            }
	            else {
	                System.out.println("Congratulations. You guessed the number!");
	                
	          
	                if(try_count < 10) {
	                    System.out.println("Either you know the secret or you got lucky!");
	                } else if(try_count == 10) {
	                    System.out.println("Aha! You know the secret!");
	                } else {
	                    System.out.println("You should be able to do better!");
	                }

	                System.out.println("\nTry again? Yes : 1; NO : 0");
	                int choice = input1.nextInt();
	                if(choice == 1) {
	                    break;
	                } else {
	                    return;
	                }
	            }
	        }
	    }
	}
	
}
