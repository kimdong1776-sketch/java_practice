package 숙제4;

public class HorizontalLine {
	private int id;
	private int len;
	private char p;
	
	
	public HorizontalLine(int id, int len, char p) {
		this.id = id; this.len = len; this.p = p;
	}
	
	
	public void draw() {
		for(int i = 0 ; i<len; i++) {
			System.out.print(p);
		}
		System.out.println();
	}
}
