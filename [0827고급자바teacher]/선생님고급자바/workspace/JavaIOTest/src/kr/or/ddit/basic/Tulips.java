package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Tulips {
	public static void main(String[] args) {

		FileInputStream fr = null;
		FileOutputStream fw = null;
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		long startTime = System.currentTimeMillis();

		try {
			fr = new FileInputStream("C:\\xampp\\htdocs\\jsstudy\\images\\myroze5.jpg");
			fw = new FileOutputStream("d:/D_Other/복사본_myroze5.jpg");
			
			bis = new BufferedInputStream(fr);
			bos = new BufferedOutputStream(fw);
			
			int data = 0;

			while ((data = bis.read()) != -1) {
				bos.write(data);
			}
			System.out.println("복사완료!");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("경과 시간(ms): " + (endTime - startTime));
	}
}
