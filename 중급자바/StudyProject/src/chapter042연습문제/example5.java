package chapter042연습문제;

public class example5 {
	public static void main(String[] args) {

		// for 문 사용 * 츨력코드 생성

		for (int i = 1; i < 5; i++) { // row 바깥쪽
			for (int j = 1; j <= i; j++) { // column
				System.out.print("*");

				if (j == i) {

					System.out.println();
				}
			}

		}

	}
}

/* for(int i=1; i<=4; i++) {
 * 			for(int j=1; j<=i; j++) {
 * 				System.out.print("*");
 * 					}
 * 			System.out.println("");
 * 			}
 * 
 * 
 */



