package 실습6;

public class Rectangle {
	private int id;
	private int length;
	private int height;
	private char pattern;
	
	
	public Rectangle() {
		this.length = 1;
		this.height = 1;
		this.pattern = '#';

		System.out.println("constructor1 called");
	}
	public Rectangle(int _id ,int _length, int _height,char _pattern) {
		this.id = _id;
		this.length = _length;
		this.height = _height;
		this.pattern = _pattern;

		System.out.println("constructor2 called");
	}
	
	
	public String toString() {
		String str;
		str = "Rectangle " + id + " (" + length +", "+ height+ ", "+pattern + ")";
		return str;
	}
	
	public void setLength(int a) {
			length = a;
		}
	public void setHeight(int b) {
		height = b;
		
	}
	public void setPattern(char c) {
		pattern = c;
		
	}
	public void draw() {
		for(int i = 0 ; i < length; i++) {
			for(int j = 0 ; j < height ; j++) {
				System.out.print(pattern);
			}
			System.out.println();
		}
	}
}
