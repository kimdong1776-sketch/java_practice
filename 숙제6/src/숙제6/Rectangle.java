package 숙제6;

public class Rectangle extends Shape {
    private int length;
    private int height;
    
    public Rectangle(int id, int length, int height, char pattern) {
        super(id, pattern); // 부모 클래스의 생성자 호출
        this.length = length;
        this.height = height;
    }
    
    @Override
    public void draw() {
        for(int i = 0 ; i < length; i++) {
            for(int j = 0 ; j < height ; j++) {
                System.out.print(pattern);
            }
            System.out.println();
        }
    }
}