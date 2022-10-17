package study04;

import java.util.Scanner;

public class 배열1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] array = null;
		array = new int[10];
		
		
		for(int i=0; i<array.length; i++) {
			
			int array1 = scanner.nextInt();
			System.out.println(array1[2] + array1[4]);
		}
		
		
	}


}
