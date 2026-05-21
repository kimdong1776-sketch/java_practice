package hw09;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class testMain {
    public static final int QUIT = 0;
    public static final int MAX_SIZE = 50; 

    public static void printMenu() {
        System.out.println("==============choice=============");
        System.out.println(" 1. Rectangle ");
        System.out.println(" 2. RightTriangle");
        System.out.println(" 3. Diamond");
        System.out.println(" 4. VerticalLine");
        System.out.println(" 5. HorizontalLine");
        System.out.println("==========object control=========");
        System.out.println(" 6. Save to file (파일 저장)");  // 추가됨
        System.out.println(" 7. Load from file (파일 불러오기)"); // 추가됨
        System.out.println(" 8. Delete all object");
        System.out.println(" 9. Draw all object");
        System.out.println(" 0. exit");
        System.out.println("=================================");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
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
                    shapes[shapeCount++] = new Rectangle(id, w, h, p); 
                    break;
                case 2:
                    System.out.println("Enter >> id, height, pattern");
                    id = input.nextInt(); h = input.nextInt(); p = input.next().charAt(0);
                    shapes[shapeCount++] = new RightTriangle(id, h, p);
                    break;
                case 3:
                    System.out.println("Enter >> id, size(odd), pattern");
                    id = input.nextInt(); len = input.nextInt(); p = input.next().charAt(0);
                    shapes[shapeCount++] = new Diamond(id, len, p);
                    break;
                case 4:
                    System.out.println("Enter >> id, length, pattern");
                    id = input.nextInt(); len = input.nextInt(); p = input.next().charAt(0);
                    shapes[shapeCount++] = new VerticalLine(id, len, p);
                    break;
                case 5:
                    System.out.println("Enter >> id, length, pattern");
                    id = input.nextInt(); len = input.nextInt(); p = input.next().charAt(0);
                    shapes[shapeCount++] = new HorizontalLine(id, len, p);
                    break;
                
             
                case 6:
                    try {
                        // "shapes.txt"라는 파일을 만들고 기록할 준비
                        PrintWriter pw = new PrintWriter(new FileWriter("shapes.txt"));
                        for(int i = 0; i < shapeCount; i++) {
                            pw.println(shapes[i].toSaveString()); // 다형성 덕분에 한 줄로 끝!
                        }
                        pw.close(); // 파일은 다 쓰면 반드시 닫아주어야 합니다.
                        System.out.println(" 파일(shapes.txt)에 " + shapeCount + "개의 도형 정보가 저장되었습니다!");
                    } catch (IOException e) {
                        System.out.println(" 파일 저장 중 에러가 발생했습니다: " + e.getMessage());
                    }
                    break;

               
                case 7:
                    try {
                        Scanner fileScanner = new Scanner(new File("shapes.txt"));
                        shapeCount = 0; // 기존에 화면에 있던 도형들은 싹 지우고 파일 정보로 덮어씌움
                        
                        while(fileScanner.hasNext()) { // 파일에 읽을 내용이 남아있는 동안 반복
                            String type = fileScanner.next(); // 첫 단어(도형 종류) 읽기
                            int fileId = fileScanner.nextInt();
                            
                            if(type.equals("Rectangle")) {
                                shapes[shapeCount++] = new Rectangle(fileId, fileScanner.nextInt(), fileScanner.nextInt(), fileScanner.next().charAt(0));
                            } else if(type.equals("RightTriangle")) {
                                shapes[shapeCount++] = new RightTriangle(fileId, fileScanner.nextInt(), fileScanner.next().charAt(0));
                            } else if(type.equals("Diamond")) {
                                shapes[shapeCount++] = new Diamond(fileId, fileScanner.nextInt(), fileScanner.next().charAt(0));
                            } else if(type.equals("VerticalLine")) {
                                shapes[shapeCount++] = new VerticalLine(fileId, fileScanner.nextInt(), fileScanner.next().charAt(0));
                            } else if(type.equals("HorizontalLine")) {
                                shapes[shapeCount++] = new HorizontalLine(fileId, fileScanner.nextInt(), fileScanner.next().charAt(0));
                            }
                        }
                        fileScanner.close();
                        System.out.println("파일에서 도형 정보를 성공적으로 불러왔습니다!");
                    } catch (FileNotFoundException e) {
                        
                        System.out.println("저장된 파일(shapes.txt)이 없습니다. 먼저 6번을 눌러 저장해주세요.");
                    }
                    break;

                case 8: 
                    shapeCount = 0; 
                    System.out.println("All objects deleted.");
                    break;
                case 9: 
                    System.out.println("\n--- Drawing All Objects ---");
                    for(int i = 0; i < shapeCount; i++) {
                        shapes[i].draw(); 
                    }
                    break;
                case 0:
                    System.out.println("exit.");
                    break;
            }
        }
    }
}