package chapter042연습문제;

public class example4 {
	public static void main(String[] args) {

		/*
		 * for문을 이용하여 4x +5y =60 의 모든 해를 구해서 (x,y) 형태료 출력 x, y는 10 이하 자연수
		 */

		for (int a = 1; a <= 10; a++) {
			for (int b = 1; b <= 10; b++) {

				if ((4 * a) + (5 * b) == 60) {
					System.out.println(" (" + a + " ," +  b+ ")" );
				}
			}

		}

	}
}


/* for (int x=1; x<=10; x++) {
 * 		for(int y=1; y<=10; y++) {
 * 			int num1 = 4 *x;
 * 			int num2 = 5 *y;
 * 
 * 				if(num1 + num2 == 60) {
 * 						System.out.println(" (" + a + " ," +  b+ ")" );
 * 									}
 * 								}
 * 						}
 * 
 * 
 */
/*
 * 
 * 
 */
