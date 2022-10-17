package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student {
	public static void main(String[] args) {

		List<Stud> stuList = new ArrayList<Stud>();

		stuList.add(new Stud("2001", "홍길동", 90, 80, 100));
		stuList.add(new Stud("2002", "변학도", 80, 80, 90));
		stuList.add(new Stud("2003", "성춘향", 50, 60, 80));
		stuList.add(new Stud("2004", "이순신", 100, 60, 80));
		stuList.add(new Stud("2005", "강감찬", 80, 90, 80));

		Collections.sort(stuList);

		System.out.println("학번의 오름차순으로 정렬 : ");
		for (Stud stu : stuList) {
			System.out.println(stu);
		}
		System.out.println();

		Collections.sort(stuList, new SortTotalScoreDesc());

		System.out.println("총점의 역순으로 정렬 : ");
		for (Stud stu : stuList) {
			System.out.println(stu);
		}
	}
}

class SortTotalScoreDesc implements Comparator<Stud> {

	@Override
	public int compare(Stud stu1, Stud stu2) {
		if (stu1.getTotalScore() > stu2.getTotalScore()) {
			return -1;
		} else if (stu1.getTotalScore() == stu2.getTotalScore()) {
			return stu1.getNum().compareTo(stu2.getNum()) * -1;
		} else {
			return 1;
		}
	}
}

class Stud implements Comparable<Stud> {

	private String num;
	private String name;
	private int koreanScore;
	private int englishScore;
	private int mathScore;
	private int totalScore;
	private int rank;

	public Stud(String num, String name, int koreanScore, int englishScore, int mathScore) {
		super();
		this.num = num;
		this.name = name;
		this.koreanScore = koreanScore;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
		this.totalScore = koreanScore + englishScore + mathScore;
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

	public int getKoreanScore() {
		return koreanScore;
	}

	public void setKoreanScore(int koreanScore) {
		this.koreanScore = koreanScore;
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
		return totalScore;
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
		return String.format("학번 : %s, 이름 : %s, 국어점수 : %d, 영어점수 : %d, 수학점수 : %d, 총점 : %d", num, name, koreanScore,
				englishScore, mathScore, totalScore);
	}

	@Override
	public int compareTo(Stud stu) {
		// TODO Auto-generated method stub
		return this.getNum().compareTo(stu.getNum());
	}
}