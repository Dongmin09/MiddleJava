package kr.or.ddit.noticeBoard;

import java.util.List;
import java.util.Scanner;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


import kr.or.ddit.noticeBoard.service.INoticeBoardService;
import kr.or.ddit.noticeBoard.service.NoticeBoardServiceImpl;
import kr.or.ddit.noticeBoard.vo.NoticeBoardVO;
import kr.or.ddit.noticeBoard.util.JDBCUtil;

/*
 * 위의 테이블을 작성하고 게시판을 관리하는
다음 기능들을 구현하시오.

기능 구현하기 ==> 전체 목록 출력, 새글작성, 수정, 삭제, 검색 
 
------------------------------------------------------------

게시판 테이블 구조 및 시퀀스

create table jdbc_board(
    board_no number not null,  -- 번호(자동증가)
    board_title varchar2(100) not null, -- 제목
    board_writer varchar2(50) not null, -- 작성자
    board_date date not null,   -- 작성날짜
    board_content clob,     -- 내용
    constraint pk_jdbc_board primary key (board_no)
);
create sequence board_seq
    start with 1   -- 시작번호
    increment by 1; -- 증가값
		
----------------------------------------------------------

// 시퀀스의 다음 값 구하기
//  시퀀스이름.nextVal
 */

public class NoticeBoardMain {
	
	private Scanner scan = new Scanner(System.in);
	private INoticeBoardService NoticeBoardService;
	
	public NoticeBoardMain() {
		
		NoticeBoardService = new NoticeBoardServiceImpl();
	}
	
	public void displayMenu() {
		System.out.println();
		System.out.println("===============");
		System.out.println("===웰텀 투 게시판===");
		System.out.println(" 1. 전체목록 출력");
		System.out.println(" 2. 새글 작성");
		System.out.println(" 3. 내용 수정");
		System.out.println(" 4. 게시글 삭제");
		System.out.println(" 5. 게시글 검색");
		System.out.println(" 6. 작업종료");
		System.out.println("===============");
		System.out.println("원하는 작업을 선택하시오 >> ");
	}
	
	public void start() {
		int select;
		do {
			displayMenu(); // 메뉴 출력
			select = scan.nextInt(); // 메뉴 번호입력
			switch(select) {
			case 1 : // 전체목록 출력
				displayNoticeBoardAll();
				break;
			case 2 : // 새글 작성
				insertNoticeBoard();
				break;
			case 3 : // 내용 수정
				updateNoticeBoard();
				break;
			case 4 : // 게시글 삭제
				deleteNoticeBoard();
				break;
			case 5 : // 게시글 검색
				searchNoticeBoard();
				break;
			case 6 : // 작업종료
				System.out.println("작업을 마칩니다.");
				break;
			default :
				System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요.");
			}
		}while(select!=3);
	}
		
		/*
		 * 	게시글  검색 메서드
		 */
		private void searchNoticeBoard() {

			scan.nextLine(); // 입력버퍼 비우기
			System.out.println();
			System.out.println("검색할 게시글을 입력하세요");
			System.out.println("게시글제목 >> ");
			String nbTt = scan.nextLine().trim();
			
			System.out.println("게시글내용 >> ");
			String nbWt = scan.nextLine().trim();
			
			System.out.println("작성자 >> ");
			String nbCt = scan.nextLine().trim();
		
			
			NoticeBoardVO mv = new NoticeBoardVO();
			mv.setNbTt(nbTt);
			mv.setNbWt(nbWt);
			mv.setNbCt(nbCt);
		
			List<NoticeBoardVO> nbList= NoticeBoardService.searchNoticeBoardList(mv);
			System.out.println();
			System.out.println("==============================================");
			System.out.println(" 번호\t제목\t작성자\t날짜\t내용");
			System.out.println("==============================================");
			
			if(nbList.size()==0) {
				System.out.println("출력할 회원정보가 없습니다.");
			}else {
				for(NoticeBoardVO mv2 : nbList) {
					System.out.println(mv2.getNbNum()+ "\t" + mv2.getNbTt() + "\t" + mv2.getNbWt() + "\t" 
					 + mv2.getNbDate()	+ "\t" + mv2.getNbCt());
				}
			}
			
			System.out.println("=================================================");
			System.out.println("검색 끝");

			
		}
		
