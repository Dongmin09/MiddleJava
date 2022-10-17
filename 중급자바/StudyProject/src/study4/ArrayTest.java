package study4;

import javax.swing.JOptionPane;

public class ArrayTest {
	public static void main(String[] args) {
		
		int[] arr ={10,20,30,50,30,60,-3};
		
		int choice = Integer.parseInt(JOptionPane.showInputDialog("바꾸고 싶은 배열의 인덱스 번호를 입력하세요"));
		
		for(int i=0; i< arr.length; i++) {
			if(choice<7) {
				arr[choice] = 1000; 
				System.out.println(arr[i]);
			} else if(choice != arr[i]){
				return;
			}
			
		}
	}
}
