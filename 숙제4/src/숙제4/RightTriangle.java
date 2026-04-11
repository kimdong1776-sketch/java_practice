package 숙제4;
//컴퓨터학부 2025003170 김동후

public class RightTriangle {
	private int id, h;
	private char pattern;
	
	public RightTriangle(int _id, int _h, char _pattern) {
		this.id = _id;
		this.h = _h;
		this.pattern = _pattern;
	}
	public void draw() {
		for(int i = 1 ; i <= h; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(this.pattern);
			}
			System.out.println();
		}
	}
}
