package kr.or.ddit.reflection;

import java.lang.reflect.Modifier;

public class T02ClassMetadataTest {
	
	public static void main(String[] args) {
		
		// 클래스 오브젝트 생성하기
		Class<?> klass = SampleVO.class;
		
		System.out.println("심플클래스명 : " + klass.getSimpleName());
		System.out.println("클래스명 : " + klass.getName());
		System.out.println("상위클래스명 : " + klass.getSuperclass().getName());
		
		//패키지 정보 가져오기
		Package pkg = klass.getPackage();
		System.out.println("패키지 정보: " + pkg.getName());
		
		
		// 해당 클래스에서 구현하고 있는 인터페이스 목록 가져오기
		// 인터페이스가 여러개일수 있으므로 배열로 가져옴( 와일드 카드 사용)
		Class<?>[] interfaces = klass.getInterfaces();
		
		System.out.println("인터페이스 목록 :");
		for(Class<?> inf : interfaces)
		{
			System.out.print(inf.getName() + " | ");
		}
		System.out.println();
		
		// 클래스의 접근제어자 가져오기 (flag bit값이 반환됨. => 접근 제어자 설정 유무 정보)
		int modFlag = klass.getModifiers();
		
		System.out.println("접근제어자 :" + Modifier.toString(modFlag));
		
		
	}
	
}
