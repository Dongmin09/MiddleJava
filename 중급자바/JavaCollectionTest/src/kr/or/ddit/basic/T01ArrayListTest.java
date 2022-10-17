package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T01ArrayListTest {

	public static void main(String[] args) {

		// ArrayList는 기본적인 사용법이 Vector와 같다
		// Default Capacity = 10;
		// new LinkedList();  아래와 같은 의미
		List list1 = new ArrayList();

		// add()메소드를 사용해서 데이터를 추가한다


		
		list1.add("aaa");
		list1.add("bbb");
		list1.add(111); // == add(new Integer(111)) rapper class -> autoboxing
		list1.add('k');
		list1.add(true);
		list1.add(12.34);

		// size() => 데이터의 개수
		System.out.println("size ->" + list1.size());
		System.out.println("list1 =>" + list1);

		// get 으로 데이터 꺼내오기
		System.out.println("1번재 자료 :" + list1.get(1)); // 인덱스의 원하는 위치에 데이터 넣기가 가능하다.

		// 데이터 끼워넣기
		list1.add(0, "zzz");
		System.out.println("list1 =>" + list1);

		// 데이터 변경하기 (set 메서드)
		String temp = (String) list1.set(0, "YYY"); // 두개의 값을 넣어서 첫번째 값을 변경
		System.out.println("temp =>" + temp);
		System.out.println("list1 =>" + list1);

		// 삭제하기도 같다.
		list1.remove(0);
		System.out.println("삭제 후 :" + list1);

		list1.remove("bbb");
		System.out.println("bbb 삭제후 :" + list1);
		System.out.println("=======================");

		list1.remove(new Integer(111));
		System.out.println("1111 삭제후" + list1);

		// 제네릭을 지정하여 선언할 수 있다.
		List<String> list2 = new ArrayList<String>();

		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");

		for (int i = 0; i < list2.size(); i++) {

			System.out.println(i + ":" + list2.get(i));
		}

		System.out.println("------------------");

		// 향샹된 for문(foreach 문)
		for (String s : list2)
			System.out.println(s);

		// contains(비교객체); => 리스트에 '비교객체'를 찾아 '비교객체'가
		// 있으면 true, 없으면 false 로 리턴

		System.out.println("DDD");
		System.out.println("ZZZ");

		// indexOf(비고객체); => 리스트에서 '비교객체'를 찾아 '비교객체'가
		// 있는 index값을 반환함. 없으면 -1을 반환함

		System.out.println("DDD의 index값 :" + list2.indexOf("DDD"));
		System.out.println("ZZZ의 index값 :" + list2.indexOf("ZZZ"));

		System.out.println("---------");

		// toArray() => 리스트안의 데이터들을 배열로 반환하여 반환하고
		// 기본적으로 Object형 배열로 반환한다

		Object[] strArr = list2.toArray();
		System.out.println("배열의 개수 :" + strArr.length);

		// 리스트의 제너릭 타입에 맞는 자료형의 배열로 변환하는 방법
		// 제너릭타입 0개짜리 배열을 생성해서 내부열로 변환
		// 형식) toArray(new 제너럭타입[0])

		String[] strArr2 = list2.toArray(new String[0]);
		System.out.println("strArr2의 개수 :" + strArr2.length);

		 //리스트 삭제 처리
		for (int i = 0; i < list2.size(); i++) {
			
			list2.remove(list2.get(i));
			


		
			
		}
		System.out.println(list2.size());

	}

}
