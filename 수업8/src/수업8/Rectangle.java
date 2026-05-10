package 수업8;

public class Rectangle extends Shape implements movable, printable{
	//자바에선 다중 산속을 하지못하도로갛는데 interface를 사용해서 가능.
	//구현한다라고 말하는데 상속한다라고도 말함. interface는 두개이상 상속을 받을 수 잇음.
	//movable과 printable에있는 메서드들을 무조건 구현해야함.
	private int height;
	public Rectangle() {
		super(); 
		System.out.println("rectangle callse");
	}
	public int getHeight() {
		return height;
	}
	
	public void printVriable (int ...numbers) {//가변인자 구현하는 법!!
		System.out.println(numbers);
		//integer 배열 형태로 넘어감. 따라서 System.out.println(numbers)하고 출력하면 안됨.
		//따라서 이렇게 해야함.
		for(int i = 0 ; i < numbers.length; i++) {
			System.out.print(numbers[i]+ " ");
		}
		System.out.println();
	}
	
	public void printV2(int[] numbers) { // 위에거랑 같은 거 아니냐!!? 다름 위에건 말 그대로 가변 인자 가변 베리어블임. 
										//근데 애는 호출할때 배열(직접 만들어서 but 위에 건 자동으로 만들어줌) 을 하나의 파라미터로 전달해야함.
		System.out.println(numbers);
		for(int i = 0 ; i < numbers.length; i++) {
			System.out.print(numbers[i]+ " ");
		}
		System.out.println();
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	public void draw() {
		for(int i = 0 ;i < height; i++) {
			for(int j = 0 ; j < getLength(); j++) {
				System.out.print(getPattern());
			}
			System.out.println();
		}
	}
	
	//반드시 구현을 해야 함.
	@Override
	public void print() {
		System.out.println("Rectagle print()");
		// TODO Auto-generated method stub
		
	}
	@Override
	public void printInfo() {
		System.out.println("Rectagle printInfo()");
		// TODO Auto-generated method stub
		
	}
	@Override
	public void move(int x, int y) {
		System.out.println("Rectagle move()");
		// TODO Auto-generated method stub
		
	}
	@Override
	public void reszie(int size) {
		System.out.println("Rectagle reszie()");
		// TODO Auto-generated method stub
		
	}
}
