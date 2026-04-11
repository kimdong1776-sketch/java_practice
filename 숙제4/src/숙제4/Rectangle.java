package 숙제4;

public class Rectangle {
	private int id;
	private int length;
	private int height;
	private char pattern;
	
	
	public Rectangle(int _id ,int _length, int _height,char _pattern) {
		this.id = _id;
		this.length = _length;
		this.height = _height;
		this.pattern = _pattern;
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
