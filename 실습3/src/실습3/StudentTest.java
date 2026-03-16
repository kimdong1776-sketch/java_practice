package 실습3;

public class StudentTest {//클래스의 필요성은 구조체의 필요성과 같다.
							//사용자 정의 자료형으로, 데이터의 체계적인 그룹화, 가독성 향상, 
							//코드의 재사용성 및 유지보수 편의성을 위해 필수적
	public static void main(String[] args) {
		double a;
		String str;
		Student s; //stack
		s = new Student(); //heap
		s.setAverage(3.4);
		s.setName("김동후");//C에선 요정도로 잘 돌아간다(name, strcpy쓰기). 하지만 java는 레퍼런스 변수기 떄문에 안 됨
		//따라서 s = new Student();를 추가해준다. new는 메모리 할당 student 클래스를 할당 후 그 주소값을 s에 저장
		// Student 가 클래스 s가 가르키는 것이 객체(메모리).
		
		a= s.getAverage();
		str = s.getName();
		
		System.out.println("a = " +a);
		System.out.println("name = " +str);
		
		System.out.println("Bye...");
		
	}
}
