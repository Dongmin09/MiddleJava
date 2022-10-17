package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardService {

	public int registerBoard(BoardVO mv);

	public boolean checkBoard(String memId);

	public int modifyBoard(BoardVO mv);

	public int removeBoard(String boardNo);

	public List<BoardVO> getAllBoardList();

	public List<BoardVO> searchBoardList(BoardVO mv);
}
