package kr.or.ddit.basic.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 리스트정렬 {
	public static void main(String[] args) {

		List<Student> list = new ArrayList<Student>();
		list.add(new Student("a08", "홍길동", 95, 90, 80));
		list.add(new Student("a03", "이순신", 80, 85, 100));
		list.add(new Student("a17", "갈매기", 75, 65, 70));
		list.add(new Student("a81", "우영우", 100, 90, 100));
		list.add(new Student("a05", "이준호", 90, 90, 80));
		
		Collections.sort(list);
		for (Student student : list) {
			System.out.println(student);
		}
		System.out.println();
		Collections.sort(list, new studentDesc());
		for (Student student : list) {

			System.out.println(student);
		}
	}
}

class Student implements Comparable<Student> {
	private String studentNo; // 학번
	private String name; // 이름
	private int kor; // 국어점수
	private int eng; // 영어점수
	private int math; // 수학 점수
	private int total; // 총점
	private int grade; // 등수

	public Student(String studentNo, String name, int kor, int eng, int math) {
		super();
		this.studentNo = studentNo;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
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
		return this.getStudentNo().compareTo(stu.getStudentNo());
	}
	@Override
	public String toString() {
		return "Student [studentNo=" + studentNo + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math
				+ ", total=" + total + ", grade=" + grade + "]";
	}

}

class studentDesc implements Comparator<Student> {

	@Override
	public int compare(Student stu1, Student stu2) {

		if (stu1.getTotal() > stu2.getTotal()) {
			return -1;
		} else if (stu1.getTotal() == stu2.getTotal()) {
			return new Integer(stu1.getStudentNo().compareTo(stu2.getStudentNo()))*-1;
		} else {
			return 1;
		}
	}
}