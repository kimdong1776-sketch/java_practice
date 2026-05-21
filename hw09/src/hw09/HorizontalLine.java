package hw09;

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

    @Override
    public String toSaveString() {
        // 형식: 도형이름 id 길이 패턴
        return "HorizontalLine " + id + " " + len + " " + pattern;
    }
}
