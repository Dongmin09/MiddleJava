package homeWork;

// 내가 수정한거 이동민
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelprogreamTest {

	private Scanner scan;
	private Map<String, String> HotelprogreamMap;

	public HotelprogreamTest() {
		scan = new Scanner(System.in);
		HotelprogreamMap = new HashMap<String, String>();
	}

	// 메뉴를 출력하는 메서드
	public void displayMenu() {
		System.out.println();
		System.out.print("어떤 업무를 하시겠습니까?.");
		System.out.print(" 1. 체크인");
		System.out.print(" 2. 체크아웃");
		System.out.print(" 3. 객실상태");
		System.out.println(" 4. 업무종료");
		System.out.print(" 번호입력 >> ");
	}

	// 프로그램을 시작하는 메서드
	public void hotelProgeramStart() {
		System.out.println("==================================");
		System.out.println("   호텔문을 열었당깨요 ~~~~");
		System.out.println("==================================");

		while (true) {

			displayMenu(); // 메뉴 출력

			int menuNum = scan.nextInt(); // 메뉴 번호 입력

			switch (menuNum) {
			case 1:
				insert(); // 등록
				break;
			case 2:
				delete(); // 삭제
				break;
			case 3:
				displayAll(); // 전체 출력
				break;
			case 4:
				System.out.println("프로그램을 종료합니다...");
				return;
			default:
				System.out.println("잘못 입력했습니다. 다시입력하세요.");
			} // switch문

		} // while문

	}

	private void insert() {

		scan.nextLine();
		System.out.println();
		System.out.println("어느 방에 체크인 하시겠습니까?");
		System.out.print(" 방번호 입력 >> ");
		String num = scan.next();

		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 :");
		String name = scan.next();

		// 이미 등록된 사람인지 체크
		// get()메소드로 값을 가져올때 가져올 자료가 없으면 null을 반환한다.
		if (HotelprogreamMap.get(num) != null) {
			System.out.println(num + "번방에는 이미 사람이 있습니다.");
			return;
		}

		if (HotelprogreamMap.get(num) == null) {
			HotelprogreamMap.put(num, name);
			System.out.println("체크인 되었습니다.");

		}

	}

	private void delete() {

		scan.nextLine();
		System.out.println();
		System.out.println("어느 방에 체크아웃 하시겠습니까?");
		System.out.print(" 방번호 입력 >> ");
		String num = scan.next();

		// 이미 등록된 사람인지 체크
		// get()메소드로 값을 가져올때 가져올 자료가 없으면 null을 반환한다.
		if (HotelprogreamMap.remove(num) == null) {
			System.out.println(num + "번방에는 체크인 된 사람이 없습니다.");
			return;
		} else {
			HotelprogreamMap.remove(num);
			System.out.println("체크아웃 되었습니다.");

		}
	}

	private void displayAll() {
		Set<String> keySet = HotelprogreamMap.keySet();
		System.out.println("=====================");
		System.out.println(" 객실상태");
		System.out.println("========================");

		if (keySet.size() == 0) {

			System.out.println("이용중인 객실이 없습니다.");

		} else {

			for (String key : keySet) {
				System.out.println("방번호 : " + key + " " + " 투숙객 : " + HotelprogreamMap.get(key));
			}

		}

		System.out.println("========================");

	}

	public static void main(String[] args) {

		new HotelprogreamTest().hotelProgeramStart();

	}

}
