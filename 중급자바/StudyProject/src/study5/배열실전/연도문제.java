package study5.배열실전;

import java.util.Date;
import java.util.Scanner;

public class 연도문제 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("년도: ");
		int year = scanner.nextInt();
		System.out.println("월 : ");
		int month = scanner.nextInt();
		int[] day = {28,29,30,31};

		boolean run = true;

		while (run) {

			if (month == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (month > 13) {
				System.out.println("잘못입력하셧습니다. 다시 입력해주세요");
				continue;
			}
			
			if(month == 1 || month == 3 || month == 5 || month == 7 || month == 9 || month == 11) {
			
			}
			

		}

	}

}
