package kr.or.ddit.basic.homework;

public class H01Enum {

	public enum Planet {
		수성(2439), 금성(6052), 지구(6371),
		화성(3390), 목성(69911), 토성(58232),
		천왕성(25362), 해왕성(24622);

		private double radius;

		Planet(double data) {
			radius = data;
		}

		public double getRadius() {
			return 4*Math.PI * radius * radius;
		}		
	}
	
	public static void main(String[] args) {
		Planet [] arr = Planet.values();
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i].name() + " : " + arr[i].getRadius());
		}	
	}
}
