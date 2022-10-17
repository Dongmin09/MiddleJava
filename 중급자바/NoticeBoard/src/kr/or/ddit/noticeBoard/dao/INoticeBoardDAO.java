package kr.or.ddit.noticeBoard.dao;

import java.util.List;

import kr.or.ddit.noticeBoard.vo.NoticeBoardVO;

public interface INoticeBoardDAO {

	// insert할 자료가 저장된 NoticeBoardVO 객체
	public int insertNoticeBoard(NoticeBoardVO mv);
	
	// 동일한 제목이 있는지 여부를 알아내기 위한 메서드
	// 글이 있으면 true, 없으면 false
	public boolean checkNoticeBoard(String nbTt);
	
	// 업데이트 메서드 
	// 작업 성공 1, 작업실패 0
	public int updateNoticeBoard(NoticeBoardVO mv);
	
	
	// 작성글 삭제 메서드
	// 작업 성공 1, 작업 실패 0
	public int deleteNoticeBoard(String nbTt);
	
	// 테이블에 존재하는 모든 작성글을 가져와 리스트에 담아서 반환하는 메서드
	// VO 정보를 가지고 있는 객체
	public List<NoticeBoardVO> getAllNoticeBoardList();
	
	// 검색할 정보를 담은 객체.
	public List<NoticeBoardVO> searchNoticeBoardList(NoticeBoardVO mv);
}
