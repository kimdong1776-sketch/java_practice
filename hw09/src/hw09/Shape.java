package hw09;

public abstract class Shape {
    protected int id;
    protected char pattern;
    
    public Shape(int id, char pattern) {
        this.id = id;
        this.pattern = pattern;
    }
    
  

	public abstract void draw(); 
    
    //  각자 파일에 저장될 문자열 형식을 만들어라!
    public abstract String toSaveString(); 
}