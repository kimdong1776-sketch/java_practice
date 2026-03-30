package 숙제2;
import java.security.SecureRandom;

//컴퓨터학부 2025003170 김동후
public class RandomIntegers{
	public static void main(String[] args){
		SecureRandom randomNumbers = new SecureRandom();
		for(int counter = 1; counter <= 20; counter++){
			int face = 1 + randomNumbers.nextInt(6);
			System.out.printf("%d ", face);
			if (counter % 5 == 0){
				System.out.println();
			}
		}
	}
}
