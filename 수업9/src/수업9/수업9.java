package 수업9;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class 수업9 {
	
	public static void main(String[] args) throws IOException {//throws 키워드를 작성하거나 try catch구문을 하거나
		Path path = Paths.get("text.txt"); // 상대디렉토리 절대디렉토리
	
//		try {
//			Scanner input = new Scanner(path);
//			while (input.hasNext()) {
//				String str = input.nextLine();
//				System.out.println(">>" + str); // 파일 한 줄씩 입력 받음.
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		try {
			Scanner input = new Scanner (path);
			int N;
			int sum;
			N = input.nextInt();
			sum = 0;
			for(int i = 0; i < N; i++) {
				int val = input.nextInt();
				sum += val;
			}
			System.out.println(N);
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	public static void main1(String [] args) {
		String s1 = "hello";
		String s2 = new String("hello");
		
		String s3 = s1 + s2; //concatnation
		s3.concat(s1 + s2);//?
		s3 = String.valueOf(2100000000);

		if(s1 == s2) { //둘다 hello 임에도 불구하고 false 임.  String.equals(); 써야 함.
			System.out.println("True");
		}
		else {
			System.out.println("false");
		}
		System.out.println(s1);
		System.out.println(s2);
	}
}
