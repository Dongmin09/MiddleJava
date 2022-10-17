package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Lotto {
	Scanner scan = new Scanner(System.in);
	
	int cunt = 0;
	int price = 0;
	public void menu() {
		while (true) {
			System.out.println("======================");
			System.out.println("Lotto 프로그램");
			System.out.println("----------------------");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("======================");
			System.out.print("메뉴선택 : ");
			
			int menuNum = scan.nextInt(); // 메뉴번호 입력

			switch (menuNum) {
			case 1:
				num(); // 메뉴선택
				break;
			case 2: // 프로그램 종류
				System.out.println("감사합니다.");
				System.exit(0);
			}
		}
	}
	private void num() {
		System.out.println("로또구매 시작");
		System.out.println();
		System.out.println("(1000원에 로또번호 하나입니다.)");
		System.out.print("금액 입력 : ");
		int price= scan.nextInt(); // 금액 입력
		cunt = price/1000;
		price = price%1000;
		System.out.println();
		System.out.println("행운의 로또번호는 아래와 같습니다.");
		lottoNum();
		System.out.println();
		System.out.println("구매 장수는 " + cunt + "개 이고 거스름돈은" + price + "원입니다.");
		
		
		
	}
	public void lottoNum() {
			
		
		for (int i = 0; i < cunt; i++) {
		Set<Integer> intRnd = new HashSet<Integer>();
		
		while (intRnd.size() < 6) {
			int num = (int) (Math.random() * 45 + 1);
			
			intRnd.add(num);
		}
		System.out.println("로또번호" + (i+1) + " : " + intRnd);
		}
	}
}

























