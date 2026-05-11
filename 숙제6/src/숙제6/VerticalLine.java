package 숙제6;

public class VerticalLine extends Shape {
    private int length;
    
    public VerticalLine(int id, int length, char pattern) {
        super(id, pattern);
        this.length = length;
    }
    
    @Override
    public void draw() {
        for(int i = 0 ; i < length ; i++) {
            System.out.print(pattern);
            System.out.println();
        }
        System.out.println();
    }
}
