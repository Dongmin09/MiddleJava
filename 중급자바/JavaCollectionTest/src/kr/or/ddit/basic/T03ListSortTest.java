package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T03ListSortTest {
/*
 * 정렬과 관련된 interface는 Comparable과 Comparator 두 가지가 있다.
 * 
 * 	- 보통 객체 자체에 정렬 기능을 넣기 위해서는 Comparable 을 구현하고 
 * 	   정렬 기준을 별도로 구현하고 싶은 경우에는 Comparator을 구현하여 사용한다.
 * 
 * 	
 * 	
 * 
 * 
 */

public static void main(String[] args) {
	List<String> list = new ArrayList<String>();
	
	list.add("일지매");
	list.add("홍길동");
	list.add("성춘향");
	list.add("변학도");
	list.add("이순신");
	System.out.println("정렬 전:" + list);
	
	/*
	 * 
	 * 정렬은 Collection.sort() 메소드를 이용하여 정렬한다,
	 * 정렬은 기본적으로 '오름차순정렬'을 수행한다
	 * 오름차순 정렬은 데이터의 숫자가 점점 커지는 것을 의미 (사전순 국어사전, 영어사전)
	 * 
	 * 정렬방식을 변경하려면 정렬방식을 결정하는 객체를 만들어서
	 * Collectoion.sort()메소듸 인수로 넘겨주면된다.
	 * 
	 * static 메소드 는 객체를 만들지 않아도 클래스 이름만 알면 바로 메소드를 사용할수 잇다.
	 * 
	 */
	Collections.sort(list); // 오름차순정렬
	System.out.println("정렬 후 : " + list);
	
	
	Collections.shuffle(list); // 섞기
	System.out.println("섞기 후" + list);
	
	Collections.sort(list, new Desc());
	System.out.println("외부정렬자로 만든 후" + list);
		

}


}

/*
 * 정렬방식을 결정하는 class는 Comparator라는 인터페이스를 구현해야한다.
 * 이 Comparator인터페이스의 compare()라는 메소드를 재정의하여 구현하면된다.
 * 
 */
class Desc implements Comparator<String> {
	
	/*
	 * compare()메소드의 반환값을 결정하는 방법
	 * => 이 메소드의 양수를 반환하면 두값의 순서가 바뀐다.(오름차순이 기본 베이스)
	 * 
	 * - 오름차순 정렬일경우..
	 * => 앞의 값이 크면 양수, 같으면 0, 앞의 값이 작으면 음수를 반환하도록 한다.
	 * 
	 * 
	 * - String 객체에는 정렬을 위해서 comapreTo()메소드가 구현되어 있는데
	 * 이 메소드의 반환 값은 오름차순에 맞게 반환되도록 구현되어 있다.
	 * (Wrapper클래스와 Date, File 클래스에도 구현되어 있다.)
	 * 
	 * 기본은 str1.compareTo(str2) 오름차순정렬
	 * 기본은 str1.compareTo(str2)*-1 내림차순정렬 (부호가 바뀜)
	 * 
	 */
	
	

	@Override
	public int compare(String str1, String str2) {
		
		return str1.compareTo(str2)*-1;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}











