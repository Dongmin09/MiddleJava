package kr.or.ddit.basic.homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class H01Copy {
	public static void main(String[] args) {
		FileInputStream fis = null; 
		BufferedInputStream bir = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		long startTime = System.currentTimeMillis();
		try {
			fis = new FileInputStream("d:/D_Other/Tulips.jpg");
			bir = new BufferedInputStream(fis);

			int data;
			
			fos = new FileOutputStream("d:/D_Other/복사본_Tulips.jpg");
			bos = new BufferedOutputStream(fos);
			while ((data = bir.read()) != -1) {
				bos.write(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			long endTime = System.currentTimeMillis();
			try {
				bir.close();
				fos.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(endTime - startTime);
		}
	}
}
