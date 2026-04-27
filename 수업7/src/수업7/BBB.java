package 수업7;
//서브클래스(subclass) or (derived class)
//extends 키워드를 사용하여 AAA의 클래스를 상속 받을 수 있음
public class BBB extends AAA{
	private int num3;
	public void setNum3(int num) {
		num3 = num;
	}
	public void printMultiple(int N) {
		for(int i = 0 ; i < N ; i++) {
//			System.out.println("num1 = " + num1);
//			System.out.println("num2 = " + num2); //이경우에는 안 됨. 메모리 공간은 있지만 안 됨. private기 때문에. 
			//										만약 public으로 접근지시자를 사용하면 되긴함. 여기서 나오는 게 protected : 상속받은 클래스에서 접근 가능.
			//										TestMain.java에서 protected로 선언한 변수를 직접 접근 할 수 있는데 이는 package안의 파일에서 똑같이 접근 가능함.
			print(); // this.print();도 가능. AAA.java에서 print메서드를 private로 하면 접근 불가 protected로 하면 접근 가능
			System.out.println("num3 = " + num3);
			
			
		}
	}
}
