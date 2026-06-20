package 수업7_1;

public class Rectangle extends Shape{
	private int height;
	public Rectangle() {
		super(); //이런식으로 shape.java의 생성자를 특정해서 호출할 수 있다. 생성자 오버로딩된 것도 가능. 매개변수 넣으면 됨.
		System.out.println("rectangle callse");
	}
	public int getHeight() {
		return height;
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
}
