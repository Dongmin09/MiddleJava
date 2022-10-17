package chapter052연습문제;

public class Exercise05 {
public static void main(String[] args) {
	
	int[][] array = {
			
			{95, 86},
			{83, 92, 96},
			{78, 83, 93, 87, 88}			
	};
	
	
	
	int sum =0;
	double avg = 0.0;
	int count = 0;
	// i<array.length;  같은 말은 array.3 이렇게적어도 된다.
	for(int i =0; i<array.length; i++) {
		 for (int j=0; j<array[i].length; j++) {
			 
			 sum += array[i][j];
			 count++;
		 }
	}
	
	
	avg =  sum/ (double) count;
	
	
	System.out.println("sum : " + sum);
	System.out.println("avg :" + avg);
	
	
	
}
}

// 다중배열의 경우 중첩 포문을 사용.
// 