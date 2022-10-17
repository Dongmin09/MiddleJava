package kr.or.ddit.homework;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import kr.or.ddit.util.JDBCUtil;
import kr.or.ddit.util.JDBCUtil3;

public class Board<E> {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Scanner scan = new Scanner(System.in); 

	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu(){
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 게 시 판 ===");
		System.out.println("  1. 새글 작성");
		System.out.println("  2. 수정");
		System.out.println("  3. 삭제");
		System.out.println("  4. 검색");
		System.out.println("  5. 전체 목록 출력");
		System.out.println("  6. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("게시판 메뉴 선택 >> ");
	}
	
	/**
	 * 프로그램 시작메서드
	 */
	public void start(){
		int choice;
		do{
			displayMenu(); //메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch(choice){
				case 1 :  // 자료 입력
					insertWrite();
					break;
				case 2 :  // 자료 수정 
					updateWrite();
					break;
				case 3 :  // 자료 삭제
					deleteWrite();
					break;
				case 4 :  // 자료 검색
					searchWrite();
					break;
				case 5 :  // 전체 자료 출력
					displayWriteAll();
					break;
				case 6 :  // 작업 끝
					System.out.println("작업을 마칩니다.");
					break;
				default :
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while(choice!=6);
	}

/**
 *  전체 자료 출력	
 */
	private void displayWriteAll() {
		System.out.println();
		System.out.println("---------------------------------------------------------");
		System.out.println("번 호\t 날 짜\t\t제 목\t작성자\t\t내 용");
		System.out.println("---------------------------------------------------------");
		try {
			conn = JDBCUtil.getcConnection();
			
			String sql = "select * from jdbc_board";
			
			stmt= conn.createStatement();
			
			rs = stmt.executeQuery(sql);
		
			while(rs.next()) {
				int no = rs.getInt("board_no");
				Date date = rs.getDate("board_date");
				String title = rs.getString("board_title");
				String writer = rs.getString("board_writer");
				String content = rs.getString("board_content");
				
				System.out.println(no + "\t" + date + "\t"
						   + title + "\t" + writer +"\t\t" + content);
			}
			System.out.println("---------------------------------------------------------");
			System.out.println("출력 작업 끝...");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(null, stmt, pstmt, rs);
		}
	}

	/**
	 * 게시글 검색 메소드
	 */
	private void searchWrite() {
		System.out.println();
		System.out.println("검색할 게시글 번호를 입력하세요.");
		scan.nextLine();
		System.out.print("번호>> ");
		String no = scan.nextLine().trim();
		System.out.print("작성자 >> ");
		String writer = scan.nextLine().trim();
		System.out.print("제목>> ");
		String title = scan.nextLine().trim();
		System.out.print("내용 >> ");
		String content = scan.nextLine().trim();

		
		try {
			conn = JDBCUtil3.getConnection();
			String sql = "select * from jdbc_board where 1=1 and board_no = ? "
					+ " and board_writer = ? and board_title = ? and board_content = ? ";
			
			pstmt = conn.prepareStatement(sql);
			if(no != null && !no.equals("0")) {
				sql += " and board_no = ? ";
			}
			if(writer != null && ! writer.equals("")) {
				sql += " and board_writer = ? ";
			}
			if(title != null && ! title.equals("")) {
				sql += " and board_title = ? ";
			}
			if(content != null && ! content.equals("")) {
				sql += " and board_content like '%' || ? || '%' ";
			}
			pstmt.setString(1, no);
			pstmt.setString(2, writer);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no2 = rs.getInt("board_no");
				Date date = rs.getDate("board_date");
				String title2 = rs.getString("board_title");
				String writer2 = rs.getString("board_writer");
				String content2 = rs.getString("board_content");
				
				System.out.println(no2 + "\t" + date + "\t"
						   + title2 + "\t" + writer2 +"\t\t" + content2);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return ;
		}



	private void deleteWrite() {
		System.out.println();
		System.out.println("삭제할 게시글 번호를 입력하세요.");
		System.out.print("번호 >> ");
		int no = scan.nextInt();
		
		try {
			conn = JDBCUtil.getcConnection();
			
			String sql = "delete from jdbc_board where board_no = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println(no + "게시글 삭제 성공!");
			}else {
				System.out.println(no + "게시글 삭제 실패!!!");				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
		
	}

	private void updateWrite() {
		
		boolean chk = false;
		int no;
		do {
		System.out.println();
		System.out.println("수정할 글 번호를 입력하세요.");
		System.out.print("번호 >> ");
		no = scan.nextInt();
		
		chk = checkWrite(no);
		if(chk == false) {
			System.out.println(no + "번 글은 존재하지 않습니다.");
			System.out.println("다시 입력해 주세요.");
		}
		
		
	} while(chk == false);
		
		scan.nextLine();	// 입력버퍼 비우기
		System.out.print("내용 >> ");
		String content = scan.next();
		
		try {
			conn = JDBCUtil.getcConnection();
			
			String sql = "UPDATE jdbc_board "
					   + " SET board_content =  ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, content);

			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println(no + "번 게시글 수정 성공!");
			}else {
				System.out.println(no + "번 게시글 수정 실패!!!");				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
		
	}

	private void insertWrite() {
		
		System.out.println();
		System.out.println("게시글을 작성하세요.");
		System.out.print("제목 >> ");
		String title = scan.next();
		
		System.out.print("작성자 >> ");
		String writer = scan.next();
		scan.nextLine();
		System.out.print("내용 >> ");
		String content = scan.nextLine();

		try {
			conn = JDBCUtil.getcConnection();
			
			String sql = "insert INTO  jdbc_board(board_no, board_date, board_title, board_writer, board_content )" 
					   + "VALUES ( board_seq.nextVal, sysdate, ?, ?, ? )";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, content);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0 ) {
				System.out.println(title + "게시글 등록 성공!");
			}else {
				System.out.println(title + "게시글 등록 실패!!!");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			// 자원 반납...
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
	}
	
	private boolean checkWrite(int no) {
		
		boolean chk = false;
		
		try {
			conn = JDBCUtil.getcConnection();
			
			String sql = " select count(*) as cnt from jdbc_board "  
					   + " where board_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			int cnt = 0;
			
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
			if(cnt > 0) {
				chk = true;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
		return chk;
	}
	public static void main(String[] args) {
		Board board = new Board();
		board.start();
	}
	
}
