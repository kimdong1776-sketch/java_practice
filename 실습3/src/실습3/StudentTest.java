package 실습3;

public class StudentTest {//클래스의 필요성은 구조체의 필요성과 같다.
							//사용자 정의 자료형으로, 데이터의 체계적인 그룹화, 가독성 향상, 
							//코드의 재사용성 및 유지보수 편의성을 위해 필수적
	public static void main(String[] args) {
		Student s; //stack
		Student s1;
		s = new Student(); //heap
		s1 = new Student();
		
		
		s.setAverage(3.4);
		s.setName("김동후");
		s.setGrade(3.9f);
		

		s1.setAverage(3.51);
		s1.setName("홍길동");
		s1.setGrade(4.1f);//C에선 요정도로 잘 돌아간다(name, strcpy쓰기). 하지만 java는 레퍼런스 변수기 떄문에 안 됨
		//따라서 s = new Student();를 추가해준다. new는 메모리 할당 student 클래스를 할당 후 그 주소값을 s에 저장
		// Student 가 클래스 s가 가르키는 것이 객체(메모리).
		
		
		System.out.println("==================정보====================");
		System.out.printf("%7s %7s %13s %9s\n", "name", "grade", "total Score", "average");
		System.out.printf("%6s %5.2f/4.3 %8.2f %10.2f\n", s.getName(), s.getGrade(), s.getScore(5,6,8,7,9,8,10,20,55.56), s.getAverage());
		System.out.printf("%6s %5.2f/4.3 %8.2f %10.2f\n", s1.getName(), s1.getGrade(), s1.getScore(5,6,8,7,9,8,10,20,55.56), s1.getAverage());
		System.out.println("=========================================\n");
		
	
		System.out.println("Bye...");
		
	}
}
