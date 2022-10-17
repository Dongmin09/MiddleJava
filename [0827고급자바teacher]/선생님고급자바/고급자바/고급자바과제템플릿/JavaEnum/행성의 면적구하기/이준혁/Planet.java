
public class Planet {
	public static void main(String[] args) {
		System.out.println("get을 이용한 방식");
		enumPlanet murcury = enumPlanet.valueOf("수성"); 
		System.out.println("수성의 면적 => "+ murcury.getEnumPlanetAraa() +"km²");
		enumPlanet venus = enumPlanet.valueOf("금성"); 
		System.out.println("금성의 면적 => "+venus.getEnumPlanetAraa() +"km²");
		enumPlanet earth = enumPlanet.valueOf("지구"); 
		System.out.println("지구의 면적 => "+ earth.getEnumPlanetAraa() +"km²");
		enumPlanet mars = enumPlanet.valueOf("화성"); 
		System.out.println("화성의 면적 => "+ mars.getEnumPlanetAraa() +"km²");
		enumPlanet jupiter = enumPlanet.valueOf("목성"); 
		System.out.println("목성의 면적 => "+ jupiter.getEnumPlanetAraa() +"km²");
		enumPlanet saturn = enumPlanet.valueOf("토성"); 
		System.out.println("토성의 면적 => "+  saturn.getEnumPlanetAraa()  +"km²");
		enumPlanet uranus = enumPlanet.valueOf("천왕성"); 
		System.out.println("천왕성의 면적 => "+ uranus.getEnumPlanetAraa() +"km²");
		enumPlanet neptune = enumPlanet.valueOf("해왕성"); 
		System.out.println("해왕성의 면적 => "+  neptune.getEnumPlanetAraa()  +"km²");
		System.out.println("======================================");
		System.out.println("foreach를 이용한 방식");
		enumPlanet[] enumArr = enumPlanet.values();
		for(int i = 0; i<enumArr.length;i++) {
			System.out.println(enumArr[i].name()+" : "+enumArr[i].getEnumPlanetAraa()+"km²");
		}
	}
	public enum enumPlanet {
		수성(2439), 
		금성(6052), 
		지구(6371), 
		화성(3390), 
		목성(69911), 
		토성(58232), 
		천왕성(25362), 
		해왕성(24622);
		
		private long enumPlanetRaduis;
		
		enumPlanet(long enumPlanetRaduis) {
			this.enumPlanetRaduis = enumPlanetRaduis;
		}

		public long getEnumPlanetAraa() {
			return (long) (enumPlanetRaduis*enumPlanetRaduis*4*Math.PI);
		}
	}
}

