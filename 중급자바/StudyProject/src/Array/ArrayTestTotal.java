package Array;

/*
 * 56,38,12,36,41,27,26,32,59,16,18,28,21,17 = 나이 각 세대 수별 인원수 체크 출력
 * 
 * 실행결과 
 * 10대 인원수 = 3명
 * 20대 인원수 = 4명
 * 30대 인원수 = ?
 * 40대 인원수 = ?
 * 50대 인원수 = ?
 */
public class ArrayTestTotal {
	public static void main(String[] args) {

		int[] age = { 65, 38, 12, 36, 41, 27, 26, 32, 59, 16, 18, 28, 21, 17 };

		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int num4 = 0;
		int num5 = 0;
		int num6 = 0;
		for (int i = 0; i < age.length; i++) {
			int age1 = age[i] / 10;

			if (age1 == 1) {
				num1++;

			} else if (age1 == 2) {
				num2++;

			} else if (age1 == 3) {
				num3++;

			} else if (age1 == 4) {
				num4++;

			} else if (age1 == 5) {
				num5++;

			} else {
				num6++;

			}
		}
		System.out.println("10대 인원수 = " + num1 + "명");
		System.out.println("20대 인원수 = " + num2 + "명");
		System.out.println("30대 인원수 = " + num3 + "명");
		System.out.println("40대 인원수 = " + num4 + "명");
		System.out.println("50대 인원수 = " + num5 + "명");
		System.out.println("60대 인원수 = " + num6 + "명");
	}
}
