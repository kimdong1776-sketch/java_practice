package 숙제4;

public class VerticalLine {
	private int id;
	private int length;
	private char pattern;
	
	
	public VerticalLine(int _id, int _length, char _pattern) {
		this.id = _id;
		this.length = _length;
		this.pattern = _pattern;
	}
	

	public void draw() {
		for(int i = 0 ; i < length ; i++) {
			System.out.print(pattern);
			System.out.println();
		}
		System.out.println();
	}
}
