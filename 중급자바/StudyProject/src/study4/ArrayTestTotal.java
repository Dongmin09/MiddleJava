package study4;

public class ArrayTestTotal {
	public static void main(String[] args) {
		int[] arr = {56, 38, 12, 36, 41, 27, 26, 32, 59, 16, 18, 28, 21, 17};
		
		int a;
		// 카운트변수... 5개를 줘야하나
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		
		
		for(int i=0; i<arr.length; i++) {
			// 10~20을 1로 표현하기 위해
			a = arr[i]/10;
			
			if(a==1) {
				count1++;
			} else if(a==2) {
				count2++;
			} else if(a==3) {
				count3++;
			} else if(a==4) {
				count4++;
			} else if(a==5) {
				count5++;
			} else {
				return;
			}
		}
		System.out.println("10대 인원수: " + count1 + "명");
		System.out.println("20대 인원수: " + count2 + "명");
		System.out.println("30대 인원수: " + count3 + "명");
		System.out.println("40대 인원수: " + count4 + "명");
		System.out.println("50대 인원수: " + count5 + "명");
		
	}
}
