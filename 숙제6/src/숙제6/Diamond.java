package 숙제6;

public class Diamond extends Shape {
    private int size;
    
    public Diamond(int id, int size, char pattern) {
        super(id, pattern);
        this.size = size;
    }
    
    @Override
    public void draw() {
        int mid = (size / 2) + 1;
        for(int i = 1; i <= mid ; i++) {
            for(int j = 0 ; j < mid - i; j++) {
                System.out.print(" ");
            }
            for(int j = 0 ; j < (2 * i) - 1; j++) {
                System.out.print(pattern);
            }
            System.out.print("\n");
        }
        for(int i = mid - 1; i > 0; i--) { // 가운데 줄 중복 출력을 방지하기 위해 mid-1로 수정
            for(int j = 0 ; j <= mid - i - 1; j++) {
                System.out.print(" ");
            }
            for(int j = (2 * i) - 1 ; j > 0 ; j--) {
                System.out.print(pattern);
            }
            System.out.print("\n");
        }
    }
}
