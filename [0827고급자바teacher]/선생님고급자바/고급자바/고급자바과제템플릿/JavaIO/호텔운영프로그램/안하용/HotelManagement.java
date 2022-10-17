package kr.or.ddit.basic.exercise;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class HotelManagement {
	
	private Scanner scan;
	private Map<String,String> roomInfo;
	
	
	public HotelManagement() {
		scan = new Scanner(System.in);
		roomInfo = new HashMap<>();
	}
	
	public static void main(String[] args) {
		new HotelManagement().run();
	}
	
	private void run() {
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************\n");
		loadFile();
		while(true) {
			displayMenu();
			System.out.print("메뉴선택 => ");
			String menu = scan.nextLine();
			System.out.println();
			switch(menu) {
				case "1":
					checkIn();
					break;
				case "2":
					checkOut();
					break;
				case "3":
					roomStatus();
					break;
				case "4":
					saveFile();
					System.out.println("**************************");
					System.out.println("호텔 문을 닫았습니다.");
					System.out.println("**************************");
					scan.close();
					return;
				default:
					System.out.println("없는 메뉴입니다.");
			}
			
		}
	}
	
	private void checkIn() {
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		String roomNum = scan.nextLine();
		System.out.println();
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 => ");
		String name = scan.nextLine();
		if(roomInfo.get(roomNum) != null) {
			System.out.println(roomNum + "방에는 이미 사람이 있습니다.");
			System.out.println();
			return;
		}
		roomInfo.put(roomNum,name);
		System.out.println("체크인 되었습니다.");
		System.out.println();
	}
	
	private void roomStatus() {
		for(Entry<String,String> entry : roomInfo.entrySet()) {
			System.out.println("방번호 : " + entry.getKey() + ", 투숙객 : "
					+ entry.getValue());
		}
		System.out.println();
	}
	
	private void checkOut() {
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		String roomNum = scan.nextLine();
		if(roomInfo.remove(roomNum) == null) {
			System.out.println(roomNum + "방에는 체크인한 사람이 없습니다.");
			System.out.println();
			return;
		}
		System.out.println("체크아웃 되었습니다.");
		System.out.println();
	}
	
	private void displayMenu() {
		System.out.println("*******************************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인\t2.체크아웃\t3.객실상태\t4.업무종료");
		System.out.println("*******************************************");
	}
	
	private void loadFile() {
		System.out.println("저장된 데이터를 불러옵니다.");
		System.out.println();
		try(ObjectInputStream loadFile = new ObjectInputStream(
											new BufferedInputStream(
												new FileInputStream(
													"d:/D_Other/hotel.bin")))) {
			
			Object obj = null; 
			if((obj = loadFile.readObject()) != null) {
				roomInfo = (HashMap<String, String>)obj;
			}
			
			System.out.println("로드가 완료되었습니다.");
			System.out.println();
			
		} catch(FileNotFoundException e) {
			System.out.println("저장된 파일이 없습니다.");
			System.out.println("현재 프로그램부터 저장을 시작합니다.");
			System.out.println();
		} catch(IOException e) { } 
		catch (ClassNotFoundException e) { } 
			
	}
	
	private void saveFile() {
		System.out.println("데이터를 저장합니다.");
		System.out.println();
		try(ObjectOutputStream saveFile = new ObjectOutputStream(
											new BufferedOutputStream(
												new FileOutputStream(
													"d:/D_Other/hotel.bin")))) {
			
			if(!roomInfo.isEmpty()) {
				saveFile.writeObject(roomInfo);
			}
			
		} catch(FileNotFoundException e) { }
		catch(IOException e) { } 
		
	}
}
