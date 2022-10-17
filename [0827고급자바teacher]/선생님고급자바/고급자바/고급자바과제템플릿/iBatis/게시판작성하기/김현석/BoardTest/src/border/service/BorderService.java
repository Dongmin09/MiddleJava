package border.service;

import java.util.List;

import border.vo.BorderVO;

public interface BorderService {


	public boolean checkBorder(String borTit);

	public int registerBorder(BorderVO mv);

	public List<BorderVO> getAllBorderList();

	public int removeBoard(String borNo);

	public int modifyBorder(BorderVO mv);

	public List<BorderVO> searchBorderList(BorderVO mv);


}
