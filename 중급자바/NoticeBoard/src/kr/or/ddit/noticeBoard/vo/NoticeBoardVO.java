package kr.or.ddit.noticeBoard.vo;

import java.util.Date;

public class NoticeBoardVO {
	
	private int nbNum;  // 글번호
	private String nbTt; // 제목
	private String nbWt; // 작성자
	private Date nbDate; // 작성날짜
	private String nbCt; // 내용
	/**
	 * @return the nbNum
	 */
	public int getNbNum() {
		return nbNum;
	}

	public void setNbNum(int nbNum) {
		this.nbNum = nbNum;
	}

	public String getNbTt() {
		return nbTt;
	}

	public void setNbTt(String nbTt) {
		this.nbTt = nbTt;
	}

	public String getNbWt() {
		return nbWt;
	}

	public void setNbWt(String nbWt) {
		this.nbWt = nbWt;
	}

	public Date getNbDate() {
		return nbDate;
	}

	public void setNbDate(Date nbDate) {
		this.nbDate = nbDate;
	}

	public String getNbCt() {
		return nbCt;
	}

	public void setNbCt(String nbCt) {
		this.nbCt = nbCt;
	}

	@Override
	public String toString() {
		return "NoticeBoardVO [nbNum=" + nbNum + ", nbTt=" + nbTt + ", nbWt=" + nbWt + ", nbDate=" + nbDate + ", nbCt="
				+ nbCt + "]";
	}
	
	
	
	
}
