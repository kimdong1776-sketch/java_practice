package 실습6;
import java.util.Scanner;
public class Main {
	public static final int QUIT = 0;
	
	public static void printMunu() {
		System.out.println("*********************");
		System.out.println("* 1. Rectangle ");
		System.out.println("* 2. Triagle");
		System.out.println("* 9. Show All Rectangle");
		System.out.println("* 0. eixt ");
		System.out.println("*********************");
		System.out.println("Enter your choice");
	}
	
	public static Rectangle creatRect() {
		
		int id, len, hei;
		char pat;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter ID : ");
		id = input.nextInt();
		System.out.print("Enter len : ");
		len = input.nextInt();
		System.out.print("Enter hei : ");
		hei = input.nextInt();
		System.out.print("Enter pat : ");
		pat = input.next().charAt(0); // input.next() 는 Stirng 타입 , charAt은 String의 인덱스를 가져오는 거
		
		Rectangle rect =  new Rectangle(id, len, hei, pat);
		return rect;
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Rectangle rect;
		Rectangle[] rectarr  = new Rectangle [100];
		int rectCount = 0 ;
		int select;
		printMunu();
		select = input.nextInt();
		while(select != QUIT){
			if(select == 1) {// 사각형 선택
				rect =  creatRect(); //힙영역으로 어사인하기때문에 함수가 끝나도  메모리를 유지할 수 있다. 
				rect.draw();
				rectarr[rectCount++] = rect;
			}
			else if(select == 2) {
				
			}
			else if (select == 9 ) {
				for(int i = 0 ; i < rectCount ; i++) {
					rectarr[i].draw();
				}
			}
			printMunu();
			select = input.nextInt();
		}
		System.out.println("Bye~~~~~");
	
		
		
		
		//---------------------------------------------
		Rectangle r;
		r = new Rectangle(); // 힙영역에 할당하면 컨스트럭트 호출!!!!
		
//		r.setLength(4);
//		r.setHeight(4);
//		r.setPattern('#');
		r.draw();
		
		
		Rectangle p;
		p = new Rectangle(10,10,10,'%');

		p.draw();
		
		System.out.println(r); //toString 자동 호출
		System.out.println(p);
	}
	//exception handling
		//constructor (생성자)
		// 클레스 이름과 같아야하고 반환 타입이 없는 형태
		// 예시 Rectangle 클래서의 public Rectangle(){} 컨스트럭트
}
