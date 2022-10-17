package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.member.vo.MemberVO;

public class MybatisTest {
	public static void main(String[] args) {
		// myBatis를 이용하여 DB자료를 처리하는 작업 순서
		// 1. myBatis의 환경 설정파일을 읽어와 실행시킨다.
		
		SqlSession sqlSession = null;
		
		try {
			
			// 1-1. xml설정문서  읽어오기
			// 설정파일의 인코딩정보 설정(한글처리를 위해서...)
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			Reader rd = 
				Resources.getResourceAsReader("config/mybatis-config.xml");
			
			// 1-2. 위에서 읽어온 Reader객체를 이용하여 실제 작업을 진행할 객체 생성하기
			SqlSessionFactory sessionFactory = 
					new SqlSessionFactoryBuilder().build(rd);
			
			// 오토커밋 여부설정
			sqlSession = sessionFactory.openSession(true); 
			
			rd.close(); // 자원반납
			
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		
		// 2. 실행할 SQL문에 맞는 쿼리문을 호출해서 원하는 작업을 수행한다.
		/*
		// 2-1. Insert 작업 연습
		System.out.println("insert 작업 시작...");
		
		// 1) 저장할 데이터를 VO에  담는다.
		MemberVO mv = new MemberVO();
		mv.setMemId("d001");
		mv.setMemName("김효정");
		mv.setMemTel("1111-1111");
		mv.setMemAddr("대전시 서구 탄방동");
		
		// 2) SqlSession객체변수를 이용하여 해당 쿼리문을 실행한다.
		//   형식) sqlSession.insert("namespace값.id값", 파라미터객체);
		//      반환값 : 성공한 레코드 수
		
		int cnt = sqlSession.insert("memberTest.insertMember", mv);
		
		if(cnt > 0) {
			System.out.println("insert 성공!");
		}else {
			System.out.println("insert 실패!!!");
		}
		*/
		
		// 2-2. update 연습
		System.out.println("update작업 시작...");
		
		MemberVO mv2 = new MemberVO();
		mv2.setMemId("d001");
		mv2.setMemName("윤다영");
		mv2.setMemTel("6666-6666");
		mv2.setMemAddr("부산시 해운대구");
		
		// update()메서드의 반환값도 성공한 레코드 수이다.
		int cnt = sqlSession.update("memberTest.updateMember", mv2);
		
		if(cnt > 0) {
			System.out.println("update 성공!");
		}else {
			System.out.println("udpate 실패!!!");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
