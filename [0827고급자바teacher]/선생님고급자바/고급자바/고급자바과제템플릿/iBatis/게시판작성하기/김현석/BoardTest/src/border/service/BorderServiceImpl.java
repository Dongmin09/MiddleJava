package border.service;

import java.util.List;

import border.dao.BorderDAO;
import border.dao.BorderDAOImpl;
import border.dao.BorderDAOImplForJDBC;
import border.vo.BorderVO;

public class BorderServiceImpl implements BorderService{


	private BorderDAO borDao;
	
	public BorderServiceImpl(){
		borDao = new BorderDAOImplForJDBC();
	}
	@Override
	public boolean checkBorder(String borNo) {
		boolean chk = borDao.checkBorder(borNo);
		return chk;
	}

	@Override
	public int registerBorder(BorderVO mv) {
		int cnt = borDao.insertBorder(mv);
		
		
		return cnt;
	}
	@Override
	public List<BorderVO> getAllBorderList() {
		List<BorderVO> memList = borDao.getAllBoderList();
		
		return memList;
	}
	@Override
	public int removeBoard(String borNo) {
		int cnt = borDao.deleteBorder(borNo);
		return cnt;
	}
	@Override
	public int modifyBorder(BorderVO mv) {
		int cnt = borDao.modifyBorder(mv);
		return cnt;
	}
	@Override
	public List<BorderVO> searchBorderList(BorderVO mv) {
		List<BorderVO> borList = borDao.searchBorList(mv);
		return borList;
	}

	
	
	
}
