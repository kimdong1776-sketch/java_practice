package 숙제6;
//컴퓨터학부 2025003170 김동후

public class RightTriangle extends Shape {
    private int h;
    
    public RightTriangle(int id, int h, char pattern) {
        super(id, pattern);
        this.h = h;
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
}
