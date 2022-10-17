package kr.or.ddit.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Hotel {
	static Connection conn;
	static Statement stmt;
	static PreparedStatement pstmt;
	static ResultSet rs;
	
	static Scanner scan = new Scanner(System.in);
	
	static boolean checkMember(String memId) {
		boolean chk = false;
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = " select count(*) as cnt from hotel\n" + 
					" where room_num = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			rs = pstmt.executeQuery();
			
			int cnt = 0;
			
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			if(cnt > 0) {
				chk = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
		return chk;
	}
	
	public static void main(String[] args) {
		
		boolean exitNum = true;
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		while(exitNum) {
			Scanner sc = new Scanner(System.in);
			System.out.println("*******************************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
			System.out.println("*******************************************");
			System.out.print("메뉴를 입력하세요: ");
			
			int menu = sc.nextInt();
			switch (menu) {
			case 1:	
				boolean chk = false;
				
				String roomNum = "";
				do {
					System.out.println();
					System.out.print("체크인할 방 번호 >> ");
					
					roomNum = scan.next();
					
					chk = checkMember(roomNum);
				
					if(chk == true) {
						System.out.println(roomNum+"은 이미 체크인됐습니다.");
						System.out.println("다시입력해주세요.");
					}
				}while(chk == true);
				
				 System.out.print("이름 >> ");
				 String name = scan.next();
				
				 try {
					conn = JDBCUtil.getConnection();
					
					String sql = "   INSERT INTO hotel (\n" + 
							"    room_num,\n" + 
							"    name\n" + 
							") VALUES (\n" + 
							"    ?,\n" + 
							"    ?\n" + 
							")";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, roomNum);
					pstmt.setString(2, name);
					
					int cnt = pstmt.executeUpdate();
					
					if(cnt > 0) {
						System.out.println(roomNum+ "체크인 성공!");
					}else {
						System.out.println(roomNum + "체크인 실패!!");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					JDBCUtil.close(conn, stmt, pstmt, rs);
				}
				 break;
			case 2:
				System.out.println();
				System.out.println("체크아웃할 방번호를 입력하세요");
				System.out.print("방번호 >> ");
				String roomNum2 = scan.next();
				try {
					conn = JDBCUtil.getConnection();
					
					String sql = "delete from hotel where room_num = ?";
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, roomNum2);
					
					int cnt = pstmt.executeUpdate();
					if(cnt > 0) {
						System.out.println(roomNum2 + "방 체크아웃 성공!");
					}else {
						System.out.println(roomNum2 + "방 체크아웃 실패!!");
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					JDBCUtil.close(conn, stmt, pstmt, rs);
				}
				
			case 3:
				System.out.println();
				System.out.println("==============");
				System.out.println("방번호\t이름");
				System.out.println("==============");
				try {
					conn = JDBCUtil.getConnection();
					
					String sql = "select * from hotel";
					
					stmt = conn.createStatement();
					
					rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						String roomNum3 = rs.getString("room_num");
						String Name = rs.getString("name");
						
						
						System.out.println(roomNum3 + "\t"+Name);
					}
					System.out.println("=======================================");
					System.out.println("출력작업 끝...");
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					JDBCUtil.close(conn, stmt, pstmt, rs);
				}
				break;
			case 4:
				System.out.println("이용해주셔서 감사합니다.");
				exitNum = false;
				break;
			}
		}
	}
}


class JDBCUtil {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 완료!");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!!!");
		}
	}
	
	/**
	 *  커넥션 객체 생성하기
	 * @return
	 */
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"pc04",
					"java");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패!!");
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
	 */
	public static void close(Connection conn, Statement stmt,
							PreparedStatement pstmt, ResultSet rs){
		if(rs != null) try {rs.close();}catch(SQLException e) {}
		if(stmt != null) try {stmt.close();}catch(SQLException e) {}
		if(pstmt != null) try {pstmt.close();}catch(SQLException e) {}
		if(conn != null) try {conn.close();}catch(SQLException e) {}
	}

}

