package study01;

public class TakeTrans {
	public static void main(String[] args) {
		
		Bus james = new Bus("james",5000);  // 클래스 객체 생성
		Subway bit = new Subway("bit", 10000);  // 클래스 객체 생성
				
		// 버스를 타는 제임스
		
		// 클래스 생성자는 알겟는데 메소드 부분을 모르겟시와요
		Bus bus100 = new Bus(100); // 100번 버스
		james.takeBus(bus100);
		james.showInfo();
		bus100.showInfo();
		
		// 지하철을 타는 빛
		Subway subwaygreen = new Subway(2); // 2호선
		bit.takeSubway(subwaygreen);
		bit.showInfo();
		subwaygreen.showInfo();
		
		
		
		
	}
	
}
