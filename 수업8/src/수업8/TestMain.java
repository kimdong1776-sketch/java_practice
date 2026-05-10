package 수업8;

import java.util.ArrayList;

public class TestMain {
	
	public static void main(String[] args) { //가변인자 호출
		Rectangle rect1 = new Rectangle();
		rect1.printVriable(1, 2, 3, 4, 5, 6, 7);  //[i@4909...등 이상한 거 찍힘
		rect1.printVriable();  //[i@4909...등 이상한 거 찍힘
		rect1.printVriable(1,2);  //[i@4909...등 이상한 거 찍힘
		//integer 배열 형태로 넘어감. 따라서 System.out.println(numbers)하고 출력하면 안됨.
		//numbers.length 하면 배열의 크기가 출력됨
	}
	
	public static void main0(String[] args) { //integerType ArrayList 만드는 법
		int [] A = new int[100];
		Integer ival = new Integer(7);
		//ival.
//		ArrayList<int> intList = new ArrayList<int>();// err
		ArrayList<Integer> intList = new ArrayList<Integer>();
	}
	
	
	public static void main2(String[] args) { //어레이 리스트
		ArrayList<Rectangle> rectList; //지네릭타입??
		rectList = new ArrayList<Rectangle>();
		Rectangle rect1 = new Rectangle();
		Rectangle rect2 = new Rectangle();
		Rectangle rect3 = new Rectangle();
//		rectArr[0] = rect; // x
		rectList.add(rect1);
		rectList.add(rect2);
		rectList.add(rect3);
		
		System.out.println(rectList.size()); // 3
		for(int i = 0; i<rectList.size(); i++) {
			Rectangle rtmp = rectList.getFirst(); //pop 느낌
			rtmp.print(); //이런식으로 하면 됨.
			rectList.get(i).print(); // 이런식으로 한 줄로 만들 수 도 있음.
		}
		for(int i = 0; i<rectList.size(); i++) {
			rectList.remove(i); // 인자의 데이터타입이 int index가 있고 Object O도있음			
		}
		rectList.removeAll(rectList);
	}
	
	
	
	public static void main1(String[] args) {
		Rectangle rect = new Rectangle();
		Shape s = new Shape(); // new를 하지 못함. >> abstract class기 때문에.
		//상속을 위해 만든 기능. shpae은 abstract로 만듦.
		//안 한다고 문제는 아님. shape의 설계상 new를 막는 기능임
		rect.setId(1);
		rect.setLength(5);
		rect.setHeight(6);
		rect.setPattern('#');
		HoriLine hline = new HoriLine();
		hline.setId(1);
		hline.setLength(20);
		hline.setPattern('*');
		
		borderRectangle box = new borderRectangle();
		
		box.setId(3);
		box.setLength(20);
		box.setHeight(5);
		box.setPattern('%');
		
		
	
		HoriLine hline2;
	
		hline2 = hline; 
		Rectangle rect2 = new Rectangle();
		rect2 = box; 
	
		rect2.draw(); 
		
		rect.draw();
		hline.draw();
		box.draw();
		
//		box = rect;//는 에러
		box = (borderRectangle)rect;//에러 안남. 명시적 타입 캐스팅
		System.out.println(rect instanceof borderRectangle); //{reference} instanceof {ClassName}
		//객체 타입을 확인하는 연산자이며 형 변환 가능 여부를 확인할 수 있다.
		/*System.out.println( parent instanceof Parent );  // true
        System.out.println( child instanceof Parent );   // true
        System.out.println( parent instanceof Child );   // false
        System.out.println( child instanceof Child );   // true*/

//		System.out.println(hline instanceof borderRectangle); // >>아에 빨간 줄 : 레퍼런싱의 관계가 없기 때문.\
		
		//final class와 final 메서드가 있음. 찾아보기.
		//interface = abstract class with abstract method only
		if(s instanceof borderRectangle) {
			borderRectangle tmp = (borderRectangle)s;
			tmp.draw();
		}
		Shape[] sahpe = new Shape[100];
		sahpe[0] = hline;
		sahpe[1] = rect;
		sahpe[2] = box;
		for(int i = 0; i < 3; i++) {
			sahpe[i].draw();
		}
		
		
		
		movable m;
		m = rect;
		m.move(0, 0);
		m.reszie(0);
		printable p;
		p = rect;
		p.print();
		p.printInfo();
		
		s = rect;
		s.draw();
//		s.resize(0);//불가능.
		
	}
}
