package hw09;
//컴퓨터학부 2025003170 김동후

public class RightTriangle extends Shape {
    private int h;
    
    public RightTriangle(int _id, int _h, char _pattern) {
        super(_id, _pattern);
        this.h = _h;
    }

    @Override
    public void draw() {
        for(int i = 1 ; i <= h; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(pattern);
            }
            System.out.println();
        }
    }

    @Override
    public String toSaveString() {
        // 형식: 도형이름 id 높이 패턴
        return "RightTriangle " + id + " " + h + " " + pattern;
    }
}