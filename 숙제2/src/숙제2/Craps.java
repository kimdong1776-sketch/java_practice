package 숙제2;
import java.security.SecureRandom;
//컴퓨터학부 2025003170 김동후
public class Craps
{
  private static final SecureRandom randomNumbers = new SecureRandom();

  private enum Status {CONTINUE, WON , LOST};

  private static final int SNAKE_EYES = 2;
  private static final int TREY = 3;
  private static final int SEVEN = 7;
  private static final int YO_LEVEN = 11;
  private static final int BOX_CARS = 12;

  public static void main(String[] args){
      int myPoint = 0;
      Status gameStatus;

      int SumOfDice = rollDice();

      switch(SumOfDice){
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
              myPoint = SumOfDice;
              System.out.printf("Point is %d\n", myPoint);
              break;

      }
      while(gameStatus == Status.CONTINUE){
          SumOfDice = rollDice();

          if(SumOfDice == myPoint){
              gameStatus = Status.WON;

          }
          else{
              if((SumOfDice == SEVEN)){
                  gameStatus = Status.LOST;
              }
          }
      }
  }
  public static int rollDice() {
      int die1 = 1 + randomNumbers.nextInt(6);
      int die2 = 1 + randomNumbers.nextInt(6);
      
      int sum = die1 + die2; 
//      System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);

      return sum;
  }
}