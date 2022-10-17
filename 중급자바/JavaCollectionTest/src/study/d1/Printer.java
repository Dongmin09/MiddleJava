package study.d1;

import java.io.IOException;
import java.lang.reflect.Method;



class Printer{
	public static void main(String[] args) {
		
		Printer1<Integer> pr1 = new Printer1<>();
		Printer1<String> pr2 = new Printer1<>();
		
		pr1.setVal(1);
		pr2.setVal("Hellow");	
		
		System.out.println();
		
		System.out.println(pr1);
		System.out.println(pr2);
		
	}
	

}


class Printer1<T> {
	private T val;

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}

 }


