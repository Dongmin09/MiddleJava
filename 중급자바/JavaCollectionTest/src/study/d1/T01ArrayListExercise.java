package study.d1;

import java.util.ArrayList;
import java.util.List;


public class T01ArrayListExercise {
public static void main(String[] args) {
	
	
	  List list1 = new ArrayList();
	  
	  
	  list1.add("나는야");
	  list1.add("퉁퉁이");
	  list1.add("골목대장이라네");
	  list1.add(100);
	  list1.add(12.55);
	  
	  System.out.println("size 개수 :"+list1.size()); 
	  System.out.println("list1" + list1);
	  
	  System.out.println("list1 데이터 가져오기" + list1.get(3));
	  
	  list1.add(4, "도라에몽");
	  list1.set(0, "진구야~");
	  
	  System.out.println(list1);
	  
	  
	  list1.remove(1); //인덱스 로삭제
	  list1.remove("퉁퉁이");  // 데이터로 삭제
	  
	  System.out.println(list1);
	
	  
	  //제네릭 선언
	  
	  List<String> list2 = new ArrayList<String>();
	  
	  list2.add("아버지는");
	  list2.add("말하셧지");
	  list2.add("인생을 즐겨라");
	  
	  
	  for (int i=0; i<list2.size(); i++) {
		  
		  System.out.println(i + " :" + list2.get(0));
	  
	  
	  //향샹된 for 문
	  
	  for (String a : list2)
	  System.out.println(a);
	  
	  System.out.println("아버지는 index 값" + list2.indexOf("아버지는")); //비교 객체가 맞으면 0
	  System.out.println("자장면 index 값" + list2.indexOf("짜장면"));  // 비교객체 없으면 -1
	  
	  
	  
	  Object[] fox = list2.toArray();
	  System.out.println(fox.length);
	  
	  
	  String[] box = list2.toArray(new String[1]);
	  System.out.println(box.length);
		  
	  
	  
	  for(int a=list2.size()-1; 0<=a; a--) {
	  
	  
//	  for(int i1=0; i1<list2.size(); i1++) {
//		  
//		  list2.removeAll(list2);
		  
	  
	  list2.remove(list2.get(a));
		  
	  
	  
//	  
//	  }
	  }
	  System.out.println("마지막" +list2.size());
}
	  }
}

