package kr.or.ddit.basic.Homework;

public class EnumPlanet {

	public enum Planets {
		수성(24396), 금성(6052), 지구(6371), 화성(3390), 목성(69911), 토성(58232), 천왕성(25362), 해왕성(24622);

		private double km;

		Planets(double data) {
			km = data;
		}

		public double getKm() {

			return km*km*3.14;
		}

		public void setKm(double km) {
			this.km = km;
		}

	}

	public static void main(String[] args) {

		Planets[] arr = Planets.values();
//		for (Planets planets : arr) {
//			System.out.println(planets + " : " +(4*planets.getKm()));
//		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].name() + " : " + arr[i].getKm()*4);

		}
	}

}
