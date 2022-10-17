package work;

import java.util.*;

public interface IBoardService {
	public int registerBoard(BoardVO vo);

	public int modifyBoard(BoardVO vo);

	public int removeBoard(int bdNo);

	public List<BoardVO> bList();

	public List<BoardVO> searchBoard(String search);
}
