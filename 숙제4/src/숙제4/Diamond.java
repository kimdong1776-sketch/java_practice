package 숙제4;

public class Diamond {
	
	private int id, size;
	private char p;
	
	public Diamond(int id, int size, char p) {
		this.id = id; this.size = size; this.p = p;
	}
	
	public void draw() {
		int mid = ((this.size) / 2) + 1;
		for(int i = 1; i <=mid ; i++) {
			for(int j = 0 ; j < mid - i; j++) {
				System.out.print(" ");
			}
			for(int j = 0 ; j < (2*i)-1; j++) {
				System.out.print(this.p);
			}
			System.out.print("\n");
		}
		for(int i = mid; i > 0; i--) {
			for(int j = 0 ; j <= mid - i; j++) {
				System.out.print(" ");
			}
			for(int j = (2*(i-1))-1 ; j > 0 ; j--) {
				System.out.print(this.p);
			}
			System.out.print("\n");
		}
	}
}
