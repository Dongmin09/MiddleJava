package chapter042연습문제;

public class example2 {
	public static void main(String[] args) {

		// for문을 사용하여 1~100까지의 정수 중 3의 배수 총합 구하는 코드작성
		// 괄호의 들여쓰기를 잘해야함 나중에 햇갈릴 수 있음. 컨트롤+시프트+f 정렬 키
		int sum = 0;
		int a;

		for (a = 1; a <= 100; a++) {
			if (a % 3 == 0) {
				sum += a;

				System.out.println(a);
			}
		}

		System.out.println("총합은 :" + sum);
	}
}
