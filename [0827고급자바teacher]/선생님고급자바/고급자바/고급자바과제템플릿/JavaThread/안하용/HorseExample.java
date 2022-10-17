package kr.or.ddit.basic.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HorseExample {
	
	public static final int MAX_RAIL = 40;
	
	public static void main(String[] args) {
		int maxSection = 50;
		int rank = 1;
		List<HorseRacing> list = new ArrayList<>();
		
		for(int i=1; i<=10; i++) {
			list.add(new HorseRacing(i + "번말"));
		}
		
		for(HorseRacing hr : list) {
			hr.start();
		}
		
		for(int i=1; i<=maxSection; i++) {
			
			if(rank > list.size()) {		// 모든말의 순위가 매겨지면 경기 종료
				break;
			}
			
			System.out.println("------------------------- " + i + "/50구간 -------------------------\n");
			for(HorseRacing hr : list) {
				if(hr.isFinish() && hr.getRank() == 0) {		
					hr.setRank(rank++);
				}
				System.out.print(hr.getHorseName() + " : ");
				for(int j=0; j<hr.getLocation()-1; j++) {		//현재위치 전까지 -출력
					System.out.print("-");
				}
				System.out.print(">");							//현재위치 출력
				for(int k=0; k<MAX_RAIL-hr.getLocation(); k++) {	// 남은 rail 출력	
					System.out.print("-");
				}
				System.out.println("\n");
			}
			
			try {
				// 모든 경기가 끝날 수 있도록 SLEEP의 80%를 경기구간으로 잡음
				int sleepTime = (int)(HorseRacing.SLEEP * 0.8);
				Thread.sleep(sleepTime*MAX_RAIL/maxSection);
			} catch (InterruptedException e) { }
		}
		
		System.out.println("\n------------------------- 경기결과 -------------------------\n");
		Collections.sort(list);
		for(HorseRacing hr : list) {
			System.out.println(hr.getHorseName() + ": " + hr.getRank() + "등");
		}
		
	}
	
}

class HorseRacing extends Thread implements Comparable<HorseRacing>{

	public static final int SLEEP = 300;
	
	private Horse horse;
	private int location;
	private boolean finish;
	
	public HorseRacing(String name) {
		horse = new Horse(name);
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				if(location < HorseExample.MAX_RAIL) {
					location++;
				} else {
					finish = true;
					return;
				}
				
				// 0 ~ 300사이 랜덤 sleep
				Thread.sleep((int)(Math.random()*SLEEP));
			} catch (InterruptedException e) {}
		}
	}

	public int getLocation() {
		return location;
	}

	public Horse getHorse() {
		return horse;
	}

	public void setHorse(Horse horse) {
		this.horse = horse;
	}
	
	public void setRank(int rank) {
		this.horse.setRank(rank);
	}
	
	public int getRank() {
		return this.horse.getRank();
	}
	
	public boolean isFinish() {
		return finish;
	}

	public String getHorseName() {
		return horse.getName();
	}
	
	@Override
	public int compareTo(HorseRacing hr) {
		return this.horse.compareTo(hr.horse);
	}
}


class Horse implements Comparable<Horse>{
	private String name;
	private int rank;
	
	public Horse(String name) {
		this.name = name;
	}

	public String getName() {
		return String.format("%-4s", name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	@Override
	public int compareTo(Horse hs) {
		return new Integer(rank).compareTo(hs.rank);
	}

}
