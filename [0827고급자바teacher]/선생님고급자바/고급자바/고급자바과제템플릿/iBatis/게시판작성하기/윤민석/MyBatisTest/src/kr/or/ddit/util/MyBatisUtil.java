package kr.or.ddit.util;

import java.io.*;
import java.nio.charset.*;

import org.apache.ibatis.io.*;
import org.apache.ibatis.session.*;

/**
 * SqlSession 객체를 제공하기 위한 유틸클래스
 * @author PC-22
 *
 */
public class MyBatisUtil {
	private static SqlSessionFactory sessionFactory;
	
	static {
		try {
			// 1-1. xml설정문서 읽어오기
			// 설정파일의 인코딩정보 설정(한글처리를 위해서...)
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			Reader rd = 
					Resources.getResourceAsReader("config/mybatis-config.xml");
			// 1-2. 위에서 읽어온 Reader객체를 이용하여 실제 작업을 진행할 객체 생성하기
			sessionFactory = 
					new SqlSessionFactoryBuilder().build(rd);
			
			rd.close(); // 자원반납
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * SqlSession 객체를 제공하는 팩토리 메서드
	 * @return SqlSession 객체
	 */
	public static SqlSession getInstance() {
		return sessionFactory.openSession();
	}
	
	/**
	 * SqlSession 객체를 제공하는 펙토리 메서드
	 * @param autoCommit 오토커밋 여부
	 * @return SqlSession 객체
	 */
	public static SqlSession getInstance(boolean autoCommit) {
		return sessionFactory.openSession(autoCommit);
	}
	
}
