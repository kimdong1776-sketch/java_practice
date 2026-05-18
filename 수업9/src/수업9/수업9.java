package 수업9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class 수업9 {
	
	public static void main(String[] args) throws IOException {//throws 키워드를 작성하거나 try catch구문을 하거나
		//읽기
		Path path = Paths.get("text.txt"); // 상대디렉토리 절대디렉토리
		//Scanner input = new Scanner(Paths.get(filename);
		//rectNUm = input.nextInt();
		//file에서 불러오려면 LoadFromFile같은 메서드 만들고 인자로 Scanner input을 전달 받으면 되겠구나!! 파일 포인터는 처음호출한 애가 아니까 만약 파일 네임만 전달하면 매번 처음 줄 밖에 못 읽음.
		//loadfile은 
		/*
		 * int tmp;
		 * tmp = input.nextInt();
		 * setId(tmp);
		 * tmp = input.nextInt();
		 * setLength(tmp);
		 * char ch;
		 * ch = input.nextCharacter();
		 * ch = input.nextCharacter();
		 * set.Pattern(ch);
		 * height = input.nextInt();
		 * 
		 * */
		//compareTo 메서드는 뭐지. equals랑 다른가
		try {
			Scanner input = new Scanner(path);
			while (input.hasNext()) {
				String str = input.nextLine();
				System.out.println(">>" + str); // 파일 한 줄씩 입력 받음.
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
//		try {
//			Scanner input = new Scanner (path);
//			int N;
//			int sum;
//			N = input.nextInt();
//			sum = 0;
//			for(int i = 0; i < N; i++) {
//				int val = input.nextInt();
//				sum += val;
//			}
//			System.out.println(N);
//		}catch(IOException e){
//			e.printStackTrace();
//		}
		int sum = 0;
		//쓰기
		String content = "result" + sum;
		try {
			Files.writeString(Path.of("result.txt"), content); // 이어서 쓰기
			//덮어쓰기
			//StandardOpenOption.APPEND를 3번째 인자에넣기.
			//int형을 문자열로 바꾸는 쉬운 방법. Stirng str = num + " "등으로하면됨.
		}catch (IOException e) {
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
