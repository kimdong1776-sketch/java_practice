package 수업7_1;

public class TestMain {
	public static void main(String[] args) {
		Rectangle rect = new Rectangle();
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
		
		
		//상위클래스(슈퍼클래스)의 참조변수는 하위 클래스(서브클래스)의 객체를 가르킬 수 있다. 이의 역은 불가능하다. (외우자)
		HoriLine hline2;
		//hline2 = rect; : 불가 타입이 안 맞음. (각각의 클래스 사이의 관계가 없음)
		hline2 = hline; // 얘는 됨. 데이터 타입이 같아서
		Rectangle rect2 = new Rectangle();
		rect2 = box; // 가능 상위클래스인 rect2의 참조변수 rect2는 하위클래스 box를 가르킬 수 있다. box = rect2는 불가. 포인팅 할 수 있다는 거지 다형성 설명은 아님.
		//box = rect2; (x)
		rect2.draw(); // borderRecctangle 의 메서드인 draw가 호출
		//이를 다형성(polymorphism)이라고 함!
		
		//스태틱바인딩 다이나믹 바인딩
		//link : 코드메모리+ 스택 + 스태틱 + 힙 등을 다합친 전체 프로그램의 시작 메모리 주소에서 콜하는 함수가 얼만큼 떨어져있는지는 런타임 중에 알 수 있다.
		//					콜하는 함수 자체의 위치는 컴파일러가 모름.
		
		//다형성은 다이나믹 바인딩이다?
		rect.draw();
		hline.draw();
		box.draw(); //상속의 관계에서 슈퍼클래스에 구현이 되어있는데 메서드를 다시 쓰고 싶을때를 method Overriding이라고한다. 재구현.
		Shape[] sahpe = new Shape[100];
		sahpe[0] = hline;
		sahpe[1] = rect;
		sahpe[2] = box;
		//그리고 이 부분에서 컨스트런트가 언제 어떤 순서로 호출되는지 보기.
		for(int i = 0; i < 3; i++) {
			sahpe[i].draw();
		}
		
		
	
		
		
		
		
		
	}
}
