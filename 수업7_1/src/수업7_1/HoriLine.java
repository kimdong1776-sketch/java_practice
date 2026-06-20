package 수업7_1;

public class HoriLine extends Shape {
	@Override
	public void draw() {
		System.out.println();
		for(int i = 0 ; i < getLength(); i++) {
			System.out.print(getPattern());
		}
		System.out.println();
	}
}
