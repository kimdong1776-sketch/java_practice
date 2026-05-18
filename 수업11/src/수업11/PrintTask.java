package 수업11;

public class PrintTask implements Runnable{
	private String myName;
	public PrintTask(String name) {
		myName = name;
	}
	
	@Override
	public void run() {
		int sum = 0 ;
		for(int i = 0 ; i < 100; i++) {
			sum = sum + i;
			System.out.println(myName +"sum = " + sum);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("");
	}
}
