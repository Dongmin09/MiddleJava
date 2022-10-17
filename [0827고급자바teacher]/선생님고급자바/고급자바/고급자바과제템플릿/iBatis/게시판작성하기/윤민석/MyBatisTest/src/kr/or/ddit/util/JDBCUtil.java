package kr.or.ddit.util;

import java.sql.*;

public class JDBCUtil {
	static { // 1번만 실행됨
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 완료!");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
		}
	}
	/**
	 * 커넥션 객체 생성하기
	 * @return
	 */
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pc22","java");
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
