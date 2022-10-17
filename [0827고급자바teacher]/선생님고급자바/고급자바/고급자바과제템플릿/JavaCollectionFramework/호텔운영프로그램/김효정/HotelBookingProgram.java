package assignment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelBookingProgram {

	private Scanner scan;
	private Map<String, Hotel> HotelBookingMap;

	public HotelBookingProgram() {
		scan = new Scanner(System.in);
		HotelBookingMap = new HashMap<String, Hotel>();
	}

	public void displayMenu() {
		System.out.println("*******************************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인 2.체크아웃 3.객실상태 4.업무종료");
		System.out.println("*******************************************");
		System.out.print("메뉴 선택 => ");
	}

	public void HotelBookingStart() {
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		System.out.println();

		while (true) {

			displayMenu();

			int menuNum = scan.nextInt();

			switch (menuNum) {
			case 1:
				checkIn(); // 등록(체크인)
				break;

			case 2:
				checkOut(); // 삭제(체크아웃)
				break;

			case 3:
				roomAll(); // 전체 출력
				break;

			case 0:
				System.out.println("**************************");
				System.out.println("호텔 문을 닫았습니다.");
				System.out.println("**************************");
				return;
			default:
				System.out.println("다시 입력해주세요.");
			}
		}
	}

	private void checkIn() {
		System.out.println();
		System.out.println("어느 방에 체크인 하시겠습니까?");
		System.out.println("방 번호 입력 => ");
		String roomNo = scan.next();

		if (HotelBookingMap.get(roomNo) != null) {
			System.out.println(roomNo + "번 방에는 이미 사람이 있습니다.");
			return;
		}

		System.out.print("이름 => ");
		String name = scan.next();

		scan.nextLine();

		HotelBookingMap.put(roomNo, new Hotel(roomNo, name));
		System.out.println("체크인 되었습니다.");
	}

	private void checkOut() {
		System.out.println();
		System.out.println("어느 방을 체크아웃 하시겠습니까?");
		System.out.println("방 번호 입력 => ");
		String roomNo = scan.next();

		if (HotelBookingMap.remove(roomNo) == null) {
			System.out.println(roomNo + "번 방에는 체크인 한 사람이 없습니다.");
		} else {
			System.out.println("체크아웃 되었습니다.");
		}
	}

	private void roomAll() {
		Set<String> keySet = HotelBookingMap.keySet();

		if (keySet.size() == 0) {
			System.out.println("체크인 한 사람이 없습니다.");
		} else {
			Iterator<String> it = keySet.iterator();
			while (it.hasNext()) {
				String roomNo = it.next();
				Hotel h = HotelBookingMap.get(roomNo);
				System.out.println("방 번호: " + h.getRoomNo() + ", 투숙객: " + h.getName());
			}
		}
	}
	
	public static void main(String[] args) {
		new HotelBookingProgram().HotelBookingStart();
	}
}

class Hotel {
	private String roomNo; // 방번호
	private String name; // 이름
	
	public Hotel(String roomNo, String name) {
		super();
		this.roomNo = roomNo;
		this.name = name;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Hotel [roomNo=" + roomNo + ", name=" + name + "]";
	}

}
