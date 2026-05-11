package 숙제6;

public class HorizontalLine extends Shape {
    private int len;
    
    public HorizontalLine(int id, int len, char pattern) {
        super(id, pattern);
        this.len = len;
    }
    
    @Override
    public void draw() {
        for(int i = 0 ; i < len; i++) {
            System.out.print(pattern);
        }
        System.out.println();
    }
}
