package kr.or.ddit.basic;

public class T02EnumTest {

	/*
	 * 열거형 => 상수값들을 선언하는 방법
	 * 
	 * static final int A =0;
	 * static final int B =1;
	 * static final int C =2;
	 * static final int D =3;
	
	enum Data (A,B,C,D);
	
	열거형을 선언하는 방법
		enum 열거형 이름{ 상수값1, 상수값2, ..., 상수값 n};
	
	 */
		//City 열거형 객체 선언(기본값을 이용하는 열거형)
		// 서울() 데이터가없어서 괄호 생략가능.
	public enum City { 서울(), 부산(), 대구, 광주,대전 };
	
	public enum HomeTown{서울(), 부산(), 대구, 광주,대전,경기도}
	
	//	데이터값을 임의로 지정한 열거형 객체 선언
	//	데이터값을 정해 줄 경우에는 생성자를 만들어서 괄호속의 값이 변수에 저장되도록 해야 한다.
	public enum Season { 
		
		봄("3월부터 5월까지"), 여름("6월부터 8월까지"),
		가을("9월부터 11월까지"), 겨울("12월부터 2월까지");
	
	// 괄호속의 값이 저장될 변수 선언
	private String str;
	
	//	생성자 만들기(열거형의 생성자는 제어자가 묵시적으로 'private'이다.
	Season(String data){
		str = data;
	}
	
	// 값을 반환하는 메서드 작성
	public String getStr() {
		return str;
		}
	}
	
	public static void main(String[] args) {
		/*
		 * 	열거형에선튼 사용되는 메서드
		 * 
		 * 	1. name() => 열거형 상수의 이름 문자열로 반환한다.
		 * 	2. ordinal() => 열거형 상수가 정의된 문서값을 반환한다. (기본적으로 0부터 시작). ordinal의 뜻은 서수(순서)
		 * 	3. valueOF("열거형상수이름") => 지정된 열거형에서 '열거형상수이름'과 일치하는
		 * 				열거형 상수를 반환한다.
		 */
		
		City myCity1; // 열거형 객체변수 선언
		City myCity2; // 열거형 객체변수 선언
		
		// 열거형 객체변수 값 저장하기
		myCity2 = City.서울;
		myCity1 = City.valueOf("서울");
		
		System.out.println("myCity1 :" + myCity1.name());
		System.out.println("myCity1의 ordinal : " + myCity1.ordinal());
		System.out.println();
		System.out.println("myCity2 :" + myCity2.name());
		System.out.println("myCity2의 ordinal : " + myCity2.ordinal());
		System.out.println("==========================================");
		
		Season ss = Season.valueOf("여름"); // Season.여름 같은 문법
		System.out.println("name =>" + ss.name());
		System.out.println("ordinal =>" + ss.ordinal());
		System.out.println("get메서드 호출 =>" + ss.getStr());
		System.out.println("------------------------------------------");
		
		
		// 열거형이름.values() => 데이터를 배열로 가져온다.
		Season[] enumArr = Season.values();
		for(int i=0; i<enumArr.length; i++) {
			System.out.println(enumArr[i].name() + " : "
			+ enumArr[i].getStr());
		}
		// 향상된 for 문은 배열조건일 때 할 수 있다. 또는 intoralbe 이터러블
		for(City city : City.values()) {
			System.out.println(city + " : " + city.ordinal());	// city.name(), city.toString() 이 생량되어잇다 같은 의미		
		}
		
		// 타입 체크
		City city = City.대구;
		System.out.println(city == City.대전);
		System.out.println(city == City.대구);
		
		// System.out.println(city.대전 == HomeTown.대전); 홈타운 타입의 대전과 시티타입의 대전은 서로 타입이 자체가 달라서 비교가 안된다.
		// enum 같은 경우 이러한 타입을 체크하는 기능이 있다.
		
		System.out.println("대구 => " + city.compareTo(city.대구)); //comparable가 이미 구현되어 있다. ordinal값을 가지고 비교 (오름차순정렬)
		System.out.println("대구 => " + city.compareTo(city.서울));
		System.out.println("대구 => " + city.compareTo(city.대전));
		
	}
	
}
