package kr.or.ddit.basic.homework;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Lotto {

	private Scanner scan;

	public Lotto() {
		scan = new Scanner(System.in);
	}

	public void displayMenu() {
		System.out.println("=============================");
		System.out.println("Lotto 프로그램");
		System.out.println("-----------------------------");
		System.out.println("1. Lotto 구입");
		System.out.println("2. 프로그램 종료");
		System.out.println("=============================");
	}

	public void LottoStart() {

		while (true) {

			displayMenu(); // 메뉴 출력

			System.out.print("메뉴선택 : ");
			int menuNum = scan.nextInt(); // 메뉴 번호 입력

			switch (menuNum) {
			case 1:
				lottoBuy(); // 체크인
				break;
			case 2:
				System.out.println();
				System.out.println("감사합니다.");
				return;
			default:
				System.out.println("잘못 입력했습니다. 다시입력하세요.");
			} // switch문
		} // while문
	}

	public void lottoBuy() {

		System.out.println();
		System.out.println("Lotto 구입 시작");
		System.out.println();
		System.out.println("(1000원에 로또번호 하나입니다.)");
		System.out.print("금액 입력 : ");
		int cost = scan.nextInt();
		System.out.println();
		System.out.println("행운의 로또번호는 다음과 같습니다.");
		
		int lottoCount = (int) cost / 1000;
		int change = cost % 1000;
		
		for (int i = 0; i < lottoCount; i++) {
			Set<Integer> lottoNum = new HashSet<Integer>();
			while (lottoNum.size() < 6) {
				int num = (int) (Math.random() * 46 + 1);

				lottoNum.add(num);
			}

			System.out.println("로또번호" + i + " : " + lottoNum);
		}

		System.out.println();
		System.out.println("받은 금액은 " + cost + "이고 거스름돈은 " + change + "입니다.");
		System.out.println();
	}

	public static void main(String[] args) {
		new Lotto().LottoStart();
	}

}