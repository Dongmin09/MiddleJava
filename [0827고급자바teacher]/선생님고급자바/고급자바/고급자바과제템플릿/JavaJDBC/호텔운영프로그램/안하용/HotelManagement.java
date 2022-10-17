package kr.or.ddit.basic.exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import kr.or.ddit.basic.util.JDBCUtil;

import java.util.Scanner;

public class HotelManagement {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Scanner scan;
	
	
	public HotelManagement() {
		scan = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		new HotelManagement().run();
	}
	
	private void run() {
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************\n");
		while(true) {
			displayMenu();
			System.out.print("메뉴선택 => ");
			String menu = scan.nextLine();
			System.out.println();
			switch(menu) {
				case "1":
					checkIn();
					break;
				case "2":
					checkOut();
					break;
				case "3":
					roomStatus();
					break;
				case "4":
					System.out.println("**************************");
					System.out.println("호텔 문을 닫았습니다.");
					System.out.println("**************************");
					scan.close();
					return;
				default:
					System.out.println("없는 메뉴입니다.");
			}
			
		}
	}
	
	private void checkIn() {
		
		boolean chk = false;
		String roomNum = "";
		do {
			System.out.println("어느방에 체크인 하시겠습니까?");
			System.out.print("방번호 입력 => ");
			roomNum = scan.nextLine();
			
			chk = checkRoom(roomNum);
			
			if(chk) {
				System.out.println(roomNum + "방은 이미 체크인되었습니다.");
				System.out.println("다시입력해주세요.");
				System.out.println();
			}
			
		}while (chk);
		
		System.out.println();
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 => ");
		String name = scan.nextLine();
		try {
			conn = JDBCUtil.getConnetion();
			
			StringBuilder builder = new StringBuilder();
			builder.append(" INSERT INTO hotel_mng  (");
			builder.append("     room_num,");
			builder.append("     guest_name ");
			builder.append(" ) VALUES (");
			builder.append("     ?,");
			builder.append("     ?)");
			String sql = builder.toString();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roomNum);
			pstmt.setString(2, name);
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println(roomNum + "번방 체크인 성공!");
			} else {
				System.out.println(roomNum + "번방 체크인 실패!");
			}
			System.out.println();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 반납
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
	}
	
	private boolean checkRoom(String roonNum) {
		boolean chk = false;
		
		try {
			conn = JDBCUtil.getConnetion();
			
			StringBuilder builder = new StringBuilder();
			builder.append(" SELECT");
			builder.append("     COUNT(*) as cnt");
			builder.append(" FROM");
			builder.append("     hotel_mng ");
			builder.append(" WHERE");
			builder.append("     room_num = ?");
			
			String sql = builder.toString();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roonNum);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int result = rs.getInt("cnt");
				chk = result > 0 ? true : false;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
		
		return chk;
	}
	
	private void roomStatus() {
		
		try {
			conn = JDBCUtil.getConnetion();
			
			String sql = "select * from hotel_mng ";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String roomNum = rs.getString("room_num");
				String name = rs.getString("guest_name");
				System.out.println("방번호 : " + roomNum + ", 투숙객 : "
						+ name);
			}
			System.out.println();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
		
	}
	
	private void checkOut() {
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		String roomNum = scan.nextLine();
		try {
			
			conn = JDBCUtil.getConnetion();
			
			StringBuilder builder = new StringBuilder();
			builder.append(" DELETE FROM hotel_mng  WHERE");
			builder.append("     room_num =?");
			String sql = builder.toString();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roomNum);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println(roomNum + "번방 체크아웃 되었습니다");
			} else {
				System.out.println(roomNum + "번방은 체크인되지 않았습니다.");
			}
			System.out.println();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
		
	}
	
	private void displayMenu() {
		System.out.println("*******************************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인\t2.체크아웃\t3.객실상태\t4.업무종료");
		System.out.println("*******************************************");
	}
	
}
