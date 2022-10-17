package kr.or.ddit.noticeBoard.service;

import java.util.List;

import kr.or.ddit.noticeBoard.vo.NoticeBoardVO;

public interface INoticeBoardService {
	
	// VO자료를 DB에 insert 하는 메소드
	// 작업 성공: 1, 작업 실패: 0
	public int registerNoticeBoard(NoticeBoardVO mv);
	
	// 주어진 글이 존재하는지 확인 하는 메서드
	// 게시글 존재 true, 없으면 false
	public boolean checkNoticeBoard(String nbTt);
	
	// VO자료를 DB에 update 하는 메소드
	// 작업 성공: 1, 작업 실패: 0
	public int modifyNoticeBoard(NoticeBoardVO mv);
	
	// 게시글을 메개변수로 가져와 삭제하는 메서드
	// 작업 성공: 1, 작업 실패: 0
	public int removeNoticeBoard(int noticeNo);
	
	// 테이블의 모든정보를 가져와 List에 담아서 반환하는 메서드
	public List<NoticeBoardVO> getAllNoticeBoardList();
	
	// 검색 메서드
	public List<NoticeBoardVO> searchNoticeBoardList(NoticeBoardVO mv);

}