		// 전체 회원 정보를 출력하는 메서드
		private void displayNoticeBoardAll() {
			System.out.println();
			System.out.println("==============================================");
			System.out.println(" 번호\t제목\t작성자\t날짜\t내용");
			System.out.println("==============================================");
			

			
			List<NoticeBoardVO> nbList = NoticeBoardService.getAllNoticeBoardList();
			
			if(nbList.size()==0) {
				System.out.println("출력할 회원정보가 없습니다.");
			}else {
				for(NoticeBoardVO mv : nbList) {
					System.out.println(mv.getNbNum()+"\t"+ mv.getNbTt() + "\t" + mv.getNbWt() + "\t" + mv.getNbDate()
					+ "\t" + mv.getNbCt());
				}
			}
			
			System.out.println("=================================================");
			System.out.println("출력 끝");
		
			
		}
		
		// 게시글을 삭제할 메서드
		private void deleteNoticeBoard() {
			System.out.println();
			System.out.println("삭제할 게시글을 입력하세요");
			System.out.println("게시글 번호 >> ");
			
			int noticeNo = scan.nextInt();
			
			int cnt = NoticeBoardService.removeNoticeBoard(noticeNo);
			
			if(cnt>0) {
				System.out.println(noticeNo + "\t" + "게시글 삭제 성공!");
			}else {
				System.out.println(noticeNo + "\t" + "게시글 삭제 실패!!");
			}
		}

		private void updateNoticeBoard() {
			/*
			 *  게시글을 수정하는 메서드
			 */		
				boolean chk = false;
				
				String nbTt = "";
				
				do {
					System.out.println();
					System.out.println("수정할 게시글의 정보를 입력하세요.");
					System.out.println("게시글 제목 입력 >> ");
					
					nbTt = scan.next();
					
					chk = checkNoticeBoard(nbTt);
					
					if(chk == false) {
						System.out.println("게시글은 " + nbTt + "인 게시글은 존재하지않습니다.");
						System.out.println("다시 입력해주세요.");
					}			
				}while(chk == false);
				
				scan.nextLine();
				
				System.out.println("수정할 작성자 >> ");
				String nbWt = scan.nextLine();
				
				scan.nextLine(); // 입력된 버퍼 비우기
				System.out.println("수정 내용 >> ");
				String nbCt = scan.nextLine();
				
				NoticeBoardVO mv = new NoticeBoardVO();
				mv.setNbTt(nbTt);
				mv.setNbWt(nbWt);
				mv.setNbCt(nbCt);
					
				int cnt = NoticeBoardService.modifyNoticeBoard(mv);
				
				if(cnt >0) {
					System.out.println(nbTt + "\t" + "게시글 수정 성공!");
				} else {
					System.out.println(nbTt + "\t" + "게시글 수정 실패!!!");
				}
					
		}
		
		/*
		 *  게시글을 추가하는 메서드
		 */
		private void insertNoticeBoard() {
			
			boolean chk = false;
			
			String nbTt = "";
			
			do {
				System.out.println();
				System.out.println("추가할 게시글의 정보를 입력하세요.");
				System.out.println("게시글 제목 >> ");
				
				nbTt = scan.next();
				
				chk = checkNoticeBoard(nbTt);
				
				if(chk == true) {
					System.out.println("게시글가 " + nbTt + "인 게시글은 이미 존재합니다.");
					System.out.println("다시 입력해주세요.");
				}
				
				
			}while(chk == true);
			
			
			System.out.println("작성자 >> ");
			String nbWt = scan.next();
			
			scan.nextLine(); // 입력된 버퍼 비우기
			System.out.println("내용 >> ");
			String nbCt = scan.nextLine();
			
			NoticeBoardVO mv = new NoticeBoardVO();
			
			
			mv.setNbTt(nbTt);
			mv.setNbWt(nbWt);
			mv.setNbCt(nbCt);
			
				
			int cnt = NoticeBoardService.registerNoticeBoard(mv);
				
			if(cnt>0){
				System.out.println(nbTt + "\t"+ "게시글 추가 작업 성공!");
			}else {
				System.out.println(nbTt + "\t"+ "게시글 추가 작업 실패!!!");
			}
		}
				
		private boolean checkNoticeBoard(String nbTt) {
			
			boolean chk = NoticeBoardService.checkNoticeBoard(nbTt);
			
			return chk;

				
				

		}
		
		public static void main(String[] args) {
			NoticeBoardMain NoticeBoardObj = new NoticeBoardMain();
			NoticeBoardObj.start();
		}

	}
		
		

