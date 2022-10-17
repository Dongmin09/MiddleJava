package border.vo;

import java.sql.Date;

public class BorderVO {

	private String borNo;
	private String borTit;
	private String borWrit;
	private String borCon;
	
	private String regDate;

	public String getBorNo() {
		return borNo;
	}

	public void setBorNo(String borNo) {
		this.borNo = borNo;
	}

	public String getBorTit() {
		return borTit;
	}

	public void setBorTit(String borTit) {
		this.borTit = borTit;
	}

	public String getBorWrit() {
		return borWrit;
	}

	public void setBorWrit(String borWrit) {
		this.borWrit = borWrit;
	}

	public String getBorCon() {
		return borCon;
	}

	public void setBorCon(String borCon) {
		this.borCon = borCon;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return  ", 제목 =" + borTit + ",  작성자 =" + borWrit + ", 내용=" + borCon
				+ "]";
	}
	
	
}
