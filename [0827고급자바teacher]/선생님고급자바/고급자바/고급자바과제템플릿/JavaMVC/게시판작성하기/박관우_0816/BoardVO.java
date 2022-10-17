package work;

import java.sql.*;

public class BoardVO {
	private int bdNo;
	private String bdTitle;
	private String bdWriter;
	private Date bdDate;
	private String bdContent;

	public BoardVO() {
	}

	public BoardVO(int bdNo, String bdTitle, String bdWriter, Date bdDate, String bdContent) {
		super();
		this.bdNo = bdNo;
		this.bdTitle = bdTitle;
		this.bdWriter = bdWriter;
		this.bdDate = bdDate;
		this.bdContent = bdContent;
	}

	public int getBdNo() {
		return bdNo;
	}

	public void setBdNo(int bdNo) {
		this.bdNo = bdNo;
	}

	public String getBdTitle() {
		return bdTitle;
	}

	public void setBdTitle(String bdTitle) {
		this.bdTitle = bdTitle;
	}

	public String getBdWriter() {
		return bdWriter;
	}

	public void setBdWriter(String bdWriter) {
		this.bdWriter = bdWriter;
	}

	public Date getBdDate() {
		return bdDate;
	}

	public void setBdDate(Date bdDate) {
		this.bdDate = bdDate;
	}

	public String getBdContent() {
		return bdContent;
	}

	public void setBdContent(String bdContent) {
		this.bdContent = bdContent;
	}

	@Override
	public String toString() {
		return String.format("BoardVO [bdNo=%s, bdTitle=%s, bdWriter=%s, bdDate=%s, bdContent=%s]", bdNo, bdTitle,
				bdWriter, bdDate, bdContent);
	}
}
