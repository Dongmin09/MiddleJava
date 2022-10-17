package kr.or.ddit.basic.homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class H03Hotel {

//	호텔 운영을 관리하는 프로그램 작성.(Map이용)
//	- 키값은 방번호 
	private Scanner scanner;
	private Map<String, Hotel> hotelMap;
	public H03Hotel() {
		scanner = new Scanner(System.in);
		hotelMap = new HashMap<String, Hotel>();
	}

	public void displayMenu() {
		System.out.println();
		System.out.println("*********************************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
		System.out.println("*********************************************");
		System.out.print("메뉴선택 => ");
	}

	// 프로그램을 시작하는 메서드
	public void hotelStart() {
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");

		while (true) {

			displayMenu();

			int menuNum = scanner.nextInt();

			switch (menuNum) {
			case 1: checkIn();
				break;
			case 2:	checkOut();
				break;
			case 3:	condision();
				break;
			case 4:
				System.out.println("**************************");
				System.out.println("호텔 문을 닫았습니다.");
				System.out.println("**************************");
			default:
				System.out.println("잘못 입력했습니다. 다시입력하세요.");

			}
		}
	}
	// 객실 상태
	private void condision() {
		Set<String> keySet = hotelMap.keySet();
		
		if(keySet.size() == 0) {
			System.out.println("투숙객이 없습니다.");
		}else {
			Iterator<String> it = keySet.iterator();
			while(it.hasNext()) {
				String roomNum = it.next();
				Hotel h = hotelMap.get(roomNum);
				System.out.println("방번호 : "+ h.getRoomNum() + ", 투숙객 : "
						+ h.getName());
						
			}
		}
	}

	// 체크아웃
private void checkOut() {
	System.out.println();
	System.out.println("어느방을 체크아웃 하시겠습니까?");
	System.out.print("방번호 입력 =>  ");		
	String roomNum = scanner.next();
	if(hotelMap.remove(roomNum) == null) {
		System.out.println(roomNum + "방에는 체크인한 사람이 없습니다.");
	}else {
		System.out.println("체크아웃 되었습니다.");
	}
	}

	//	체크인
	private void checkIn() {
		System.out.println();
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 =>  ");		
		String roomNum = scanner.next();
		
		if(hotelMap.get(roomNum) != null) {
			System.out.println(roomNum +"방에는 이미 사람이 있습니다.");
			return;
		}
		System.out.print("이름 입력 => ");
		
		scanner.nextLine();
		String name = scanner.nextLine();
		hotelMap.put(roomNum, new Hotel(roomNum, name));
		System.out.println("체크인 되었습니다.");
		
	}
	public static void main(String[] args) {
		new H03Hotel().hotelStart();
	}		
}

class Hotel{
	private String roomNum;
	private String name;

	public Hotel(String roomNum, String name) {
		super();
		this.roomNum = roomNum;
		this.name = name;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "방번호 : " + roomNum + ",투숙객 :" + name;
	}
}
