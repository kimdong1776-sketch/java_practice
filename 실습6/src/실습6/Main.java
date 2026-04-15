package 실습6;
import java.util.Scanner;

// default construct: new Rectangel();) ;
//디폴드 컨스트럭트 : 따로 컨스트럭트를 정의를 안해도 자바에서 자동으로 초기화 해주는 것을 디폴드 컨스트럭트라한다.
// 컨스트럭트를 하나 만들어 놓으면 디폴트 컨스트럭트를 못슨다.
// 만약 구현을 하고 인자가 없는 것도 만들고 싶으면 메서드 오버로딩을 사용해서 따로 구현해야한다.

//접근 권한 ((pirvate)) ((public)) ((protected))
//protected는 상속 : 부모클래스가 자식클래스에 접근할 수 있게 하는 거.

//메모리 힙영역(객체 주소) 부분에는 메서드가 같이 있지 않고 데이터만 같이 있음. 코드는 메서드 영역이라는 곳에 있음(공유) 호출 시 메서드의 매개변수 리턴값 등은 스택에 올라감
//이때 중요한 점! 메서드가 실행되면서 객체의 데이터(width, height)가 필요하죠? 스택 프레임 안에 숨겨진 this 레퍼런스를 통해 힙에 있는 실제 객체를 찾아가서 데이터를 가져옵니다.
///static 메서드는 클래스 로딩 시점에 메서드 영역에 할당되어 객체 생성 없이 실행 가능하므로, this 를 쓸 수 없다.
// ++(스택 프레임에 특정 인스턴스의 주소값인 this 가 전달되지 않습니다. 따라서 힙(Heap) 영역에 생성되는 인스턴스 변수에 접근할 수 있는 물리적인 경로가 존재하지 않기 때문에 인스턴스 멤버를 직접 사용할 수 없습니다.")
//Garbage Collection 쓰레기를 모은다는 뜻 JVM이 알아서 C에서로 따지면 free 를 해줌. 걔를 garbage collector 라고 함.
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
