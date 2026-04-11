package 숙제4;

import java.util.Scanner;

public class testMain {
	public static final int QUIT = 0;
	public static final int MAX_SIZE = 10;

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
		System.out.println("Enter your choice");
	}
	public static void main(String[] args) {
		
		
		Rectangle[] Rectarr  = new Rectangle [MAX_SIZE];
		RightTriangle[] Rtriarr  = new RightTriangle [MAX_SIZE];
		Diamond[] Diamarr  = new Diamond [MAX_SIZE];
		VerticalLine[] Vlinearr  = new VerticalLine [MAX_SIZE];
		HorizontalLine[] Hlinearr  = new HorizontalLine [MAX_SIZE];
		
		Scanner input = new Scanner(System.in);
		int choice = 1;
		int rectIdx = 0, rtriIdx = 0, diamIdx = 0, vlineIdx = 0, hlineIdx = 0;
				
		while(choice != QUIT) {
			printMenu();
			
			int id, w, h, len;
            char p;
            choice = input.nextInt();
            
			switch (choice) {
            case 1: // Rectangle
                System.out.println("Enter >> id, width, height, pattern");
                id = input.nextInt(); w = input.nextInt(); h = input.nextInt();
                p = input.next().charAt(0);
                Rectangle rect = new Rectangle(id, w, h, p);
                Rectarr[rectIdx++] = rect;
                rect.draw(); // 생성 후 바로 그리기
                break;

            case 2: // RightTriangle
                System.out.println("Enter >> id, height, pattern");
                id = input.nextInt(); h = input.nextInt();
                p = input.next().charAt(0);
                RightTriangle rtri = new RightTriangle(id, h, p);
                Rtriarr[rtriIdx++] = rtri;
                rtri.draw();
                break;

            case 3: // Diamond
                System.out.println("Enter >> id, size(odd), pattern");
                id = input.nextInt(); len = input.nextInt();
                p = input.next().charAt(0);
                Diamond diam = new Diamond(id, len, p);
                Diamarr[diamIdx++] = diam;
                diam.draw();
                break;

            case 4: // VerticalLine
                System.out.println("Enter >> id, length, pattern");
                id = input.nextInt(); len = input.nextInt();
                p = input.next().charAt(0);
                VerticalLine vline = new VerticalLine(id, len, p);
                Vlinearr[vlineIdx++] = vline;
                vline.draw();
                break;

            case 5: // HorizontalLine
                System.out.println("Enter >> id, length, pattern");
                id = input.nextInt(); len = input.nextInt();
                p = input.next().charAt(0);
                HorizontalLine hline = new HorizontalLine(id, len, p);
                Hlinearr[hlineIdx++] = hline;
                hline.draw();
                break;

            case 8: // Delete all
                rectIdx = 0; rtriIdx = 0; diamIdx = 0; vlineIdx = 0; hlineIdx = 0;
                System.out.println("All objects deleted from management.");
                break;

            case 9: // Draw all 
                System.out.println("\n--- Drawing All Objects ---");
                for(int i=0; i<rectIdx; i++) Rectarr[i].draw();
                for(int i=0; i<rtriIdx; i++) Rtriarr[i].draw();
                for(int i=0; i<diamIdx; i++) Diamarr[i].draw();
                for(int i=0; i<vlineIdx; i++) Vlinearr[i].draw();
                for(int i=0; i<hlineIdx; i++) Hlinearr[i].draw();
                break;
            case 11: for (int i = 0; i < rectIdx; i++) Rectarr[i].draw(); break;
            case 12: for (int i = 0; i < rtriIdx; i++) Rtriarr[i].draw(); break;
            case 13: for (int i = 0; i < diamIdx; i++) Diamarr[i].draw(); break;
            case 14: for (int i = 0; i < vlineIdx; i++) Vlinearr[i].draw(); break;
            case 15: for (int i = 0; i < hlineIdx; i++) Hlinearr[i].draw(); break;
            case 0:
                System.out.println("exit.");
                break;
        }
			
		}
		
	}
}
