package kr.or.ddit.noticeBoard.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import kr.or.ddit.noticeBoard.util.JDBCUtil;
import kr.or.ddit.noticeBoard.vo.NoticeBoardVO;




public class NoticeBoardDAOImpl {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public int insertNoticeBoard(NoticeBoardVO mv) {
		
		int cnt = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "INSERT INTO jdbc_board (board_no, board_title, board_writer, board_date, board_content)"
					+ "VALUES (board_seq.nextVal, ?, ?, sysdate, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getNbTt());
			pstmt.setString(2, mv.getNbWt());
			pstmt.setString(3, mv.getNbCt());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 반납
			JDBCUtil.close(conn, stmt, pstmt, rs);
			
		}	
		return cnt;		
	}
	
	

	public boolean checkNoticeBoard(String nbTt) {
		
		boolean chk = false;
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = " select count(*) as cnt from jdbc_board" 
					+ " where board_title = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nbTt);
			
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
			throw new RuntimeException("게시글 확인 과정 중 예외발생!", e);
		} finally {
			JDBCUtil.close(conn, stmt,pstmt, rs);
		}
		return chk;	
	}
	
public int updateNoticeBoard(NoticeBoardVO mv) {
		
		int cnt =0;
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = " update jdbc_board"
				    	+ " set board_writer = ? "
				    	+ " ,board_content = ? "
				    	+ " where board_title = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getNbWt());
			pstmt.setString(2, mv.getNbCt());
			pstmt.setString(3, mv.getNbTt());

			
			cnt = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("회원수정 과정 중 예외발생!", e);
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}

		return cnt;
	}
	
	public int deleteNoticeBoard(int noticeNo) {
		
		int cnt =0;
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = "delete from jdbc_board where board_no =? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("회원삭제 과정 중 예외발생!", e);
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}
	
	public List<NoticeBoardVO> getAllNoticeBoardList() {
		
		List<NoticeBoardVO> nbList = new ArrayList<NoticeBoardVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = "select *from jdbc_board ";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				NoticeBoardVO mv = new NoticeBoardVO();
				mv.setNbNum(rs.getInt("board_no"));
				mv.setNbTt(rs.getString("board_title"));
				mv.setNbWt(rs.getString("board_writer"));
				mv.setNbDate(rs.getDate("board_date"));
				mv.setNbCt(rs.getString("board_content"));
				nbList.add(mv);
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("전체회원 조회 중 예외발생!", e);
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);	
		}	
		
		return  nbList;
	}

	
public List<NoticeBoardVO> searchMemberList(NoticeBoardVO mv) {
		
		List<NoticeBoardVO> nbList = new ArrayList<NoticeBoardVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = "select *from jdbc_board where 1=1";
			
			if(mv.getNbNum() !=0) {
				sql += " and board_no = ? ";
			}
				
			if(mv.getNbTt() != null && !mv.getNbTt().equals("")) {
				sql += " and board_title = ? ";
			}
			if(mv.getNbWt() != null && !mv.getNbWt().equals("")) {
				sql += " and  board_writer = ? ";
			}
			
			if(mv.getNbDate() != null && !mv.getNbDate().equals("")) {
				sql += " and board_date = ? ";
			}
				
			if(mv.getNbCt() != null && !mv.getNbCt().equals("")) {
				sql += " and board_content like '%' || ? || '%' ";
			}
			
			// 물음표부분을 처리하기위한 쿼리코드
			
			pstmt = conn.prepareStatement(sql);
			
			int index = 1;
			
			if(mv.getNbNum() !=0) {
				pstmt.setInt(index++, mv.getNbNum());
			}
			
			if(mv.getNbTt() != null && !mv.getNbTt().equals("")) {
				pstmt.setString(index++, mv.getNbTt());
			}
			if(mv.getNbWt() != null && !mv.getNbWt().equals("")) {
				pstmt.setString(index++, mv.getNbWt());
			}
			
			if(mv.getNbDate() != null && !mv.getNbDate().equals("")) {
				pstmt.setDate(index++, (Date) mv.getNbDate());
			}
			
			if(mv.getNbCt() != null && !mv.getNbCt().equals("")) {
				pstmt.setString(index++, mv.getNbCt());
			}
			
			rs =pstmt.executeQuery();
			
			while(rs.next()) {
				
				NoticeBoardVO mv2 = new NoticeBoardVO();
				mv2.setNbNum(rs.getInt("board_no"));
				mv2.setNbTt(rs.getString("board_title"));
				mv2.setNbWt(rs.getString("board_writer"));
				mv2.setNbDate(rs.getDate("board_date"));
				mv2.setNbCt(rs.getString("board_content"));

				
				nbList.add(mv2);
					
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
		return nbList;
	}
}
