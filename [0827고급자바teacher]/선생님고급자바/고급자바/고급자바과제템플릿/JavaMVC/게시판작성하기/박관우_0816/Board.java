package work;

import java.util.*;

public class Board {
	private Scanner scan = new Scanner(System.in);
	private IBoardService bService;

	public Board() {
		bService = new BoardService();
	}

	/**
	 * 게시판을 출력하는 메서드
	 */
	public void displayMenu() {
		displayBoardAll();
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 게시글 작성");
		System.out.println("  2. 게시글 수정");
		System.out.println("  3. 게시글 삭제");
		System.out.println("  4. 게시글 검색");
		System.out.println("  5. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}

	/**
	 * 프로그램 시작메서드
	 */
	public void start() {
		int choice;
		do {
			displayMenu();
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				insertBoard();
				break;
			case 2:
				updateBoard();
				break;
			case 3:
				deleteBoard();
				break;
			case 4:
				searchBoard();
				break;
			case 5:
				System.out.println("종료합니다.");
				break;
			default:
				System.out.println("잘못들었습니다?");
			}
		} while (choice != 5);
	}

	/**
	 * 검색 메서드
	 */
	private void searchBoard() {
		scan.nextLine();
		System.out.println();
		System.out.println("검색할 게시글의 제목을 입력하세요.");
		System.out.print("게시글 제목 >> ");
		String search = scan.nextLine().trim();
		List<BoardVO> bList = bService.searchBoard(search);
		System.out.println();
		System.out.println("--------------------------------------------------");
		System.out.println("글번호\t제목\t글쓴이\t작성일자\t\t내용");
		System.out.println("--------------------------------------------------");
		if (bList.size() == 0) {
			System.out.println("검색된 게시글이 없습니다.");
		} else {
			for (BoardVO vo : bList) {
				System.out.println(vo.getBdNo() + "\t" + vo.getBdTitle() + "\t" + vo.getBdWriter() + "\t"
						+ vo.getBdDate() + "\t" + vo.getBdContent());
			}
			System.out.println("--------------------------------------------------");
		}
	}

	/**
	 * 게시글 출력하는 메서드
	 */
	private void displayBoardAll() {
		System.out.println();
		System.out.println("--------------------------------------------------");
		System.out.println("글번호\t제목\t글쓴이\t작성일자\t\t내용");
		System.out.println("--------------------------------------------------");
		List<BoardVO> bList = bService.bList();
		if (bList.size() == 0) {
			System.out.println("출력할 회원정보가 없습니다.");
		} else {
			for (BoardVO vo : bList) {
				System.out.println(vo.getBdNo() + "\t" + vo.getBdTitle() + "\t" + vo.getBdWriter() + "\t"
						+ vo.getBdDate() + "\t" + vo.getBdContent());
			}
			System.out.println("--------------------------------------------------");

		}

	}

	/**
	 * 게시글을 삭제하기 위한 메서드
	 */
	private void deleteBoard() {
		System.out.println();
		System.out.println("삭제할 게시글 번호를 입력하세요.");
		System.out.print("게시글 번호 >> ");
		int bdNo = scan.nextInt();
		int row = bService.removeBoard(bdNo);

		if (row > 0) {
			System.out.println(bdNo + "번 게시글 삭제 성공!");
		} else {
			System.out.println(bdNo + "번 게시글 삭제 실패!");
		}

	}

	/**
	 * 게시글을 수정하기 위한 메서드
	 */
	private void updateBoard() {
		System.out.print("게시글 번호 >> ");
		int bdNo = scan.nextInt();
		System.out.print("게시글 제목 >> ");
		String bdTitle = scan.next();

		scan.nextLine(); // 입력 버퍼 비우기
		System.out.print("게시글 내용 >> ");
		String bdContent = scan.next();
		BoardVO vo = new BoardVO();
		vo.setBdTitle(bdTitle);
		vo.setBdContent(bdContent);
		vo.setBdNo(bdNo);
		int row = bService.modifyBoard(vo);
		if (row > 0) {
			System.out.println(bdNo + "게시글 수정 성공!");
		} else {
			System.out.println(bdNo + "게시글 수정 실패!");
		}
	}

	/**
	 * 게시글을 추가하는 메서드
	 */
	private void insertBoard() {
		System.out.print("제목 >> ");
		String bdTitle = scan.next();

		System.out.print("작성자 >> ");
		String bdWriter = scan.next();

		scan.nextLine(); // 입력 버퍼 비우기
		System.out.print("내용 >> ");
		String bdContent = scan.nextLine();

		BoardVO vo = new BoardVO();
		vo.setBdTitle(bdTitle);
		vo.setBdWriter(bdWriter);
		vo.setBdContent(bdContent);
		int row = bService.registerBoard(vo);
		if (row > 0) {
			System.out.println("\"" + bdTitle + "\"" + "글쓰기 등록 성공!");
		} else {
			System.out.println("\"" + bdTitle + "\"" + "글쓰기 등록 실패!");
		}
	}

	public static void main(String[] args) {
		Board bObj = new Board();
		bObj.start();
	}
}
