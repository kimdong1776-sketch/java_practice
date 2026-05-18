package 수업11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMain {
	
	public static void main(String[] args) {
		
		PrintTask task1 = new PrintTask("task 1");
		PrintTask task2 = new PrintTask("task 2");
		
		ExecutorService execService = Executors.newCachedThreadPool();
		execService.execute(task1); //PrintTask의 run이 실행
		execService.execute(task2);
		
		execService.shutdown();
	}
}
