package kr.or.ddit.basic.homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Hotel {
	private Scanner scan;
	private Map<String, RoomNum> HotelMap;

	public Hotel() {
		scan = new Scanner(System.in);
		HotelMap = new HashMap<String, RoomNum>();
	}

	// 메뉴를 출력하는 메서드
	public void HotelMenu() {
		System.out.println();
		System.out.println("*******************");
		System.out.println("어떤 업무를 하시겠습니까? ");
		System.out.println(" 1. 체크인");
		System.out.println(" 2. 체크아웃");
		System.out.println(" 3. 객실상태");
		System.out.println(" 4. 업무종료");
		System.out.println("*******************");
		System.out.print("메뉴선택 => ");

	}

	// 프로그램을 시작하는 메서드
	public void HotelStart() {
		System.out.println("===================");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("===================");
		while (true) {

			HotelMenu(); // 메뉴 출력

			int menuNum = scan.nextInt(); // 메뉴 번호 입력

			switch (menuNum) {
			case 1:
				checkIn(); // 체크인
				break;
			case 2:
				 checkOut(); // 체크아웃
				break;
			case 3:
				 roomCondition(); // 객실상태
				break;
			case 4:
				System.out.println("===================");
				System.out.println("호텔 문을 닫았습니다.");
				System.out.println("===================");
				return;
			default:
				System.out.println("잘못 입력했습니다. 다시입력하세요.");
			} // switch문
		} // while문
	}

	private void checkIn() {
		System.out.println();
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		String num = scan.next();
		if (HotelMap.get(num) != null) {
			System.out.println(num + "방은 이미 사람이 있습니다.");
			return;
		}
		System.out.println("누구를 체크인 하시겠습니까? ");
		System.out.print("이름 입력 => ");
		String name = scan.next();
		System.out.println("체크인 되었습니다.");
		
		scan.nextLine();

		HotelMap.put(num, new RoomNum(num, name));

	}
	private void roomCondition() {
		Set<String> keySet = HotelMap.keySet();
		
		
		if (keySet.size() == 0) {
			System.out.println("객실에 사람이 없습니다.");
		}else {
			Iterator<String> it = keySet.iterator();
			int cnt = 0;
			while (it.hasNext()) {
				cnt++;
				String num = it.next(); //키값 가져오기
				RoomNum p = HotelMap.get(num);//get으로 키값 꺼내오고
				System.out.println(" " + cnt + "\t방번호 : " + p.getNum() + ",\t투숙객 : " + p.getName());
			}
		}
	}
	/**
	 * 체크인 정보를 삭제하기 위한 체크아웃 메서드
	 */
	private void checkOut() {
		
		System.out.println();
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		String num = scan.next();
		
		scan.nextLine();
		
		// remove(key) => 삭제를 성공하면 삭제된 value값을 반환하고,
		//				   실패하면 null를 리턴한다.
		if (HotelMap.remove(num) == null) {
			System.out.println(num + "방에는 체크인한 사람이 없습니다.");
		}else {
			System.out.println(num + "체크아웃 되었습니다.");
		}
	}
	/**
	 * 새로운  정보를 등록하는 메서드 
	 * 이미 등록된 사람은 등록 되지 않는다.
	 */
//	private void insert() {
//		System.out.println();
//		System.out.println("어떤방에 체크인 하시겠습니까?");
//		System.out.print("방번호 입력 => ");
//		String num = scan.nextLine();
//		
//		System.out.println("누구를 체크인 하시겠습니까? ");
//		System.out.print("이름 입력 => ");
//		String name = scan.nextLine();
//		
//		// 이미 등록된 사람인지 체크
//		// get()메서드로 값을 가져올 때 가져올 자료가 없으면 null을 반환한다.
//		if (HotelMap.get(name) != null) {
//			System.out.println(num + "방에는 이미 사람이 있습니다.");
//			return;
//		}
//		
//		HotelMap.put(num, new RoomNum(num, name));
//		
//		System.out.println(name + "방에는 체크인한 사람이 없습니다.");		
//	}

	public static void main(String[] args) {
		new Hotel().HotelStart();
	}
	
}

class RoomNum {
	private String num; // 방번호
	private String name; // 이름

	public RoomNum(String num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "RoomNum [num=" + num + ", name=" + name + "]";
	}

}
