package border;

import java.util.List;
import java.util.Scanner;

import border.service.BorderService;
import border.service.BorderServiceImpl;
import border.vo.BorderVO;

public class BorderMain {
	private Scanner scan = new Scanner(System.in);
	private BorderService borService;

	public BorderMain() {
		borService = new BorderServiceImpl();
	}

	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 전체목록 출력");
		System.out.println("  2. 글 작성");
		System.out.println("  3. 수정");
		System.out.println("  4. 삭제");
		System.out.println("  5. 검색.");
		System.out.println("  6. 작업 끝");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}

	public void start() {
		int choice;
		do {
			displayMenu(); // 메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch (choice) {
			case 1: // 전체목록 출력
				displayBorderAll();
				break;
			case 2: // 글 작성
				insertBorder();
				break;
			case 3: // 수정
				modifyBorder();
				break;
			case 4: // 삭제
				deleteBorder();
				break;
			case 5: // 검색
				searchBorder();
				break;
			case 6:
				System.out.println("작업을 마칩니다.");
				return;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 5);
	}

	private void searchBorder() {
		scan.nextLine();
		System.out.println();
		System.out.println("검색할 게시판 정보를 입력하세요.");
		System.out.println("글 번호 >>");
		String borNo = scan.nextLine().trim();
		
		System.out.println("제목 >>");
		String borTit = scan.nextLine();
		
		System.out.println("작성자 >>");
		String borWrit = scan.nextLine();
		
		System.out.println("내용 >>");
		String borCon = scan.nextLine();
	
		BorderVO mv = new BorderVO();
		mv.setBorCon(borCon);
		mv.setBorNo(borNo);
		mv.setBorTit(borTit);
		mv.setBorWrit(borWrit);
		
		
		List<BorderVO> memList = borService.searchBorderList(mv);
		
		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println(" 글번호  \t 제목    \t작성자 \t\t내용");
		System.out.println("------------------------------------------");
		
		if(memList.size() == 0) {
			System.out.println(" 검색된 회원정보가 없습니다.");
		}else {
			for (BorderVO mv2 : memList) {
				System.out.println(mv2.getBorNo() + "\t" + mv2.getBorTit()+ "\t" + mv2.getBorWrit()+"\t\t" + mv2.getBorCon());
			
			}
		}
		
		System.out.println(" ==================================== ");
		System.out.println("검색 끝");
		
	}

	private void deleteBorder() {
		System.out.println();
		System.out.println("삭제할 게시판 번호를 입력하세요");
		System.out.print("번호 >> ");
		String borNo = scan.next();

		int cnt = borService.removeBoard(borNo);
		if (cnt > 0) {
			System.out.println(borNo + "번 게시판 삭제 성공!");
		} else {
			System.out.println(borNo + "번 게시판 삭제 실패!!");
		}
	}

	private void modifyBorder() {
		boolean chk = false;
		String borNo = "";
		do {
			System.out.println();
			System.out.println("수정할 글 번호를 입력하세요.");
			System.out.print("수정할 글번호>>");
			borNo = scan.next();
			chk = checkTit(borNo);
			if (chk == false) {
				System.out.println("글 번호가 " + borNo + "존재하지 않습니다..");
				System.out.println("다시");
			}

		} while (chk == false);

		System.out.print("제목 >>");
		String borTit = scan.next();

		System.out.print("작성자>> ");
		String borWrit = scan.next();

		scan.nextLine();
		System.out.print("내용>>");
		String borCon = scan.nextLine();

		BorderVO mv = new BorderVO();
		mv.setBorNo(borNo);
		mv.setBorTit(borTit);
		mv.setBorCon(borCon);
		mv.setBorWrit(borWrit);

		int cnt = borService.modifyBorder(mv);

		if (cnt > 0) {
			System.out.println(borNo + "회원 정보 등록 성공");
		} else {
			System.out.println(borNo + "회원 정보 등록 실패");
		}

	}

	private void insertBorder() {
		String borTit = "";
		System.out.println();
		System.out.print("글제목 >>");
		borTit = scan.next();
		System.out.print("작성자 >> ");
		String borWrit = scan.next();
		scan.nextLine();
		System.out.print("내용>>");
		String borCon = scan.nextLine();
		BorderVO mv = new BorderVO();
		mv.setBorTit(borTit);
		mv.setBorCon(borCon);
		mv.setBorWrit(borWrit);
		int cnt = borService.registerBorder(mv);
		if (cnt > 0) {
			System.out.println(borTit + "회원 정보 등록 성공");
		} else {
			System.out.println(borTit + "회원 정보 등록 실패");
		}

	}

	private boolean checkTit(String borNo) {
		boolean chk = borService.checkBorder(borNo);
		return chk;
	}

	private void displayBorderAll() {
		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println(" 글번호\t제목 \t 작성자 \t\t내 용");
		System.out.println("------------------------------------------");

		List<BorderVO> memList = borService.getAllBorderList();

		if (memList.size() == 0) {
			System.out.println(" 출력할 회원정보가 없습니다.");
		} else {
			for (BorderVO mv : memList) {
				System.out.println(
						mv.getBorNo() + "\t" + mv.getBorTit() + "\t" + mv.getBorWrit() + "\t" + mv.getBorCon());

			}
		}
		System.out.println(" ==================================== ");
		System.out.println("출력끝");

	}

	public static void main(String[] args) {
		BorderMain borderMain = new BorderMain();
		borderMain.start();
	}
}
