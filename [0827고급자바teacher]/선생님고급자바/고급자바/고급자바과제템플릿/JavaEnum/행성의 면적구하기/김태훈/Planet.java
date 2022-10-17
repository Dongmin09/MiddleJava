package kr.or.ddit.basic.homework;

public class Planet {

	public enum PlanetRadius { 
    	수성(2439),
    	금성(6052),
    	지구(6371), 
    	화성(3390), 
    	목성(69911), 
    	토성(58232), 
    	천왕성(25362), 
    	해왕성(24622);
    	
       	private int radius;
    	
    	private PlanetRadius(int data) {
    		radius = data;
    	}
    	
    	public int getRadius() {
    		return radius;
    	}
    }
	
	public static void main(String[] args) {
		
		PlanetRadius[] enumRadius = PlanetRadius.values();
		for (int i = 0; i < enumRadius.length; i++) {
    		System.out.printf("%s : %,.2f\n", enumRadius[i].name() 
    				,4 * Math.PI * enumRadius[i].getRadius() 
    				 * enumRadius[i].getRadius());	
	    }
		
//		double[] planetArea = new double[10];
//		for (int i = 0; i < enumRadius.length; i++) {
//			planetArea[i] = 4 * Math.PI * enumRadius[i].getRadius()
//					      * enumRadius[i].getRadius(); 
//			System.out.println(enumRadius[i].name() + 
//					           " : " + planetArea[i]);
//		}
	}
}


	