package chapter042연습문제;

import java.util.Random;

public class example3 {
	public static void main(String[] args) {
		Random random = new Random();
		
		while (true) {

			int num1 = random.nextInt(6) + 1;
			int num2 = random.nextInt(6) + 1;
			System.out.println("(" + num1 + ", " + num2 + ")");

			int sum = num1 + num2;
			if (sum == 5) {
				System.out.println("주사위총합은 :" + sum);
				break;
			}

		}
		System.out.println("프로그램 종료");

	}
}
