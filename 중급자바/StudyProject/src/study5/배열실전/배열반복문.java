package study5.배열실전;

import java.util.Scanner;

public class 배열반복문 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int[] unit = { 50000, 10000, 1000, 500, 100, 50, 10, 1 };

		System.out.println("금액을 입력하세요");
		int money = scanner.nextInt();

		int money50000 = money % 50000;
		int money10000 = money % 10000;
		int money5000 = money % 5000;
		int money1000 = money % 1000;
		int money500 = money % 500;
		int money100 = money % 100;
		int money50 = money % 50;
		int money10 = money % 10;
		int money1 = money % 1;

		for (int i = 0; i < unit.length; i++) {
			if (money >= unit[0]) {

				System.out.println("5만 : " + (money / 50000));

				money = money50000;

			}
			if (money >= unit[1]) {

				System.out.println("1만 : " + (money / 10000));

				money = money10000;

			}

			if (money >= unit[2]) {

				System.out.println("1천 : " + (money / 1000));

				money = money1000;

			}
			if (money >= unit[3]) {

				System.out.println("500 : " + (money / 500));

				money = money500;

			}
			if (money >= unit[4]) {

				System.out.println("100 : " + (money / 100));

				money = money100;

			}
			if (money >= unit[5]) {

				System.out.println("50원 : " + (money / 50));

				money = money50;

			}
			if (money >= unit[6]) {

				System.out.println("10원 : " + (money / 10));

				money = money10;

			}
			if (money >= unit[7]) {

				System.out.println("1원 : " + money / 1);
				 money = money1;

			}

		}

	}

}
