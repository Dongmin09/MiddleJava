package homework.board.service;

import java.util.*;

import homework.board.vo.*;

public interface InterBoardService {
	public int registerBoard(BoardVO vo);
	
	public int modifyBoard(BoardVO vo);
	
	public int removeBoard(int bdNo);
	
	public List<BoardVO> bList();
	
	public List<BoardVO> searchBoard(String search);
}
