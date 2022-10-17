package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardDAO {

	public int insertBoard(BoardVO mv);

	public boolean checkBoard(String memId);

	public int updateBoard(BoardVO mv);

	public int deleteBoard(String memId);

	public List<BoardVO> getAllBoardList();

	public List<BoardVO> searchBoardList(BoardVO bv);
}
