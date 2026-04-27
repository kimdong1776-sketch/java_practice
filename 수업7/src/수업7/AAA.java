package 수업7;
//슈퍼클래스(superclass) or 베이스 클래스(baseclass)
public class AAA {
	private int num1;
	private int num2;
	
	public void setNum1(int num) {
		num1 = num;
	}
	
	public void setNum2(int num) {
		num2 = num;
	}
	
	public void print() {
		System.out.println("num 1 = "+ num1 + "num2 = " + num2);
	}
}
