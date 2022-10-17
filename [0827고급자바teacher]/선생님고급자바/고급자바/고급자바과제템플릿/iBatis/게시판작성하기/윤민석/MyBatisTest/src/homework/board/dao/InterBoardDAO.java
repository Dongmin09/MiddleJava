package homework.board.dao;

import java.util.*;

import homework.board.vo.*;

public interface InterBoardDAO {
	public int insertBoard(BoardVO vo);
	
	public int updateBoard(BoardVO vo);
	
	public int deleteBoard(int bdNo);
	
	public List<BoardVO> boardList();
	
	public List<BoardVO> searchBoardList(String search);
}
