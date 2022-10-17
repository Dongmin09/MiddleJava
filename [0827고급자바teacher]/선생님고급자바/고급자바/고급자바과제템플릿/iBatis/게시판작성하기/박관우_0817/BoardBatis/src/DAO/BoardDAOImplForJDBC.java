package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Util.BoardUtil;
import VO.BoardVO;

public class BoardDAOImplForJDBC implements IBoardDAO {

	private static IBoardDAO bdDao;

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private BoardDAOImplForJDBC() {

	}

	public static IBoardDAO getInstance() {
		if (bdDao == null) {
			bdDao = new BoardDAOImplForJDBC();
		}

		return bdDao;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		int row = 0;
		try {
			conn = BoardUtil.getConnection();
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
			BoardUtil.close(conn, stmt, pstmt, rs);
		}
		return row;
	}

	@Override
	public int updateBoard(BoardVO vo) {
		int row = 0;
		try {
			conn = BoardUtil.getConnection();
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
			BoardUtil.close(conn, stmt, pstmt, rs);
		}
		return row;
	}

	@Override
	public int deleteBoard(int bdNo) {
		int row = 0;
		try {
			conn = BoardUtil.getConnection();
			String sql = "DELETE FROM JDBC_BOARD WHERE BOARD_NO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bdNo);
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("게시글 삭제중 예외발생!", e);
		} finally {
			BoardUtil.close(conn, stmt, pstmt, rs);
		}
		return row;
	}

	@Override
	public List<BoardVO> boardList() {
		List<BoardVO> bList = new ArrayList<>();
		try {
			conn = BoardUtil.getConnection();
			String sql = "SELECT * FROM JDBC_BOARD ORDER BY 1";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBdNo(rs.getInt("BOARD_NO"));
				vo.setBdTitle(rs.getString("BOARD_TITLE"));
				vo.setBdWriter(rs.getString("BOARD_WRITER"));
				vo.setBdDate(rs.getDate("BOARD_DATE"));
				vo.setBdContent(rs.getString("BOARD_CONTENT"));
				bList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("게시글 조회중 예외발생!", e);
		} finally {
			BoardUtil.close(conn, stmt, pstmt, rs);
		}

		return bList;
	}

	@Override
	public List<BoardVO> searchBoardList(String search) {
		List<BoardVO> bList = new ArrayList<>();
		try {
			conn = BoardUtil.getConnection();
			String sql = "SELECT * FROM JDBC_BOARD WHERE BOARD_TITLE LIKE '%' || '" + search + "' || '%'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBdNo(rs.getInt("BOARD_NO"));
				vo.setBdTitle(rs.getString("BOARD_TITLE"));
				vo.setBdWriter(rs.getString("BOARD_WRITER"));
				vo.setBdDate(rs.getDate("BOARD_DATE"));
				vo.setBdContent(rs.getString("BOARD_CONTENT"));
				bList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("게시글 검색중 예외발생!", e);
		} finally {
			BoardUtil.close(conn, stmt, pstmt, rs);
		}
		return bList;
	}

}
