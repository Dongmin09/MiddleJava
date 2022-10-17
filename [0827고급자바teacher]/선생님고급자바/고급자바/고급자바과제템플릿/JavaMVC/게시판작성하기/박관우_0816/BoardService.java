package work;

import java.util.*;

public class BoardService implements IBoardService {
	private IBoardDAO bDao;

	public BoardService() {
		bDao = new BoardDAO();
	}

	@Override
	public int registerBoard(BoardVO vo) {
		int row = bDao.insertBoard(vo);
		return row;
	}

	@Override
	public int modifyBoard(BoardVO vo) {
		int row = bDao.updateBoard(vo);
		return row;
	}

	@Override
	public int removeBoard(int bdNo) {
		int row = bDao.deleteBoard(bdNo);
		return row;
	}

	@Override
	public List<BoardVO> bList() {
		List<BoardVO> mList = bDao.boardList();
		return mList;
	}

	@Override
	public List<BoardVO> searchBoard(String search) {
		List<BoardVO> mList = bDao.searchBoardList(search);
		return mList;
	}
}
