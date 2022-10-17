package border.dao;

import java.util.List;

import border.vo.BorderVO;

public interface BorderDAO {

	public boolean checkBorder(String borTit);

	public int insertBorder(BorderVO mv);

	public List<BorderVO> getAllBoderList();

	public int deleteBorder(String borNo);

	public int modifyBorder(BorderVO mv);

	public List<BorderVO> searchBorList(BorderVO mv);

	
}
