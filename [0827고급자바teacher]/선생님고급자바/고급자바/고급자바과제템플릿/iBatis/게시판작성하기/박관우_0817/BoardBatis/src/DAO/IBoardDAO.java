package DAO;

import java.util.*;

import VO.BoardVO;

public interface IBoardDAO {
	public int insertBoard(BoardVO vo);

	public int updateBoard(BoardVO vo);

	public int deleteBoard(int bdNo);

	public List<BoardVO> boardList();

	public List<BoardVO> searchBoardList(String search);
}
