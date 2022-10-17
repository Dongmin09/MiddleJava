package kr.or.ddit.noticeBoard.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {

	// Properties 이용

	static Properties brprop; // properties 객체 변수 선언

	static {

		brprop = new Properties();

		try {
			brprop.load(new FileInputStream("res/db.properties"));

			Class.forName(brprop.getProperty("driver"));
			System.out.println("서버 연결 완료.");
		} catch (ClassNotFoundException e) {
			System.out.println("서버 연결 실패.");
		} catch (IOException e) {
			System.out.println("해당 파일이 없거나 입출력 오류입니다.");
			e.printStackTrace();
		}

	}
	
	//연결 객체 생성하기
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					brprop.getProperty("url"),
					brprop.getProperty("username"),
					brprop.getProperty("password"));

		} catch (SQLException e) {
			System.out.println("DB 연결 실패!!");
			e.printStackTrace();
			return null;
		}
	}
	
	// 자원 반납 메소드
	public static void close(Connection conn,						
							 Statement stmt,
							 PreparedStatement pstmt,
							 ResultSet rs) {
		if(rs !=null) try {rs.close();} catch(SQLException e) {}
		if(stmt != null) try {stmt.close();} catch(SQLException e) {}
		if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
		if(conn != null) try {conn.close();} catch(SQLException e) {}	
	}
}
