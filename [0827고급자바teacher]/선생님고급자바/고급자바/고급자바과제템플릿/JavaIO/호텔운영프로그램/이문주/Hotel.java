package hotelFileSave;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Hotel {
	private Scanner scanner;
	private Map<Integer,String> map = new HashMap<>();
	
	public Hotel() {
		scanner = new Scanner(System.in);
	}
	
	public void hotelMenu() {
		System.out.println("************************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인  2.체크아웃  3.객실상태  4.업무종료");
		System.out.println("************************************");
		System.out.print("메뉴선택 => ");
	}
	
	public static void main(String[] args) throws IOException {
		new Hotel().hotelStart();
	}
	

	public void hotelStart() throws IOException {
		
		try(FileInputStream fis = new FileInputStream("e:/D_Other/HotelSheet.bin");
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			
			Object obj = null;
			
			while((obj = ois.readObject()) != null) {
				map = (Map<Integer, String>) obj;
			}
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		while(true) {
			
			hotelMenu();
			
			int menuNum = scanner.nextInt();
			
			switch(menuNum) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				roomStatus();
				break;
			case 4:
				System.out.println();
				System.out.println("****************");
				System.out.println("호텔 문을 닫습니다.");
				System.out.println("****************");
				
				FileOutputStream fos = null;
				ObjectOutputStream oss = null;
				try {
					
					fos = new FileOutputStream("e:/D_Other/HotelSheet.bin");
					oss = new ObjectOutputStream(fos);
					
					oss.writeObject(map);
					
					System.out.println("체크인 완료");
					
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					try {
						oss.close();
					} catch (IOException e2) {
						e2.printStackTrace();
					}
				}
				return;
			
			}
		}
	}
	
	
	public void checkIn() {
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		int roomNum = scanner.nextInt();
		
		
		
		if(map.get(roomNum) != null) {
			System.out.println(roomNum + "방에는 이미 사람이 있습니다.");
			System.out.println();
		} else {
			System.out.println("누구를 체크인 하시겠습니까?");
			System.out.print("이름 입력 => ");
			String name = scanner.next();
			map.put(roomNum, name);
			System.out.println("체크인 되었습니다.");
			System.out.println();
		}
	}
	
	public void checkOut() {
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		int roomNum = scanner.nextInt();
		
		
		if(map.get(roomNum)==null) {
			System.out.println(roomNum + "방에는 체크인한 사람이 없습니다.\n");
		}else {			
			map.remove(roomNum);
			System.out.println("체크아웃 되었습니다.\n");
		}
		

		
	}
	
	public void roomStatus() {
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		Iterator<Entry<Integer, String>> entryIt = entrySet.iterator();
		
		while(entryIt.hasNext()) {
			Entry<Integer, String> entry = entryIt.next();
			
			System.out.println("방번호 : " + entry.getKey()+ ", 투숙객 : " + entry.getValue());
		}
		System.out.println();
		
	}
	
	
}


