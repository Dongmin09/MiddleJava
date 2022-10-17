package study01;

public class Bus {

	private int ligne;
	private int passengerNumber;
	private int busMomey;
	
	public Bus(int ligne, int passengerNumber, int busMomey) {

		this.ligne = ligne;
		this.passengerNumber = passengerNumber;
		this.busMomey = busMomey;
	}

	public Bus(String studentName , int studentMoney) {
		
	}
	
	public Bus(int ligne) {
		
	}

	public void takeBus() {
		
		busMomey += busMomey;
		passengerNumber++;
		
	}
	
	public void showInfo() {
		System.out.println("버스 " + ligne + "의 승객은" + passengerNumber +
				"명이고, " + "버스 수입은" + busMomey + "원 입니다.");
	}
	
}
