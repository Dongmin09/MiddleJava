package Array;

import java.util.Scanner;

/*
 * 정수 10개를 입력받은 후 세번째, 다섯번째와 마지막으로 입력받은 정수를 차례로 출력하시오
 * 입력예) 5 3 9 6 8 4 2 8 10 1
 * 출력예) 9 8 1
 */
public class ArrayListTest {
	public static void main(String[] args) {

		int[] num = new int[10];

//		int[] num ;
//		num = new int[10];

		Scanner scn = new Scanner(System.in);

		// System.out.println("숫자입력해");
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(scn.next());
//			System.out.println(num[i]);

		}
//		System.out.print("입력) " +num[index]);
		System.out.println("출력) " + num[2] + ", " + num[4] + ", " + num[9]);
	}

	
}
