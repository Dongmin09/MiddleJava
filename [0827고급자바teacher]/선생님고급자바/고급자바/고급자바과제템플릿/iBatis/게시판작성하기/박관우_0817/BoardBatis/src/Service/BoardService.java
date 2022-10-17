package Service;

import java.util.*;

import DAO.BoardDAO;
import DAO.IBoardDAO;
import VO.BoardVO;

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
		List<BoardVO> bList = bDao.boardList();
		return bList;
	}

	@Override
	public List<BoardVO> searchBoard(String search) {
		List<BoardVO> bList = bDao.searchBoardList(search);
		return bList;
	}
}
