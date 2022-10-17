import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
	public static void main(String[] args) {
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		boolean continueMenu = true;
		
		while(continueMenu) {
			System.out.println("==========================");
			System.out.println("         Lotto 프로그램");
			System.out.println("--------------------------");
			System.out.println("	1. Lotto 구입");
			System.out.println("	2. 프로그램 종료");
			System.out.println("==========================	");
			System.out.print("메뉴를 입력하세요.");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.println("(1000원에 로또번호 하나입니다.)");
				System.out.print("금액입력:");
				int money = sc.nextInt();
				int change = money / 1000;
				int changeCoin = money % 1000; 
				int lottoTime = 1;
				System.out.println("행운의 로또번호는 아래와 같습니다.");
				while (lottoTime <=change) {
						Set<Integer> intRnd = new HashSet<Integer>();
						while(intRnd.size() < 6) {
							int num = rd.nextInt(45)+1;
							intRnd.add(num);
						}
						Set<Integer> treeIntRnd = new TreeSet<Integer>(intRnd);
						
						System.out.println("로또번호"+(lottoTime)+"번: "+treeIntRnd);
						
						lottoTime++;
						}
					System.out.println("\n받은 금액은 "+money+"원이고 거스름돈은 "+changeCoin+"원 입니다.");
				break;
			case 2:
				System.out.println("이용해주셔서 감사합니다.");
				System.out.println("감사합니다");
				continueMenu = false;
				break;
			}
		}
	}
}

