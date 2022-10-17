package homework.board.service;

import java.util.*;

import homework.board.dao.*;
import homework.board.vo.*;

public class BoardService implements InterBoardService {
	private InterBoardDAO bDao;
	
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
