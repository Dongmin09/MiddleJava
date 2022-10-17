package kr.or.ddit.member.service;

import java.util.*;

import kr.or.ddit.member.dao.*;
import kr.or.ddit.member.vo.*;
import sun.security.jca.*;

public class MemberServiceImpl implements IMemberService {
	private static IMemberService mService;
	private IMemberDAO mDao;
	
	private MemberServiceImpl() {
		mDao = MemberDAOImpl.getInstance();
	}
	public static IMemberService getInstance() {
		if(mService == null) {
			mService = new MemberServiceImpl();
		}
		return mService;
	}
	@Override
	public int registerMember(MemberVO vo) {
		int row = mDao.insertMember(vo);
		return row;
	}

	@Override
	public boolean checkMember(String memId) {
		boolean chk = mDao.checkMember(memId);
		return chk;
	}

	@Override
	public int modifyMember(MemberVO vo) {
		int row = mDao.updateMember(vo);
		return row;
	}

	@Override
	public int removeMember(String memId) {
		int row = mDao.deleteMember(memId);
		return row;
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		List<MemberVO> mList = mDao.selectMember();
		return mList;
	}

	@Override
	public List<MemberVO> searchMemberList(MemberVO vo) {
		List<MemberVO> mList = mDao.searchMember(vo);
		return mList;
	}
}
