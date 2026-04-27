package 수업7;
//상속 
// class hierarchy : 클래스 계층구조 화살표의 시작점이 서브 클래스 끝점이 슈퍼클래스
// 클래스의 상속이 무조건 하나여야만 함. 싱글 이네리턴스, why? 변수 or 메서드의 이름이 겹칠 때 문제가 생김.
// C++은 멀티 이네리턴스를 허용. class B : A, D
//has a relationship : A클래스에서 B클래스를 사용함.
//is a relationship : 계층의 아래 is a 계층의 위 ex) 포유류 is a animal
public class TestMain {
	public static void main(String[] args) {
		AAA a = new AAA();// if sizeof(AAA)가 8Bytes 면
		BBB b = new BBB();// then sizeof(BBB)는 sizeof(AAA) + sizeof(BBB) = 8 + 4 = 12;
		a.setNum1(10);
		a.setNum2(20);
		a.print();
		b.setNum1(10); // BBB.java에서 extends 키워드를 써주지 않으면 컴파일 오류. C언어에서는 AAA를 ver1으로 잡고 BBB를 ver2로 잡아야하는 등으로 불편함이 있음.
		b.setNum2(20);
		b.print();
		b.setNum3(30);
		b.printMultiple(3);

	}
}
