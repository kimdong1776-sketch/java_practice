package 수업7_1;

public class Shape {
	
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
	public void draw() {
		
	}
}
