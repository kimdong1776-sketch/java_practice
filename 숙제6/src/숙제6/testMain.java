package 숙제6;

import java.util.Scanner;

public class testMain {
    public static final int QUIT = 0;
    public static final int MAX_SIZE = 50; // 모든 도형을 합쳐서 관리하므로 사이즈를 늘렸습니다.

    public static void printMenu() {
        System.out.println("==============choice=============");
        System.out.println(" 1. Rectangle ");
        System.out.println(" 2. RightTriangle");
        System.out.println(" 3. Diamond");
        System.out.println(" 4. VerticalLine");
        System.out.println(" 5. HorizontalLine");
        System.out.println("==========object control=========");
        System.out.println(" 8. Delete all object");
        System.out.println(" 9. Draw all object");
        System.out.println(" 11. Draw all Rectangle ");
        System.out.println(" 12. Draw all RightTriangle");
        System.out.println(" 13. Draw all Diamond");
        System.out.println(" 14. Draw all VerticalLine");
        System.out.println(" 15. Draw all HorizontalLine");
        System.out.println(" 0. exit");
        System.out.println("=================================");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // 🌟 다형성의 핵심: 부모 타입(Shape) 배열 하나로 모든 자식 객체를 관리!
        Shape[] shapes = new Shape[MAX_SIZE];
        int shapeCount = 0; 

        int choice = 1;
        while(choice != QUIT) {
            printMenu();
            choice = input.nextInt();
            
            int id, w, h, len;
            char p;
            
            switch (choice) {
                case 1:
                    System.out.println("Enter >> id, width, height, pattern");
                    id = input.nextInt(); w = input.nextInt(); h = input.nextInt(); p = input.next().charAt(0);
                    shapes[shapeCount] = new Rectangle(id, w, h, p); // 업캐스팅 (Upcasting)
                    shapes[shapeCount++].draw(); // 동적 바인딩에 의해 Rectangle의 draw() 호출
                    break;
                case 2:
                    System.out.println("Enter >> id, height, pattern");
                    id = input.nextInt(); h = input.nextInt(); p = input.next().charAt(0);
                    shapes[shapeCount] = new RightTriangle(id, h, p);
                    shapes[shapeCount++].draw();
                    break;
                case 3:
                    System.out.println("Enter >> id, size(odd), pattern");
                    id = input.nextInt(); len = input.nextInt(); p = input.next().charAt(0);
                    shapes[shapeCount] = new Diamond(id, len, p);
                    shapes[shapeCount++].draw();
                    break;
                case 4:
                    System.out.println("Enter >> id, length, pattern");
                    id = input.nextInt(); len = input.nextInt(); p = input.next().charAt(0);
                    shapes[shapeCount] = new VerticalLine(id, len, p);
                    shapes[shapeCount++].draw();
                    break;
                case 5:
                    System.out.println("Enter >> id, length, pattern");
                    id = input.nextInt(); len = input.nextInt(); p = input.next().charAt(0);
                    shapes[shapeCount] = new HorizontalLine(id, len, p);
                    shapes[shapeCount++].draw();
                    break;
                case 8: // Delete all
                    shapeCount = 0; // 카운트만 0으로 초기화하면 덮어씌워지므로 삭제와 동일한 효과
                    System.out.println("All objects deleted from management.");
                    break;
                case 9: // Draw all 
                    System.out.println("\n--- Drawing All Objects ---");
                    for(int i = 0; i < shapeCount; i++) {
                        shapes[i].draw(); // 알아서 각자의 모양대로 그려짐 (다형성)
                    }
                    break;
                    
                // 🌟 instanceof 연산자를 사용하여 특정 객체만 골라내기
                case 11: 
                    for (int i = 0; i < shapeCount; i++) 
                        if (shapes[i] instanceof Rectangle) shapes[i].draw(); 
                    break;
                case 12: 
                    for (int i = 0; i < shapeCount; i++) 
                        if (shapes[i] instanceof RightTriangle) shapes[i].draw(); 
                    break;
                case 13: 
                    for (int i = 0; i < shapeCount; i++) 
                        if (shapes[i] instanceof Diamond) shapes[i].draw(); 
                    break;
                case 14: 
                    for (int i = 0; i < shapeCount; i++) 
                        if (shapes[i] instanceof VerticalLine) shapes[i].draw(); 
                    break;
                case 15: 
                    for (int i = 0; i < shapeCount; i++) 
                        if (shapes[i] instanceof HorizontalLine) shapes[i].draw(); 
                    break;
                case 0:
                    System.out.println("exit.");
                    break;
            }
        }
    }
}
