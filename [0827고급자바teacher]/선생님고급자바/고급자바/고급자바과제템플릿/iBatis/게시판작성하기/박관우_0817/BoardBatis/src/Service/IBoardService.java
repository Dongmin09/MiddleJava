package Service;

import java.util.*;

import VO.BoardVO;

public interface IBoardService {
	public int registerBoard(BoardVO vo);

	public int modifyBoard(BoardVO vo);

	public int removeBoard(int bdNo);

	public List<BoardVO> bList();

	public List<BoardVO> searchBoard(String search);
}
