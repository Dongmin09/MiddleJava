
package example4;
import java.util.Scanner;
public class fsdf {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int[] day = new int[13];

		while (true) {
			System.out.println("년도 : ");
			int year = scan.nextInt();
			
			System.out.println("월 : ");
			int month = scan.nextInt();

			if (year == 0 || month == 0) {
				System.out.println("프로그램 종료 ");
				return;
			} else if (month > 12) {
				System.out.println("잘못 입력하였습니다 다시 입력해주세요.");
				continue;
			}
			if (month == 2) {
				if (year % 400 == 0 || ((year % 4 == 0) && (year % 100 != 0))) {
					day[month] = 29;
				} else {
					day[month] = 28;
				}
			} else if (month == 4 || month == 6 || month == 9 || month == 11) {
				day[month] = 30;
			} else {
				day[month] = 31;
			}
			System.out.println("입력하신 달에 일수는" + day[month] + "일 입니다.");
		}

	}
}
