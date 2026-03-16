
/* scnaf 쓰는 법. ▽
		* Scanner input;
		* input = new Scanner (System.in);
		* 
		* Scanner input = new Scanner (System.in);sc
		*/
		/*
 * 변수 (variable)
		 * =>변할 수 있는 수? (x) from 수학
		 * =>데이터를 저장하는 공간에 붙인 이름(on Memory)!
		 *  built in variable and Reference variable(빌트인이 아닌 거 모두)
		 *  빌트인은 byte short int long float double char boolean
		 *  레퍼런스는 Scanner(4 or 8 Bytes) String  Array Cloass Object 
		 *  	레퍼런스는 모두다 포인터 타입으로 생각해라 근데 자바는 포인터라는 개념이 없어서 포인터 연산이 안됨
		 *  	Java 는 reference만 함 따라서 C의 포인터 보다 제한 됨.
		 *  Scanner input = new Scanner (System.in);
		 *  input은 포인터형 new는 malloc과 거의 유사함.
		 */
// 조건식에 boolean 데이터 타입만 들어갈 수 있음. 


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
