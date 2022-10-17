package kr.or.ddit.member.dao;

import java.sql.*;
import java.util.*;

import kr.or.ddit.member.vo.*;
import kr.or.ddit.util.*;

public class MemberDAOImplForJDBC implements IMemberDAO {
	private static IMemberDAO memDao;
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private MemberDAOImplForJDBC() {}
	
	public static IMemberDAO getInstance() {
		if(memDao == null) {
			memDao = new MemberDAOImplForJDBC();
		}
		return memDao;
	}
	@Override
	public int insertMember(MemberVO vo) {
		int row = 0;
		try {
			conn = JDBCUtil3.getConnection();
			String sql = "INSERT INTO MYMEMBER(MEM_ID, MEM_NAME, MEM_TEL, MEM_ADDR) VALUES(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMemId());
			pstmt.setString(2, vo.getMemName());
			pstmt.setString(3, vo.getMemTel());
			pstmt.setString(4, vo.getMemAddr());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("회원등록 과정중 예외발생!", e);
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return row;
	}

	@Override
	public boolean checkMember(String memId) {
		boolean chk = false;
		try {
			conn = JDBCUtil3.getConnection();
			String sql = "SELECT COUNT(*) FROM MYMEMBER WHERE MEM_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, memId);
			rs = pstmt.executeQuery();
			int row = 0;
			if(rs.next()) {
				row = rs.getInt(1);
			}
			if(row > 0) {
				chk = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("회원정보 확인중 예외발생!", e);
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return chk;
	}

	@Override
	public int updateMember(MemberVO vo) {
		int row = 0;
		try {
			conn = JDBCUtil3.getConnection();
			String sql = "UPDATE MYMEMBER SET MEM_NAME = ?, MEM_TEL = ?, MEM_ADDR = ? WHERE MEM_ID =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, vo.getMemName());
			pstmt.setNString(2, vo.getMemTel());
			pstmt.setNString(3, vo.getMemAddr());
			pstmt.setNString(4, vo.getMemId());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("회원수정 과정중 예외발생!", e);
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return row;
	}

	@Override
	public int deleteMember(String memId) {
		int row = 0;
		try {
			conn = JDBCUtil3.getConnection();
			String sql = "DELETE FROM MYMEMBER WHERE MEM_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("회원삭제 과정중 예외발생!", e);
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return row;
	}

	@Override
	public List<MemberVO> selectMember() {
		List<MemberVO> mList = new ArrayList<>();
		try {
			conn = JDBCUtil3.getConnection();
			String sql = "SELECT * FROM MYMEMBER ORDER BY 1";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setMemId(rs.getString("MEM_ID"));
				vo.setMemName(rs.getString("MEM_NAME"));
				vo.setMemTel(rs.getString("MEM_TEL"));
				vo.setMemAddr(rs.getString("MEM_ADDR"));
				mList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("전체회원 조회중 예외발생!", e);
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		
		return mList;
	}

	@Override
	public List<MemberVO> searchMember(MemberVO vo) {
		List<MemberVO> mList = new ArrayList<>();
		try {
			conn = JDBCUtil3.getConnection();
			String sql = " SELECT * "
					   + " FROM   MYMEMBER "
					   + " WHERE  1 = 1 ";
			
			if(vo.getMemId() != null && !vo.getMemId().equals("")) {
				sql += " AND MEM_ID = ? ";
			}
			if(vo.getMemName() != null && !vo.getMemName().equals("")) {
				sql += " AND MEM_NAME = ? ";
			}
			if(vo.getMemTel() != null && !vo.getMemTel().equals("")) {
				sql += " AND MEM_TEL = ? ";
			}
			if(vo.getMemAddr() != null && !vo.getMemAddr().equals("")) {
				sql += " AND MEM_ADDR LIKE '%' || ? || '%' ";
			}
			pstmt = conn.prepareStatement(sql);
			int index = 1;
			
			if(vo.getMemId() != null && !vo.getMemId().equals("")) {
				pstmt.setNString(index++, vo.getMemId());
			}
			if(vo.getMemName() != null && !vo.getMemName().equals("")) {
				pstmt.setNString(index++, vo.getMemName());
				
			}
			if(vo.getMemTel() != null && !vo.getMemTel().equals("")) {
				pstmt.setNString(index++, vo.getMemTel());
				
			}
			if(vo.getMemAddr() != null && !vo.getMemAddr().equals("")) {
				pstmt.setNString(index++, vo.getMemAddr());
				
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO vo2 = new MemberVO();
				vo2.setMemId(rs.getNString("MEM_ID"));
				vo2.setMemName(rs.getNString("MEM_NAME"));
				vo2.setMemTel(rs.getNString("MEM_TEL"));
				vo2.setMemAddr(rs.getNString("MEM_ADDR"));
				mList.add(vo2);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("회원 검색중 예외발생!", e);
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return mList;
	}
}
