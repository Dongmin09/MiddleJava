import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelTest {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String, String>();
		boolean exitNum = true;
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		while(exitNum) {
			Scanner sc = new Scanner(System.in);
			System.out.println("*******************************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
			System.out.println("*******************************************");
			System.out.print("메뉴를 입력하세요: ");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:	
				sc.nextLine();
				System.out.println("어느방에 체크인 하시겠습니까?");
				System.out.print("방번호 입력 =>");
				String roomNum = sc.nextLine();
				System.out.println("\n누구를 체크인 하시겠습니까?");
				System.out.print("이름 입력 =>");
				String name = sc.nextLine();
				if(map.get(roomNum) == null) {
					map.put(roomNum, name);
					System.out.println("체크인 되었습니다.");
					break;
				}else {
					System.out.println(roomNum+"방에는 사람이 있습니다.");
				break;
				}
			case 2:
				sc.nextLine();
				System.out.print("체크아웃할 방을 입력해주세요: ");
				String rmRoom = sc.nextLine();
				if(map.get(rmRoom) == null) {
					System.out.println(rmRoom + "방에는 체크인한 사람이 없습니다.");
					break;
				}else {
					map.remove(rmRoom);
					System.out.println(rmRoom+"방이 체크아웃 했습니다.");
					break;
				}
			case 3:
				Set<String> keySet = map.keySet();
				for(String key : keySet) {
					System.out.println("방번호: "+key + " 투숙객: "+ map.get(key));
				}
				break;
			case 4:
				System.out.println("이용해주셔서 감사합니다.");
				exitNum = false;
				break;
			}
		}
	}
}
