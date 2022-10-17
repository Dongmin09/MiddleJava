package kr.or.ddit.basic.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class H02Lotto {
	private Scanner scanner;

	public H02Lotto() {
		scanner = new Scanner(System.in);
		Random random = new Random();
	}

	public void menu() {
		System.out.println();
		System.out.println("1. Lotto 구입");
		System.out.println("2. 프로그램 종료");
		System.out.print("메뉴선택 : ");
	}

	// 프로그램 시작하는 메서드
	public void lottoStart() {
		System.out.println("============================");
		System.out.println("Lotto 프로그램");
		System.out.println("----------------------------");

		while (true) {
			menu();

			int number = scanner.nextInt();

			switch (number) {
			case 1:
				buy();
				break;
			case 2:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력했습니다. 다시입력하세요.");
			}
		}
	}

	private void buy() {
		System.out.println("\n Lotto 구입 시작 \n");
		System.out.println("(1000원에 로또번호 하나입니다.)\n");
		System.out.print(" 금액입력 : ");
		scanner.nextLine();

		int sum = scanner.nextInt();
		int num = sum / 1000;
		Set<Integer> intRnd = new HashSet<Integer>();
		System.out.println("행운의 로또번호는 아래와 같습니다.");
		int cnt =0;
		for (int i = 1; i <= num; i++) {
			intRnd.clear();
			cnt++;
			while (intRnd.size() < 6) {
				
				int num1 = (int) (Math.random() * 45 + 1);
				intRnd.add(num1);
			}
			System.out.println("로또번호" + cnt + " : " + intRnd);
		}
		System.out.println("받은 금액은 " + sum + "원이고 거스름돈은 " + sum % 1000 + "원입니다.");
	}

	public static void main(String[] args) {
		new H02Lotto().lottoStart();
	}
}
