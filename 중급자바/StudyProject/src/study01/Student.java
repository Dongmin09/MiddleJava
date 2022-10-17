package study01;

public class Student {

	private String studentName;
	private int grade;
	private int studentMoney;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getStudentMoney() {
		return studentMoney;
	}

	public void setStudentMoney(int studentMoney) {
		this.studentMoney = studentMoney;
	}

	public Student(String studentName, int studentMoney) {
		
		this.studentName = studentName;
		this.studentMoney = studentMoney;
	}
	
	public void takeBus() {
		studentMoney -= 1000;
	}
	
	public void takeSubway() {
		studentMoney -= 1500;
	}
	
	public void showinf() {
		System.out.println(studentName + "님의 잔액은" + studentMoney + "입니다.");
	}
	
}
