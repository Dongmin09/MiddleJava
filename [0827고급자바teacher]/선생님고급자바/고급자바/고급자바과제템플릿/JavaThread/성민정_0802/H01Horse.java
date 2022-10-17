package kr.or.ddit.basic.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

	
public class H01Horse {
	static String strRank = "";
	public static void main(String[] args) {
		List<Horse> list = new ArrayList<Horse>();
		
		list.add(new Horse("1번말"));
		list.add(new Horse("2번말"));
		list.add(new Horse("3번말"));
		list.add(new Horse("4번말"));
		list.add(new Horse("5번말"));
		list.add(new Horse("6번말"));
		list.add(new Horse("7번말"));
		list.add(new Horse("8번말"));
		list.add(new Horse("9번말"));
		list.add(new Horse("10번말"));
		
		for(Horse hs : list) {
			hs.start();
		}
		for(Horse hs : list) {
			try {
				hs.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("순위 : " + strRank);


		
	}
}
class Horse extends Thread implements Comparable<Horse> {
	private String horseName;
	private int rank = 1;

	public Horse(String horseName) {
		this.horseName = horseName;
	}
	
	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public void run() {
			for(int i=1; i<=10;i++) {
			System.out.println(horseName);
			
			try {
				Thread.sleep((int)(Math.random() + 501 + 100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println( horseName + "완");
		H01Horse.strRank +=  horseName + " ";
		
	}
	@Override
	public int compareTo(Horse o) {
		return String.valueOf(this.getRank()).compareTo(String.valueOf(o.getRank()));
	}
}










