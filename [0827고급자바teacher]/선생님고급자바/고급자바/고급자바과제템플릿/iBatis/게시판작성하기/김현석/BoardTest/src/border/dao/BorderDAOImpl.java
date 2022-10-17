package border.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import border.vo.BorderVO;
import kr.or.ddit.util.JDBCUtill3;
import kr.or.ddit.util.MyBatisUtil;

public class BorderDAOImpl implements BorderDAO {

	private static BorderDAO borderDao;
	private SqlSession sqlSession;

	private BorderDAOImpl() {
		sqlSession = MyBatisUtil.getInstance(true);
	}

	public static BorderDAO getInstance() {
		if (borderDao == null) {
			borderDao = new BorderDAOImpl();
		}
		return borderDao;
	}

	@Override
	public boolean checkBorder(String borNo) {
		boolean chk = false;

		int cnt = sqlSession.selectOne("board.checkBoard", borNo);

		if (cnt > 0) {
			chk = true;
		}
		return chk;
	}

	@Override
	public int insertBorder(BorderVO mv) {
		int cnt = sqlSession.insert("board.insertBoard", mv);

		return cnt;
	}

	@Override
	public List<BorderVO> getAllBoderList() {
		List<BorderVO> boardList = sqlSession.selectList("board.boardAllList");
		return boardList;
	}

	@Override
	public int deleteBorder(String borNo) {
		int cnt = sqlSession.delete("board.deleteBoard", borNo);
		return cnt;
	}

	@Override
	public int modifyBorder(BorderVO mv) {
		int cnt = sqlSession.update("board.updateBoard", mv);
		return cnt;
	}

	@Override
	public List<BorderVO> searchBorList(BorderVO mv) {
		List<BorderVO> boardList = sqlSession.selectList("board.searchBoardList", mv);
		return boardList;

	}
}
