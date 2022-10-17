package kr.or.ddit.basic;


public class Service {
	
	@PrintAnnotation()
	public void method1() {
		System.out.println("메서드 1에서 출력되었습니다.");	
	}
	// @PrintAnnotation(value = "%")  
	@PrintAnnotation("%")   // value 타입요소만 설정하고 싶으면 생략이 가능하다. 위와 같은 의미
	public void method2() {
		System.out.println("메서드 2에서 출력되었습니다.");	
	}
	@PrintAnnotation(value = "$", count = 50)
	public void method3() {
		System.out.println("메서드 3에서 출력되었습니다.");	
	}
	
	
	
}
