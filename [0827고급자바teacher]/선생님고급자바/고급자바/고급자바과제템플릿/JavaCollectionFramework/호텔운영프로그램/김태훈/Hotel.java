package kr.or.ddit.basic.homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Hotel {

	private Scanner scan;
	private Map<String, Name> nameMap;
	
	public Hotel() {
		scan = new Scanner(System.in);
		nameMap = new HashMap<String, Name>();
	}
	
	// 메뉴를 출력하는 메서드
	public void displayMenu(){
		System.out.println();
		System.out.println("*********************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인  2.체크아웃  3.객실상태  4.업무종료");
		System.out.println("*********************************");
		System.out.print(" 메뉴선택 => ");		
	}
	
	// 프로그램을 시작하는 메서드
	public void HotelStart(){
		System.out.println();
		System.out.println("***************");
		System.out.println("호텔 문을 열었습니다. ");
		System.out.println("***************");
		
		while(true){
			
			displayMenu();  // 메뉴 출력
			
			int menuNum = scan.nextInt();   // 메뉴 번호 입력
			
			switch(menuNum){
				case 1 : checkIn();		//체크인
					break;
				case 2 : checkOut();	//체크아웃
					break;
				case 3 : roomStatus();		// 삭제
					break;
				case 4 :
					System.out.println();
					System.out.println("***************");
					System.out.println("호텔 문을 닫았습니다. ");
					System.out.println("***************");
					return;
				default :
					System.out.println("잘못 입력했습니다. 다시입력하세요.");
			} // switch문
		} // while문
	}	
		
	private void checkIn() {
		
		System.out.println();
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		String roomNum = scan.next();
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 => ");
	    String name = scan.next();
				
		Name nm = nameMap.get(roomNum);
        
        if(nameMap.get(roomNum) != null) {
        	System.out.println(roomNum + "방에는 이미 사람이 있습니다.");
        	return;
        }
                        
        nameMap.put(roomNum, new Name(roomNum, name));
        
        System.out.println("체크인 되었습니다.");
	}

	private void checkOut() {
		
		System.out.println();
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 => ");
        String roomNum = scan.next();
		
        // remove(key) => 삭제를 성공하면 삭제된 value값을 반환하고, 
        //                실패하면 null을 리턴한다. 
        if(nameMap.remove(roomNum) == null) {
        	System.out.println(roomNum + "방에는 체크인한 사람이 없습니다. ");
        } else {
        	System.out.println("체크아웃 되었습니다.");
        }
   	}
	
	private void roomStatus() {
		
		Set<String> keySet = nameMap.keySet();
			
		if(keySet.size() == 0) {
			System.out.println("예약이 없습니다.");
		} else {
			Iterator<String> it = keySet.iterator();
			int cnt = 0;
			while(it.hasNext()) {
				cnt++;
				String roomNum = it.next(); // 키값 가져오기
				Name nm = nameMap.get(roomNum);
				System.out.println("방번호 : " + nm.getRoomNum() + ", 투숙객 : " + nm.getName());
			}
		}
	}

	public static void main(String[] args) {
		new Hotel().HotelStart();
	}
	
}

class Name {
	private String roomNum; // 방번호
	private String name;    // 이름
	
	public Name(String roomNum, String name) {
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
		return String.format("방번호 : %s, 투숙객 : %s ", roomNum, name);
	}
}
