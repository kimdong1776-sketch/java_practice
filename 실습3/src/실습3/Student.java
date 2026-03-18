package 실습3;

public class Student {
	private String name;
	private double average;
	private float grade;
	/*
	 * 그냥 직접 접근하게 두면 편할 텐데, 왜 굳이 private으로 막고 메서드를 통하게 할까요? 바로 '데이터 보호' 때문입니다.
	 * 예를 들어, average 점수는 0점보다 낮거나 100점보다 높을 수 없죠? 만약 private이 아니라면
	 * 외부에서 실수로 -500점을 넣어도 막을 방법이 없습니다. 하지만 메서드를 통하면 필터링을 할 수 있어요.
	 */
	
	void setName(String _name) {
		this.name = _name;
	}
	
	public void setAverage (double _average) {
		this.average = _average;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getAverage() {
		return this.average;
	}
	
	public double getScore(double ...score) { 	
		double total = 0.0;
		for(double i : score) {
			total += i;
		}
		return total;
	}
	public void setGrade(float _grade) {
		this.grade = _grade;
	}
	public float getGrade() {
		return this.grade;
	}
}
