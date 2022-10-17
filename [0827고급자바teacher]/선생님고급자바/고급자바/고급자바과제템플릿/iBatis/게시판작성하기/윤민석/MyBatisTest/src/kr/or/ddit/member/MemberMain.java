package kr.or.ddit.member;

import java.util.*;

import kr.or.ddit.member.service.*;
import kr.or.ddit.member.vo.*;


/*
 
	회원을 관리하는 프로그램을 작성하는데 
	아래의 메뉴를 모두 구현하시오. (CRUD기능 구현하기)
	(DB의 MYMEMBER테이블을 이용하여 작업한다.)
	
	* 자료 삭제는 회원ID를 입력 받아서 삭제한다.
	
	예시메뉴)
	----------------------
		== 작업 선택 ==
		1. 자료 입력			---> insert
		2. 자료 삭제			---> delete
		3. 자료 수정			---> update
		4. 전체 자료 출력		---> select
		5. 작업 끝.

	----------------------

	   
회원관리 프로그램 테이블 생성 스크립트 
create table mymember(
    mem_id varchar2(8) not null,  -- 회원ID
    mem_name varchar2(100) not null, -- 이름
    mem_tel varchar2(50) not null, -- 전화번호
    mem_addr varchar2(128)    -- 주소
);

 */
public class MemberMain {
	private Scanner scan = new Scanner(System.in); 
	private IMemberService mService;
	
