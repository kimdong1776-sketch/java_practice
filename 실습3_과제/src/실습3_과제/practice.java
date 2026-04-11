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
	
	private enum Status {CONTINUE, WON, LOST};

    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    public static void displayChatter() {
        int randomChoice = randomNumbers.nextInt(3);
        
        switch (randomChoice) {
            case 0:
                System.out.println("Oh, you're going for broke, huh?");
                break;
            case 1:
                System.out.println("Aw c'mon, take a chance!");
                break;
            case 2:
                System.out.println("You're up big. Now's the time to cash in your chips!");
                break;
        }
    }

    public static void playCraps_6_33() {
        Scanner input = new Scanner(System.in);
        int bankBalance = 1000;

        while (bankBalance > 0) {
            System.out.printf("Current balance: $%d\n", bankBalance);
            displayChatter();

            System.out.print("Enter your wager: ");
            int wager = input.nextInt();

            while (wager <= 0 || wager > bankBalance) {
                System.out.print("Invalid wager. Enter a valid wager: ");
                wager = input.nextInt();
            }

            int myPoint = 0;
            Status gameStatus;
            int sumOfDice = rollDice();

            switch (sumOfDice) {
                case SEVEN:
                case YO_LEVEN:
                    gameStatus = Status.WON;
                    break;
                case SNAKE_EYES:
                case TREY:
                case BOX_CARS:
                    gameStatus = Status.LOST;
                    break;
                default:
                    gameStatus = Status.CONTINUE;
                    myPoint = sumOfDice;
                    System.out.printf("Point is %d\n", myPoint);
                    break;
            }

            while (gameStatus == Status.CONTINUE) {
                sumOfDice = rollDice();

                if (sumOfDice == myPoint) {
                    gameStatus = Status.WON;
                } else if (sumOfDice == SEVEN) {
                    gameStatus = Status.LOST;
                }
            }

            if (gameStatus == Status.WON) {
                bankBalance += wager;
                System.out.printf("Player wins! New balance: $%d\n", bankBalance);
            } else {
                bankBalance -= wager;
                System.out.printf("Player loses. New balance: $%d\n", bankBalance);

                if (bankBalance <= 0) {
                    System.out.println("Sorry. You busted!");
                    break;
                }
            }
            
            System.out.print("Enter 1 to play again, 0 to stop: ");
            if (input.nextInt() == 0) {
                break;
            }
        }
    }

    public static int rollDice() {
        int die1 = 1 + randomNumbers.nextInt(6);
        int die2 = 1 + randomNumbers.nextInt(6);
        int sum = die1 + die2;
        System.out.printf("Player rolled %d + %d = %d\n", die1, die2, sum);
        return sum;
    }
}
	
