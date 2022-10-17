package homework;

import java.sql.*;
import java.util.*;

import kr.or.ddit.util.*;

public class BoardDAO implements InterBoardDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/**
	 * 새글작성
	 */
	@Override
	public int insertBoard(BoardVO vo) {
		int row = 0;
		try {
			conn = JDBCUtil3.getConnection();
			String sql = "INSERT INTO JDBC_BOARD(BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE, BOARD_CONTENT) VALUES(BOARD_SEQ.NEXTVAL, ?, ?, sysdate, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBdTitle());
			pstmt.setString(2, vo.getBdWriter());
			pstmt.setString(3, vo.getBdContent());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("게시글 등록중 예외발생!", e);
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return row;
	}

	@Override
	public int updateBoard(BoardVO vo) {
		int row = 0;
		try {
			conn = JDBCUtil3.getConnection();
			String sql = "UPDATE JDBC_BOARD SET BOARD_TITLE = ?, BOARD_CONTENT = ? WHERE BOARD_NO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBdTitle());
			pstmt.setString(2, vo.getBdContent());
			pstmt.setInt(3, vo.getBdNo());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("게시글 수정중 예외발생!", e);
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return row;
	}

	@Override
	public int deleteBoard(int bdNo) {
		int row = 0;
		try {
			conn = JDBCUtil3.getConnection();
			String sql = "DELETE FROM JDBC_BOARD WHERE BOARD_NO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bdNo);
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("게시글 삭제중 예외발생!", e);
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return row;
	}

	@Override
	public List<BoardVO> boardList() {
		List<BoardVO> mList = new ArrayList<>();
		try {
			conn = JDBCUtil3.getConnection();
			String sql = "SELECT * FROM JDBC_BOARD ORDER BY 1";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBdNo(rs.getInt("BOARD_NO"));
				vo.setBdTitle(rs.getString("BOARD_TITLE"));
				vo.setBdWriter(rs.getString("BOARD_WRITER"));
				vo.setBdDate(rs.getDate("BOARD_DATE"));
				vo.setBdContent(rs.getString("BOARD_CONTENT"));
				mList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("게시글 조회중 예외발생!", e);
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		
		return mList;
	}

	@Override
	public List<BoardVO> searchBoardList(String search) {
		List<BoardVO> mList = new ArrayList<>();
		try {
			conn = JDBCUtil3.getConnection();
			String sql = "SELECT * FROM JDBC_BOARD WHERE BOARD_TITLE LIKE '%' || '" + search + "' || '%'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBdNo(rs.getInt("BOARD_NO"));
				vo.setBdTitle(rs.getString("BOARD_TITLE"));
				vo.setBdWriter(rs.getString("BOARD_WRITER"));
				vo.setBdDate(rs.getDate("BOARD_DATE"));
				vo.setBdContent(rs.getString("BOARD_CONTENT"));
				mList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("게시글 검색중 예외발생!", e);
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return mList;
	}
}
