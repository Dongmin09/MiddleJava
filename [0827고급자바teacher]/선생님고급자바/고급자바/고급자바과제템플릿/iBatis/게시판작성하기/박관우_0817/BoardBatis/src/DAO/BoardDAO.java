package DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Util.MyBatisUtil;
import VO.BoardVO;

public class BoardDAO implements IBoardDAO {

	private static IBoardDAO bdDao;

	private SqlSession sqlSession;

	public BoardDAO() {
		sqlSession = MyBatisUtil.getInstance(true);
	}

	public static IBoardDAO getInstance() {
		if (bdDao == null) {
			bdDao = new BoardDAO();
		}

		return bdDao;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		int row = sqlSession.insert("board.insertBoard", vo);

		return row;
	}

	@Override
	public int updateBoard(BoardVO vo) {
		int row = sqlSession.update("board.updateBoard", vo);

		return row;
	}

	@Override
	public int deleteBoard(int bdNo) {
		int row = sqlSession.delete("board.deleteMember", bdNo);

		return row;
	}

	@Override
	public List<BoardVO> boardList() {
		List<BoardVO> bList = sqlSession.selectList("board.selectBoard");

		return bList;
	}

	@Override
	public List<BoardVO> searchBoardList(String search) {
		List<BoardVO> bList = sqlSession.selectList("board.searchBoard", search);

		return bList;
	}
}
