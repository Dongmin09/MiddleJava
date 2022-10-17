package border.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import border.vo.BorderVO;
import kr.or.ddit.util.JDBCUtill3;

public class BorderDAOImplForJDBC implements BorderDAO {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public boolean checkBorder(String borNo) {
		boolean chk = false;

		try {
			conn = JDBCUtill3.getConnection();

			String sql = "select count(*) as cnt from jdbc_board " + " where board_no = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, borNo);

			rs = pstmt.executeQuery();

			int cnt = 0;
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}
			if (cnt > 0) {
				chk = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtill3.close(conn, stmt, pstmt, rs);
		}
		return chk;
	}

	@Override
	public int insertBorder(BorderVO mv) {
		int cnt = 0;

		try {
			conn = JDBCUtill3.getConnection();

			String sql = "INSERT INTO jdbc_board ( board_no, board_title , board_writer , board_date , board_content )"
					+ "VALUES(BOARD_SEQ.nextVal, ?, ?, sysdate, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getBorTit());
			pstmt.setString(2, mv.getBorWrit());
			pstmt.setString(3, mv.getBorCon());

			cnt = pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("새 글 등록 과정중 예외발생!", ex);
		} finally {
			JDBCUtill3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public List<BorderVO> getAllBoderList() {
		List<BorderVO> boardList = new ArrayList<BorderVO>();

		try {
			conn = JDBCUtill3.getConnection();

			String sql = "select * from jdbc_board";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				BorderVO bv = new BorderVO();
				bv.setBorNo(rs.getString("board_no"));
				bv.setBorTit(rs.getString("board_title"));
				bv.setBorWrit(rs.getString("board_writer"));
				bv.setRegDate(rs.getString("board_date"));
				bv.setBorCon(rs.getString("board_content"));

				boardList.add(bv);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("전체 게시글 중 예외발생!", ex);
		} finally {
			JDBCUtill3.close(conn, stmt, pstmt, rs);
		}
		return boardList;
	}

	@Override
	public int deleteBorder(String borNo) {
		int cnt = 0;
		try {
			conn = JDBCUtill3.getConnection();

			String sql = "delete from jdbc_board where board_no =? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, borNo);

			cnt = pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("게시글 삭제 과정중 예외발생!", ex);
		} finally {
			JDBCUtill3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public int modifyBorder(BorderVO mv) {
		int cnt = 0;

		try {
			conn = JDBCUtill3.getConnection();

			String sql = " UPDATE jdbc_board\n" + "    SET\n" + "         board_title = ? \n"
					+ "        ,board_writer = ? \n" + "        ,board_content = ? \n" + "	 WHERE \n"
					+ "    board_no =?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getBorWrit());
			pstmt.setString(2, mv.getBorCon());
			pstmt.setString(3, mv.getBorNo());

			cnt = pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("게시글 수정 과정중 예외발생!", ex);
		} finally {
			JDBCUtill3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public List<BorderVO> searchBorList(BorderVO mv) {
		List<BorderVO> boardList = new ArrayList<BorderVO>();
		try {
			conn = JDBCUtill3.getConnection();

			String sql = "select * from jdbc_board where 1=1 "; // 동적쿼리(사용자가 조회하는것에 따라 쿼리문이 달라짐)

			if (mv.getBorNo() != null && !mv.getBorNo().equals("")) {
				sql += " and board_no = ? ";
			}
			if (mv.getBorTit() != null && !mv.getBorTit().equals("")) {
				sql += " and board_title = ? ";
			}
			if (mv.getBorWrit() != null && !mv.getBorWrit().equals("")) {
				sql += " and board_writer = ? ";
			}
			if (mv.getRegDate() != null && !mv.getRegDate().equals("")) {
				sql += " and board_date = ? ";
			}
			if (mv.getBorCon() != null && !mv.getBorCon().equals("")) {
				sql += " and board_content like '%' || ?  || '%' ";
			}

			pstmt = conn.prepareStatement(sql);

			int index = 1;

			if (mv.getBorNo() != null && !mv.getBorNo().equals("")) {
				pstmt.setString(index++, mv.getBorNo());
			}
			if (mv.getBorTit() != null && !mv.getBorTit().equals("")) {
				pstmt.setString(index++, mv.getBorTit());
			}
			if (mv.getBorWrit() != null && !mv.getBorWrit().equals("")) {
				pstmt.setString(index++, mv.getBorWrit());
			}
			if (mv.getBorCon() != null && !mv.getBorCon().equals("")) {
				pstmt.setString(index++, mv.getBorCon());
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BorderVO mv1 = new BorderVO();
				mv1.setBorNo(rs.getString("board_no"));
				mv1.setBorTit(rs.getString("board_title"));
				mv1.setBorWrit(rs.getString("board_writer"));
				mv1.setBorCon(rs.getString("board_content"));
				mv1.setRegDate(rs.getString("board_date"));

				boardList.add(mv1);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtill3.close(conn, stmt, pstmt, rs);
		}
		return boardList;
	}
}
