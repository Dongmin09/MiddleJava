package kr.or.ddit.basic;

import java.util.*;

public class StudentExample {
	public static void main(String[] args) {
		Student st = new Student();
		List<Student> list = new ArrayList<>();
		list.add(new Student("03", "이길동", 75, 64, 80));
		list.add(new Student("04", "박길동", 78, 15, 70));
		list.add(new Student("05", "윤길동", 99, 55, 7));
		list.add(new Student("10", "하길동", 90, 77, 44));
		list.add(new Student("06", "최길동", 100, 80, 90));
		list.add(new Student("01", "홍길동", 90, 90, 90));
		list.add(new Student("08", "장길동", 56, 46, 13));
		list.add(new Student("02", "김길동", 80, 80, 100));
		list.add(new Student("09", "신길동", 85, 23, 100));
		list.add(new Student("07", "고길동", 10, 100, 55));


		Collections.sort(list);
		System.out.println("학번의 오름차순 정렬 : ");
		
		for (int i = 0; i < list.size(); i++) {
			int rank = 1;
			for (int j = 0; j < list.size(); j++) {
                
                if (list.get(i).getTotalScore() < list.get(j).getTotalScore()) {
                    rank++;
                }
            }
            list.get(i).setRank(rank);
			
			System.out.println(list.get(i));
		}
		
		System.out.println();
		System.out.println("=====================================================================");
		System.out.println();

		Collections.sort(list, new SortDesc());
		System.out.println("총점의 내림차순 정렬(총점이 같으면 학번의 내림차순) : ");
		for (int i = 0; i < list.size(); i++) {
			
			System.out.println(list.get(i));
		}
	}

}

class SortDesc implements Comparator<Student> {

	@Override
	public int compare(Student st1, Student st2) {
		if (st1.getKoreaScore() + st1.getMathScore() + st1.getEnglishScore() > st2.getKoreaScore() + st2.getMathScore()
				+ st2.getEnglishScore()) {
			return -1;
		} else if (st1.getKoreaScore() + st1.getMathScore() + st1.getEnglishScore() == st2.getKoreaScore()
				+ st2.getMathScore() + st2.getEnglishScore()) {
			return -1;
		} else {
			return 1;
		}
	}
}

class Student implements Comparable<Student> {
	private String studentNo;
	private String name;
	private int koreaScore;
	private int mathScore;
	private int englishScore;
	private int totalScore;
	private int rank;

	public Student() {
	}

	public Student(String studentNo, String name, int koreaScore, int mathScore, int englishScore) {
		super();
		this.studentNo = studentNo;
		this.name = name;
		this.koreaScore = koreaScore;
		this.mathScore = mathScore;
		this.englishScore = englishScore;
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

	public int getKoreaScore() {
		return koreaScore;
	}

	public void setKoreaScore(int koreaScore) {
		this.koreaScore = koreaScore;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getTotalScore() {
		return koreaScore+mathScore+englishScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return String.format("학번 : %s, 이름 : %s, 국어점수 : %s, 수학점수 : %s, 영어점수 : %s, 총점 : %s, 등수 : %s", studentNo, name, koreaScore,
				mathScore, englishScore, getTotalScore(), rank);
	}

	@Override
	public int compareTo(Student st) {

		return this.getStudentNo().compareTo(st.getStudentNo());
	}

}
