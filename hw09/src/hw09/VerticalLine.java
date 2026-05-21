package hw09;

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

    @Override
    public String toSaveString() {
        // 형식: 도형이름 id 길이 패턴
        return "VerticalLine " + id + " " + length + " " + pattern;
    }
}
