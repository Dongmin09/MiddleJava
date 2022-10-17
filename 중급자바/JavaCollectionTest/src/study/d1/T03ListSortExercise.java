package study.d1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T03ListSortExercise {
	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();

		list.add("오늘은");
		list.add("아직도");
		list.add("수요일");
		list.add("인생 새옹지마");
		System.out.println("정렬전" + list);

		Collections.sort(list);
		System.out.println("정럴후" + list);
	}
}
