package kr.or.ddit.basic;

public class T15SyncThreadTest {
	public static void main(String[] args) {
		ShareObject sObj = new ShareObject();
		
		WorkThread th1 = new WorkThread("1번스레드", sObj);
		WorkThread th2 = new WorkThread("2번스레드", sObj);
		
		th1.start();
		th2.start();
	}
}


// 공통으로 사용할 객체
//class ShareObject {
//	private int sum =0;
//	
//	// 동기화하는 방법1 : 메서드 자체에 동기화 설정 synchronized를 붙이기
//	//synchronized public void add() {  //  1번째 방법
//	public void add() {
//		
//		for(int i=0; i<1000000000; i++) {} // 동기화 전까지 시간 때우기용
//		
//				
//		
//			int n = sum;
//			
//			n+= 10;
//			
//			sum = n;
//			
//			System.out.println(Thread.currentThread().getName() + " 합계 : " + sum);
//			
//		}
//	}
	
class ShareObject {
	private int sum =0;
	
	// 동기화하는 방법2 : 동기화 블럭으로 설정하기
	public void add() {
	//	synchronized (this) {
		for(int i=0; i<1000000000; i++) {} // 동기화 전까지 시간 때우기용
		
				
		
			int n = sum;
			
			n+= 10;
			
			sum = n;
			
			System.out.println(Thread.currentThread().getName() + " 합계 : " + sum);
		//	}
		}
	}


	
// 작업을 수행하는 스레드 클래스
class WorkThread extends Thread{
	private ShareObject sObj;
	
	public WorkThread(String name, ShareObject sObj) {
		super(name);
		this.sObj = sObj;
	}
	
	// run 에 동기화 처리하기 방법 3
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			synchronized (sObj) {
				
			sObj.add();
			}
		}
	}
	
}
	
	
	
