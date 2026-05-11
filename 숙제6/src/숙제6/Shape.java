package 숙제6;

public abstract class Shape {
    protected int id;
    protected char pattern;
    
    // 부모 생성자: 모든 자식들이 공통으로 가질 속성을 초기화
    public Shape(int id, char pattern) {
        this.id = id;
        this.pattern = pattern;
    }
    
    // 추상 메서드: "자식 클래스들은 무조건 이걸 오버라이딩해서 자기만의 그리기 방식을 구현해!" 라는 강제성 부여
    public abstract void draw(); 
}