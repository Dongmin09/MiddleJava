package kr.or.ddit.member.dao;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.MyBatisUtil;


public class MemberDAOImpl implements IMemberDAO {
	
	// 싱글톤 DAO 객체 생성
	private static IMemberDAO memDao;

	private SqlSession sqlSession;
	
	public MemberDAOImpl() {
		
		sqlSession = MyBatisUtil.getInstance(true);
	}
	
	public static IMemberDAO getinstance() {
		if(memDao == null) {
			memDao = new MemberDAOImpl();
		}
		return memDao;
	}
	

	@Override
	public int insertMember(MemberVO mv) {
		
		int cnt = sqlSession.insert("member.insertMember", mv);
		
		return cnt;
	}

	@Override
	public boolean checkMember(String memId) {
		boolean chk = false;
		
		int cnt = sqlSession.selectOne("member.checkMember", memId);
		
		if(cnt>0) {
			chk = true;
		}
		return chk;
	}

	@Override
	public int updateMember(MemberVO mv) {
		int cnt = sqlSession.update("member.updateMember", mv);
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = sqlSession.delete("member.deleteMember", memId);
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		List<MemberVO> memList = sqlSession.selectList("member.memberAllList");
		return memList;
	}

	@Override
	public List<MemberVO> searchMemberList(MemberVO mv) {
		
		List<MemberVO> memList = sqlSession.selectList("member.searchMemberList", mv);
		return memList;
	}
	
	@Override
	public MemberVO getMember(String memId) {
		// TODO Auto-generated method stub
		MemberVO memVO = sqlSession.selectOne("member.getMember", memId);
		
		
		return memVO;
	}
	
}
