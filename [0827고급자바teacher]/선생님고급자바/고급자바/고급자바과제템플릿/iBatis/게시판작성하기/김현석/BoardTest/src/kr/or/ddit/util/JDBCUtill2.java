package kr.or.ddit.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.xml.internal.fastinfoset.sax.Properties;

/*
 *  db.properties파일의 내용으로 DB정보를 설정하는 방법
 *  방법1") Properties 객체 이용하기 
 *  방법2)
 * 
 */
public class JDBCUtill2 {
	static java.util.Properties prop; //Properties 객체변수 선언
	
	static {
		prop = new java.util.Properties();
		
		try {
			prop.load(new FileInputStream("res/db.properties"));
//			Class<?> clazz = Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(prop.getProperty("driver"));			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 완료");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}catch (IOException e) {
			System.out.println("해당 파일이 없거나 입출력 오류입니다.");
			e.printStackTrace();
		}
	}
	/*
	 * 커넥션 객체 생성하기 
	 */
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
			return null;
		}
	}
	//자원반납하는 메소드
	
	public static void close(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) try {rs.close();}catch (SQLException e) {}
		if(stmt != null) try {stmt.close();}catch (SQLException e) {}
		if(conn != null) try {conn.close();}catch (SQLException e) {}
		if(pstmt != null) try {pstmt.close();}catch (SQLException e) {}
		
	}
}
