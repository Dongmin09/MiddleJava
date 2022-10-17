package homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.JDBCUtil;

public class Hotel {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Scanner scan = new Scanner(System.in); 

	/**
	 * 프로그램 시작메서드
	 */
	
	public void displayMenu(){
		System.out.println();
		System.out.println("*********************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인  2.체크아웃  3.객실상태  4.업무종료");
		System.out.println("*********************************");
		System.out.print(" 메뉴선택 => ");		
	}
		
	public void start(){
		
		System.out.println();
		System.out.println("***************");
		System.out.println("호텔 문을 열었습니다. ");
		System.out.println("***************");
		
		int choice;
		do{
			displayMenu(); //메뉴 출력
			
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch (choice){
				case 1 :  // 자료 입력
					insertHotel();
					break;
				case 2 :  // 자료 삭제
					deleteHotel();
					break;
				case 3 :  // 자료 수정
					displayHotelAll();
					break;
				case 4 :  // 전체 자료 출력
					System.out.println();
					System.out.println("***************");
					System.out.println("호텔 문을 닫았습니다. ");
					System.out.println("***************");
					break;
				default :
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while (choice != 4);
	}

	/**
	 * 회원정보를 추가하는 메서드
	 */
	private void insertHotel() {
				
	    boolean chk = false;
		
		String roomNum = "";
		
		do {
			System.out.println();
			System.out.println("어느방에 체크인 하시겠습니까?");
			System.out.print("방번호 입력 => ");
			
			roomNum = scan.next();
			
			chk = checkRoom(roomNum);
			
			if (chk == true) {
				System.out.println(roomNum + "방에는 이미 사람이 있습니다.");
			}
			
		} while(chk == true);
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 => ");
	    String guestName = scan.next();
		
		try  {
			conn = JDBCUtil.getConnection();
			
			String sql = " INSERT INTO hotel_mng ( room_num, guest_name) " 
					   + " VALUES (?, ?) ";
				
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roomNum);
			pstmt.setString(2, guestName);
						
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("체크인 되었습니다.");
			} else {
				System.out.println("체크인 실패!");
			}
							
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			// 자원반납...
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
	}
	
	/**
	 * 회원ID를 이용하여 회원이 존재하는지 알려주는 메서드
	 * @param memId
	 * @return 회원이 존재하면 true, 없으면 false 리턴함.
	 */

	private boolean checkRoom(String roomNum) {
		
		boolean chk = false;
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = " select count(*) as cnt from hotel_mng " 
			           + " where room_num = ? ";
			
			pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, roomNum);
			
			rs = pstmt.executeQuery();
			// return 값이 ResultSet이므로 resultSet 변수에 담음.
			
			int cnt = 0;
			
			if(rs.next()) {
				cnt = rs.getInt("cnt");  
				// 컬럼 이름을 주어도, 컬럼 인덱스 번호를 주어도된다.
			}
			
			if (cnt > 0) {
				chk = true;
			}			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
		
		return chk;
	}
	
	/**
	 * 회원 정보를 수정하는 메서드
	 */
	
	private void deleteHotel() {
		System.out.println();
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		
		String roomNum = scan.next();
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = "delete from hotel_mng where room_num = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roomNum);
			
			int cnt = pstmt.executeUpdate();
			
			if (cnt > 0) {
				System.out.println("체크아웃 되었습니다.");
			} else {
				System.out.println("체크아웃 실패!!!");
			}
					
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
	}
	
	/**
	 * 전체 회원 정보를 출력하는 메서드
	 */
	private void displayHotelAll() {
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = "select * from hotel_mng";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String roomNum = rs.getString("room_num");
				String questName = rs.getString("guest_name");
				System.out.println("방번호: " + roomNum + "\t" 
				                    + "투숙객 : " + questName);
			}
	
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
	}
	
	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		hotel.start();
	}
}

