package 수업8;

public abstract class Shape { //추상 클래스
	
	public Shape() {
		System.out.println("Shpae constructor called"); //자동 호출 됨.
		}
	
	private int id;
	private int length;
	private char pattern;
	
	protected int id1;
	protected int length1;
	protected char pattern1;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public char getPattern() {
		return pattern;
	}
	public void setPattern(char pattern) {
		this.pattern = pattern;
	}
	public abstract void draw(); 
	// 추상 메소드 {}이 없음. 구현하면 안됨. 만약 Class가 abstract이고,
	//메서드 조차 abstract이면 그 메서드는 상속 받은 애가. 무조건 메서드를 구현 해야함. 
	//지금 상황에선 Rectagle 에서 draw() 오버라이딩?을 꼭 해줘야함. 이 의미를 내포하고 있음.
}
