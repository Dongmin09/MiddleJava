package study.d1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student> {
	private int studentNum;
	private String studentName;
	private int korean;
	private int english;
	private int math;
	private int total;
	private int grade;

	public Student() {
	}

	public void setRank(int rank) {

	}

	public Student(int studentNum, String studentName, int korean, int english, int math) {
		super();
		this.studentNum = studentNum;
		this.studentName = studentName;
		this.korean = korean;
		this.english = english;
		this.math = math;
		total = korean + english + math;
	}

	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public int compareTo(Student stu) {
		return Integer.compare(this.getStudentNum(), stu.getStudentNum());
	}

	@Override
	public String toString() {
		return "학번=" + studentNum + ", 이름=" + studentName + ", 국어=" + korean + ", 영어=" + english + ", 수학=" + math
				+ ", 총점=" + total + ", 등수=" + grade;
	}

}

class TotalDesc implements Comparator<Student> {

	@Override
	public int compare(Student stu1, Student stu2) {
		int result = Integer.compare(stu1.getTotal(), stu2.getTotal()) * -1;
		if (result == 0)
			result = stu1.getStudentName().compareTo(stu2.getStudentName());
		return result;
	}

}

public class 리스트정렬1 {

	public void setRanking(List<Student> studentList) {
		for (Student std1 : studentList) {
			int grade = 1;
			for (Student std2 : studentList) {
				if (std1.getTotal() < std2.getTotal())
					grade++;
			}
			std1.setGrade(grade);
		}
	}

	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<>();

		studentList.add(new Student(202201, "우영우", 90, 95, 98));
		studentList.add(new Student(202202, "권민우", 88, 80, 79));
		studentList.add(new Student(202210, "이준호", 88, 99, 79));
		studentList.add(new Student(202204, "정명호", 82, 55, 90));
		studentList.add(new Student(202211, "태수미", 81, 44, 77));
		studentList.add(new Student(202206, "동그라미", 83, 76, 71));
		studentList.add(new Student(202213, "장보고", 10, 10, 10));
		studentList.add(new Student(202222, "하동훈", 0, 20, 10));
		studentList.add(new Student(202231, "김유신", 0, 0, 30));
		studentList.add(new Student(202224, "박나나", 10, 0, 0));
		
		System.out.println("등수 구하기");
		studentList.get(0).setGrade(1);
		System.out.println(studentList.get(0));
		int count = 0;
		for(int i=1; i<studentList.size(); i++){
			count++;
			if(studentList.get(i-1).getTotal()==studentList.get(i).getTotal()) {
				studentList.get(i).setGrade(count--);
			}
			else {
				count = i;
				studentList.get(i).setGrade(i+1);
			}
			System.out.println(studentList.get(i));
		}
		Collections.sort(studentList);
		System.out.println("학번 정렬 오름차순 : ");
		for (Student stu : studentList) {
			System.out.println(stu);
		}

		Collections.sort(studentList, new TotalDesc());

		System.out.println("총점 역순 내림차순 : ");
		for (Student stu : studentList) {
			System.out.println(stu);
		}

	}
}