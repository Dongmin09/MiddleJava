package homeWork;

public class 행성면적 {

//	문제) 태양계 행성을 나타내는 enum Planet을 이용하여 구하시오.
//	(단, enum 객체 생성시 반지름을 이용하도록 정의하시오.) 
//
//	예) 행성의 반지름(KM):
//	수성(2439), 
//	금성(6052), 
//	지구(6371), 
//	화성(3390), 
//	목성(69911), 
//	토성(58232), 
//	천왕성(25362), 
//	해왕성(24622)

	public enum Planet {

		수성(2439), 금성(6052), 지구(6371), 화성(3390), 목성(69911), 토성(58232), 천왕성(25362), 해왕성(24622);

		private double planetArea;

		Planet(double area) {

			planetArea = area;

		}

		public double getPlanetArea() {
			return 4 * Math.PI * (planetArea * planetArea);
		}

		public void setPlanetArea(double planetArea) {
			this.planetArea = planetArea;
		}

	}

	public static void main(String[] args) {

		Planet[] pl = Planet.values();
		for (Planet pl1 : Planet.values()) {

			System.out.println(pl1 + " : " + pl1.getPlanetArea() + "km²");
		}

	}

}
