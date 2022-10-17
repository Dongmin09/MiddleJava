package chapter042연습문제;

import java.util.Scanner;

public class example7 {
	public static void main(String[] args) {

		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("---------------");
			System.out.println("1.예금 | 2. 출금 | 3.잔고 | 4.종료 ");
			System.out.println("---------------");
			System.out.print("선택> ");

			int menuNum = Integer.parseInt(scanner.nextLine());

			switch (menuNum) {
			case 1:
				System.out.println("예금액> ");

				balance += Integer.parseInt(scanner.nextLine());
				break;
			case 2:
				System.out.println("출금액> ");

				balance -= Integer.parseInt(scanner.nextLine());
				break;

			case 3:
				System.out.println("잔고> ");
				System.out.println(balance);
				break;

			case 4:

				run = false;
				break;
			}

			System.out.println();

		}
		System.out.println("프로그램 종료");

	}
}

/* package chapter042연습문제;

import java.util.Scanner;

public class example7 {
	public static void main(String[] args) {

		boolean run = true;
		// run에 있는 변수를 활용하여 코드를 활용
		int balance = 0;
		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("---------------");
			System.out.println("1.예금 | 2. 출금 | 3.잔고 | 4.종료 ");
			System.out.println("---------------");
			System.out.print("선택> ");
			
			int menu = scanner.nextLine();

		LOOP : switch (menu) {
			case 1:
				System.out.println("예금액> ");
				
				balance += scanner.nextInt();
				break;
			case 2:
				System.out.println("출금액> ");

				balance -= scanner.nextInt();
				break;

			case 3:
				System.out.println("잔고> " + balance);
				break;

			case 4:
				
				run = false;
				
				중복되기 때문에 break;, break; 는 되지 않음
				보통은 while(run) 보다 while(true)로 쓰는 경우가 더많음.
				Look break;
				
				case 문의 브레이크
			}

			System.out.println();

		}
		System.out.println("프로그램 종료");

	}
}
 * 
 * 
 * 
 */
