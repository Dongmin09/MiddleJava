package study5.배열실전;

import java.util.Scanner;

public class 마름모만들기 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자입력해라");
		int a = scanner.nextInt();
		int[] array = new int[a];

		// 줄 바꾸기
		for (int i = 0; i < array.length; i+=2) {
			System.out.println();	
			//별 생성
			for (int j=array.length; j>=i; j-=2) {
				System.out.print(" ");
			}		
			//별생성
			for (int j = 0; j <=i; j++) {
				System.out.print("*");
			}
			
		for (int i1 = 0; i1 < array.length-2; i1+=2) {
				System.out.println();	
				//별 생성
			for (int j=0; j<=i1; j+=2) {
				System.out.print(" ");
			}		
			//별생성
			for (int j = array.length-2; j >i1; j--) {
				System.out.print("*");
			}
			
			}
			
		}

	}

}
