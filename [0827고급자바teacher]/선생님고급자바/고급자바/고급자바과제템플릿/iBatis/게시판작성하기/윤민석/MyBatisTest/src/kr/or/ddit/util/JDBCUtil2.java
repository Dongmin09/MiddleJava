package kr.or.ddit.util;

import java.io.*;
import java.sql.*;
import java.util.*;

public class JDBCUtil2 {
	static Properties prop; // Properties 객체변수 선언
	static { // 1번만 실행됨
		prop = new Properties();
		try {
			prop.load(new FileInputStream("res/db.properties"));
			
			Class.forName(prop.getProperty("driver"));
			System.out.println("드라이버 로딩 완료!");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
		} catch (IOException e) {
			System.out.println("해당 파일이 없거나 입출력 오류입니다.");
		}
	}
	/**
	 * 커넥션 객체 생성하기
	 * @return
	 */
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
		} catch (Exception e) {
			System.out.println("DB 연결 실패!");
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 자원 반납
	 * @param conn
	 * @param stmt
	 * @param pstmt
	 * @param rs
	 * @throws Exception
	 */
	public static void close(Connection conn, 
							 Statement stmt, 
							 PreparedStatement pstmt, 
							 ResultSet rs) throws Exception {
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
}
