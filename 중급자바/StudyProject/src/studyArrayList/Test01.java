package studyArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> names = new ArrayList<>();
		
		for(int i =0; i<5;  i++) {
			System.out.println("이름을 입력하세요");
			String name = scanner.nextLine();
			names.add(name);
		}
		// substr에서 이건 몰라서 쳐봣습니다.
		
		ArrayList<String> nameList = new ArrayList<>();
		for(int i=0; i<5; i++) {
			String firstName = names.get(i).substring(0,1);
			if(firstName.equals("김")==true) {
				nameList.add(names.get(i));
			}
		}
		System.out.println(nameList.toString());
	}
}
