package kr.or.ddit.basic;


class Util2{
	public static <T extends Number> int compare(T t1, T t2) {
		
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		
		return Double.compare(v1, v2);
		
	}
}

public class T05GenericMethodTest {
	public static void main(String[] args) {
		
		int result1 = Util2.compare(10, 20);
		System.out.println(result1);
		
		int result2 = Util2.<Number>compare(3.14, 3);
		System.out.println(result2);
		
//		 Util2.compare("C", "JAVA"); 이미 넘버로 햇기때문에 다른 타입은 올수가 없음 . 자기 자신이나 하휘 자식들의  같은 타입만 올수 있음
	}
}
