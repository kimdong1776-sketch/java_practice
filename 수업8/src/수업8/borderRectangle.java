package 수업8;

public class borderRectangle extends Rectangle {
	@Override
	public void draw(){//만약 draw(int a)처럼 인자만 추가해준다면 이건 overloading. rectagnle클래스에잇는 draw를 인자변환 없이 쓰면 이건 overriding
		
		for(int i = 0 ; i < getLength(); i++) {
			System.out.print(getPattern());
		}
		System.out.println();
		for(int i = 0 ; i < getHeight()-2; i++) {
			System.out.print(getPattern());
			for(int j = 0 ; j < getLength()-2; j++) {
				System.out.print(" ");
			}
			System.out.println(getPattern());
		}
		for(int i = 0 ; i < getLength(); i++) {
			System.out.print(getPattern());
		}
	}
}
