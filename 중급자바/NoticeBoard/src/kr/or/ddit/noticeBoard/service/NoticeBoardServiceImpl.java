package kr.or.ddit.noticeBoard.service;

import java.util.List;

import kr.or.ddit.noticeBoard.dao.INoticeBoardDAO;
import kr.or.ddit.noticeBoard.dao.NoticeBoardDAOImpl;
import kr.or.ddit.noticeBoard.vo.NoticeBoardVO;

public class NoticeBoardServiceImpl implements INoticeBoardService{

	private NoticeBoardDAOImpl nbDao;
	
	public NoticeBoardServiceImpl() {
		
		nbDao = new NoticeBoardDAOImpl();
	}
	
	
	@Override
	public int registerNoticeBoard(NoticeBoardVO mv) {
		
		int cnt = nbDao.insertNoticeBoard(mv);
		
		return cnt;
	}

	@Override
	public boolean checkNoticeBoard(String nbTt) {
		
		boolean chk = nbDao.checkNoticeBoard(nbTt);
		return chk;
	}

	@Override
	public int modifyNoticeBoard(NoticeBoardVO mv) {
		
		int cnt = nbDao.updateNoticeBoard(mv);
		return cnt;
	}

	@Override
	public int removeNoticeBoard(int noticeNo) {
		
		int cnt = nbDao.deleteNoticeBoard(noticeNo);
		return cnt;
	}

	@Override
	public List<NoticeBoardVO> getAllNoticeBoardList() {
		
		List<NoticeBoardVO> nbList = nbDao.getAllNoticeBoardList();
		return nbList;
	}

	@Override
	public List<NoticeBoardVO> searchNoticeBoardList(NoticeBoardVO mv) {
		List<NoticeBoardVO> nbList = nbDao.searchMemberList(mv);
		return nbList;
	}

}
