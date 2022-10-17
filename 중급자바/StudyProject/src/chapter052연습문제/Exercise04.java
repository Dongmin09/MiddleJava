package chapter052연습문제;

public class Exercise04 {
	public static void main(String[] args) {
		int max = 0;
	//	int max = Integer.MIN_VALUE; 최소값지정
	//	int min = Integer.MAX_VALUE;  최대값 지정
		
		int[] array = {-1, 21, 1, 6, 5, 3, 8, 10};
		int min = array[0];
		
		
		for (int i = 0; i < array.length; i++) {
			if (max < array[i]) {

				max = array[i];
			}

		}
		
		for(int i=0; i< array.length; i++) {
			if (min > array[i]) {
				
				
				min = array[i];
			}
			
		}

		System.out.println("max : " + max);
		System.out.println("min : " + min);
	}
}
