package kr.or.ddit.basic;

import java.io.*;
import java.nio.charset.*;
import java.util.*;

import org.apache.ibatis.io.*;
import org.apache.ibatis.session.*;

import kr.or.ddit.member.vo.*;

public class MybatisTest {
	public static void main(String[] args) {
		// myBatis를 이용하여 DB자료를 처리하는 작업 순서
		// 1. myBatis의 환경 설정파일을 읽어와 실행시킨다.
		
		SqlSession sqlSession = null;
		try {
			// 1-1. xml설정문서 읽어오기
			// 설정파일의 인코딩정보 설정(한글처리를 위해서...)
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			Reader rd = 
					Resources.getResourceAsReader("config/mybatis-config.xml");
			// 1-2. 위에서 읽어온 Reader객체를 이용하여 실제 작업을 진행할 객체 생성하기
			SqlSessionFactory sessionFactory = 
					new SqlSessionFactoryBuilder().build(rd);
			// 오토커밋 여부
			sqlSession = sessionFactory.openSession(true);
			
			rd.close(); // 자원반납
		} catch (Exception e) {
			e.printStackTrace();
		}
		int row = 0;
		// 2. 실행할 SQL문에 맞는 쿼리문을 호출해서 원하는 작업을 수행한다.
		/*
		// 2-1. Insert 작업 연습
		System.out.println("insert 작업 시작...");
		
		// 1) 저장할 데이터를 VO에 담는다.
		MemberVO vo = new MemberVO();
		vo.setMemId("d001");
		vo.setMemName("김효정");
		vo.setMemTel("1111-1111");
		vo.setMemAddr("대전시 서구 탄방동");
		
		// 2) SqlSession 객체변수를 이용하여 해당 쿼리문을 실행한다.
		// 형식) sqlSession.insert("namespace값.id값", 파리미터객체);
		//      반환값 : 성공한 레코드 수
		row = sqlSession.insert("memberTest.insertMember", vo);
		if(row > 0) {
			System.out.println("insert 성공!");
		} else {
			System.out.println("insert 실패!");
		}
		*/
		/*
		// 2-2. update 연습
		System.out.println("update작업 시작...");
		
		MemberVO vo = new MemberVO();
		vo.setMemId("d001");
		vo.setMemName("윤다영");
		vo.setMemTel("6666-6666");
		vo.setMemAddr("부산시 해운대구");
		
		// update()메서드의 반환값도 성공한 레코드 수이다.
		row = sqlSession.update("memberTest.updateMember", vo2);
		if(row > 0) {
			System.out.println("update 성공!");
		} else {
			System.out.println("update 실패!");
		}
		*/
		/*
		// 2-3. delete 연습
		System.out.println("delete 작업 시작...");
		
		// delete메서드의 반환값 : 성공한 레코드 수
		
		row = sqlSession.delete("memberTest.deleteMember", "d001");
		if(row > 0) {
			System.out.println("delete 성공!");
		} else {
			System.out.println("delete 실패!");
		}
		*/
		
		// 2-4. select 연습
		/*
		// 1) 응답결과가 여러개일 경우...
		System.out.println("select 연습 시작(결과가 여러개일 경우...)");
		
		// 응답 결과가 여러개일 경우에는 selectList()메서드를 사용한다.
		// 이 메서드는 여러개의 레코드를 VO에 담은 후 이 VO 데이터를 List에
		// 추가해 주는 작업을 자동으로 수행한다.
		List<MemberVO> mList = sqlSession.selectList("memberTest.selectMember");
		System.out.println("===================================");
		for (MemberVO vo : mList) {
			System.out.println("ID : " + vo.getMemId());
			System.out.println("이름 : " + vo.getMemName());
			System.out.println("전화 : " + vo.getMemTel());
			System.out.println("주소 : " + vo.getMemAddr());
			System.out.println("-------------------------------");
		}
		System.out.println("===================================");
		*/
		// 2) 응답결과가 1개일 경우...
		System.out.println("select 연습 시작(결과가 1개인 경우...)");
		
		// 응답결과가 1개가 확실할 경우에는 selectOne()메서드를 사용한다.
		MemberVO vo = 
				(MemberVO) sqlSession.selectOne("memberTest.searchMember", "d001");
		System.out.println("===================================");
		System.out.println("ID : " + vo.getMemId());
		System.out.println("이름 : " + vo.getMemName());
		System.out.println("전화 : " + vo.getMemTel());
		System.out.println("주소 : " + vo.getMemAddr());
		System.out.println("===================================");
	}
}