	public MemberMain() {
		mService = MemberServiceImpl.getInstance();
	}
	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 자료 입력");
		System.out.println("  2. 자료 삭제");
		System.out.println("  3. 자료 수정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 자료 검색");
		System.out.println("  6. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}
	
	/**
	 * 프로그램 시작메서드
	 */
	public void start() {
		int choice;
		do{
			displayMenu(); //메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch(choice) {
				case 1 :  // 자료 입력
					insertMember();
					break;
				case 2 :  // 자료 삭제
					deleteMember();
					break;
				case 3 :  // 자료 수정
					updateMember();
					break;
				case 4 :  // 전체 자료 출력
					displayMemberAll();
					break;
				case 5 : // 자료 검색
					searchMember();
					break;
				case 6 :  // 작업 끝
					System.out.println("작업을 마칩니다.");
					break;
				default :
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while(choice!=6);
	}
	
	/**
	 * 회원정보 검색 메서드
	 */
	private void searchMember() {
	/*
	   검색할 회원ID, 회원이름, 전화번호, 주소등을 입력하면 입력한 정보만 사용하여
	   검색하는 기능을 구현하시오.
	   주소는 입력한 값이 포함만 되어도 검색 되도록 한다.
	   입력을 하지 않을 자료는 엔터키로 다음 입력으로 넘긴다.
	 */
		scan.nextLine(); // 입력 버퍼 비우기
		System.out.println();
		System.out.println("검색할 회원 정보를 입력하세요.");
		System.out.print("회원 ID >> ");
		String memId = scan.nextLine().trim();
		
		System.out.print("회원 이름 >> ");
		String memName = scan.nextLine().trim();
		
		System.out.print("회원 전화번호 >> ");
		String memTel = scan.nextLine().trim();
		
		System.out.print("회원 주소 >> ");
		String memAddr = scan.nextLine().trim();
		
		MemberVO vo = new MemberVO();
		vo.setMemId(memId);
		vo.setMemName(memName);
		vo.setMemTel(memTel);
		vo.setMemAddr(memAddr);
		List<MemberVO> mList = mService.searchMemberList(vo);
		System.out.println();
		System.out.println("--------------------------------------");
		System.out.println("ID\t이 름\t전화번호\t\t주  소");
		System.out.println("--------------------------------------");
		if(mList.size() == 0) {
			System.out.println("검색된 회원정보가 없습니다.");
		} else {
			for (MemberVO vo2 : mList) {
				System.out.println(vo2.getMemId() + "\t" + vo2.getMemName() + "\t"
						+ vo2.getMemTel() + "\t" + vo2.getMemAddr());
			}			
			System.out.println("--------------------------------------");
			System.out.println("검색 끝.");
		}
	}
	
	/**
	 * 전체 회원 정보를 출력하는 메서드
	 */
	private void displayMemberAll() {
		System.out.println();
		System.out.println("--------------------------------------");
		System.out.println("ID\t이 름\t전화번호\t\t주  소");
		System.out.println("--------------------------------------");
		List<MemberVO> mList = mService.getAllMemberList();
		if(mList.size() == 0) {
			System.out.println("출력할 회원정보가 없습니다.");
		} else {
			for (MemberVO vo : mList) {
				System.out.println(vo.getMemId() + "\t" + vo.getMemName() + "\t"
						+ vo.getMemTel() + "\t" + vo.getMemAddr());
			}			
			System.out.println("--------------------------------------");
			System.out.println("출력  끝.");
		}
		
	}
	/**
	 * 회원정보를 삭제하기 위한 메서드
	 */
	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요.");
		System.out.print("회원 ID >> ");
		String memId = scan.next();
		int row = mService.removeMember(memId);
		
		if(row > 0) {
			System.out.println(memId + "회원 삭제 성공!");
		} else {
			System.out.println(memId + "회원 삭제 실패!");
		}
		
	}
	/**
	 * 회원정보를 수정하기 위한 메서드
	 */
	private void updateMember() {
		boolean chk = false;
		String memId = "";
		do {
			System.out.println();
			System.out.println("수정할 회원 정보를 입력하세요.");
			System.out.print("회원 ID >> ");
			memId = scan.next();
			
			chk = checkMember(memId);
			if(chk == false) {
				System.out.println("회원 ID가 " 
			+ memId + "인 회원은 존재하지 않습니다.");
				System.out.println("다시 입력해 주세요.");
			}
		} while(chk == false);
		System.out.print("회원 이름 >> ");
		String memName = scan.next();
		
		System.out.print("회원 전화번호 >> ");
		String memTel = scan.next();
		
		scan.nextLine(); // 입력 버퍼 비우기
		System.out.print("회원 주소 >> ");
		String memAddr = scan.nextLine();
		
		MemberVO vo = new MemberVO();
		vo.setMemName(memName);
		vo.setMemTel(memTel);
		vo.setMemAddr(memAddr);
		vo.setMemId(memId);
		int row = mService.modifyMember(vo);
		if(row > 0) {
			System.out.println(memId + "회원 수정 성공!");
		} else {
			System.out.println(memId + "회원 수정 실패!");
		}
	}
	/**
	 * 회원정보를 추가하는 메서드
	 */
	private void insertMember() {
		boolean chk = false;
		String memId = "";
		do {
			System.out.println();
			System.out.println("추가할 회원 정보를 입력하세요.");
			System.out.print("회원 ID >> ");
			memId = scan.next();
			
			chk = checkMember(memId);
			if(chk == true) {
				System.out.println("회원 ID가 " 
			+ memId + "인 회원은 이미 존재합니다.");
				System.out.println("다시 입력해 주세요.");
			}
			
		} while(chk == true);
		System.out.print("회원 이름 >> ");
		String memName = scan.next();
		
		System.out.print("회원 전화번호 >> ");
		String memTel = scan.next();
		
		scan.nextLine(); // 입력 버퍼 비우기
		System.out.print("회원 주소 >> ");
		String memAddr = scan.nextLine();
		
		MemberVO vo = new MemberVO();
		vo.setMemId(memId);
		vo.setMemName(memName);
		vo.setMemTel(memTel);
		vo.setMemAddr(memAddr);
		int row = mService.registerMember(vo);
		if(row > 0) {
			System.out.println(memId + "회원 등록 성공!");
		} else {
			System.out.println(memId + "회원 등록 실패!");
		}
	}
	/**
	 * 회원ID를 이용하여 회원이 존재하는지 알려주는 메서드
	 * @param memId
	 * @return 회원이 존재하면 true, 없으면 false 리턴함.
	 */
	private boolean checkMember(String memId) {
		boolean chk = mService.checkMember(memId);
		return chk;
	}

	public static void main(String[] args) {
		MemberMain memObj = new MemberMain();
		memObj.start();
	}
}
