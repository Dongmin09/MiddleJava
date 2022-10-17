package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * arr 배열 안의 변경하고 싶은 값의 인덱스 번호를 입력받아, 그 값을 1000으로 변경해보자 
 * 예) 인덱스: 3
 * 		{10,20,30,1000,3,60,-3} 이런식
 */
import javax.swing.JOptionPane;

public class ArrayTest07 {
	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 50, 3, 60, -3 };

		int choice = Integer.parseInt(JOptionPane.showInputDialog("바꾸고 싶은 배열의 인덱스 번호를 입력하세요"));

		arr[choice] = 1000;

		System.out.println(Arrays.toString(arr));

	}
}
