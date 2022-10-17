package study4;

import java.util.Scanner;

public class OutputArrayTest {
	public static void main(String[] args) {
		// new로 배열하나 만들어주고
		int [] arr = new int[10];
		
		Scanner scan = new Scanner(System.in);
		
		for(int i=0; i<arr.length; i++) {
//			System.out.print("입력 받을 정수 10개 :");
			// 한줄로 입력받을려고 next()
			arr[i] = Integer.parseInt(scan.next());
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.print(arr[2] + " " + arr[4] + " " + arr[9]);
		scan.close();
	}
}
