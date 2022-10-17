package homework.board.dao;

import java.util.*;

import org.apache.ibatis.session.*;

import homework.board.vo.*;
import kr.or.ddit.util.*;

public class BoardDAO implements InterBoardDAO {
	private static InterBoardDAO bDao;
	private SqlSession sqlSession;
	
	public BoardDAO() {
		sqlSession = MyBatisUtil.getInstance(true);
	}
	
	public static InterBoardDAO getInstance() {
		if(bDao == null) {
			bDao = new BoardDAO();
		}
		return bDao;
	}
	/**
	 * 글 작성
	 */
	@Override
	public int insertBoard(BoardVO vo) {
		int row = sqlSession.insert("board.insertBoard", vo);
		return row;
	}
	/**
	 * 글 수정
	 */
	@Override
	public int updateBoard(BoardVO vo) {
		int row = sqlSession.update("board.updateBoard", vo);
		return row;
	}
	/**
	 * 글 삭제
	 */
	@Override
	public int deleteBoard(int bdNo) {
		int row = sqlSession.delete("board.deleteBoard", bdNo);
		return row;
	}
	/**
	 * 글 출력
	 */
	@Override
	public List<BoardVO> boardList() {
		List<BoardVO> bList = sqlSession.selectList("board.selectBoard");
		return bList;
	}
	/**
	 * 글 검색
	 */
	@Override
	public List<BoardVO> searchBoardList(String search) {
		List<BoardVO> bList = sqlSession.selectList("board.searchBoard", search);
		return bList;
	}
}
