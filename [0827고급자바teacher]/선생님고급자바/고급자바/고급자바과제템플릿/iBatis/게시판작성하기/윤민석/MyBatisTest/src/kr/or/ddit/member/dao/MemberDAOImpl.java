package kr.or.ddit.member.dao;

import java.util.*;

import org.apache.ibatis.session.*;

import kr.or.ddit.member.vo.*;
import kr.or.ddit.util.*;

public class MemberDAOImpl implements IMemberDAO {
	private static IMemberDAO mDao;
	private SqlSession sqlSession;
	
	public MemberDAOImpl() {
		sqlSession = MyBatisUtil.getInstance(true);
	}
	
	public static IMemberDAO getInstance() {
		if(mDao == null) {
			mDao = new MemberDAOImpl();
		}
		return mDao;
	}
	
	@Override
	public int insertMember(MemberVO vo) {
		int row = sqlSession.insert("member.insertMember", vo);
		return row;
	}

	@Override
	public boolean checkMember(String memId) {
		boolean chk = false;
		int row = sqlSession.selectOne("member.checkMember", memId);
		if(row > 0) {
			chk = true;
		}
		return chk;
	}

	@Override
	public int updateMember(MemberVO vo) {
		int row = sqlSession.update("member.updateMember", vo);
		return row;
	}

	@Override
	public int deleteMember(String memId) {
		int row = sqlSession.delete("member.deleteMember", memId);
		return row;
	}

	@Override
	public List<MemberVO> selectMember() {
		List<MemberVO> mList = sqlSession.selectList("member.selectMember");
		return mList;
	}

	@Override
	public List<MemberVO> searchMember(MemberVO vo) {
		List<MemberVO> mList = sqlSession.selectOne("member.searchMember", vo);
		return mList;
	}

}
