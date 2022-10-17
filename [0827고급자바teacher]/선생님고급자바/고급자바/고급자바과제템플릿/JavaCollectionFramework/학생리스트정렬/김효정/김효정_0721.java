package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class A01 {
	public static void main(String[] args) {
		
		List<Student> stuList = new ArrayList<Student>();
		
		stuList.add(new Student("101", "김효정", 90, 80, 70));
		stuList.add(new Student("102", "윤다영", 90, 80, 70));
		stuList.add(new Student("103", "성민정", 70, 85, 100));
		stuList.add(new Student("104", "길선주", 70, 90, 75));
		stuList.add(new Student("105", "이승연", 95, 85, 85));
		stuList.add(new Student("106", "허지현", 100, 80, 65));
		
		
		
		Collections.sort(stuList);
		System.out.println("학번 오름차순 정렬: ");
		for(Student stu : stuList) {
			System.out.println(stu);
		}
		
		System.out.println("--------------------------------");
		
		Collections.sort(stuList, new SortScoreDesc());
		System.out.println("총점 내림차순 정렬: ");
		
		 for(Student stu : stuList) {
			 System.out.println(stu);
		 }
	}
	
}


class SortScoreDesc implements Comparator<Student> {
	
	@Override
	public int compare(Student stu1, Student stu2) {
		
		if(stu1.getScore() == stu2.getScore()) {
			return -1;
		} else {
			return new Integer(stu1.getScore()).compareTo(stu2.getScore()) * -1;
		}
	}
}

class Student implements Comparable<Student> {
	
	private String num; // 학번
	private String name; // 이름
	private int Korean; // 국어점수
	private int English; // 영어점수
	private int Math; // 수학점수
	private int Score; // 총점
	private int Grade; // 등수
	
	public Student(String num, String name, int korean, int english, int math) {
		super();
		this.num = num;
		this.name = name;
		this.Korean = korean;
		this.English = english;
		this.Math = math;
		this.Score = korean + english + math;
//		this.Grade = Grade;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorean() {
		return Korean;
	}

	public void setKorean(int korean) {
		Korean = korean;
	}

	public int getEnglish() {
		return English;
	}

	public void setEnglish(int english) {
		English = english;
	}

	public int getMath() {
		return Math;
	}

	public void setMath(int math) {
		Math = math;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;

	}

	public int getGrade() {
		return Grade;
	}

	public void setGrade(int grade) {
		Grade = grade;
	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", Korean=" + Korean + ", English=" + English + ", Math="
				+ Math + ", Score=" + Score + ", Grade=" + Grade + "]";
	}
	

	@Override
	public int compareTo(Student stu) {
		return this.getNum().compareTo(stu.getNum());
	}
}
	
