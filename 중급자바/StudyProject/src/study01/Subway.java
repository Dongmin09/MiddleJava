package study01;

public class Subway {
	
	private int ligne;
	private int passengerNumber;
	private int subwayMoney;
	
  public Subway(int ligne) {

		this.ligne = ligne;
	}

	public Subway(String studentName , int studentMoney) {

}

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public int getPassengerNumber() {
		return passengerNumber;
	}

	public void setPassengerNumber(int passengerNumber) {
		this.passengerNumber = passengerNumber;
	}

	public int getSubwayMomey() {
		return subwayMoney;
	}

	public void setSubwayMomey(int subwayMomey) {
		this.subwayMoney = subwayMomey;
	}
	
	public void takeSubway(int ligne) {
		
		subwayMoney += 1500;
		passengerNumber++;
		
	}
	
	public void showInfo() {
		System.out.println("지하철 " + ligne + "의 승객은" + passengerNumber +
				"명이고, " + "지하철 수입은" + subwayMoney + "원 입니다.");
	}
	
	
}
