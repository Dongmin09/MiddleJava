package homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageCopy {
	public static void main(String[] args) {
		FileInputStream fis= null;
		FileOutputStream fos = null;
		
		try {
			long startTime = System.currentTimeMillis();
			fis = new FileInputStream("d:/D_Other/Tulips.jpg");
			fos = new FileOutputStream("d:/D_Other/Tulips2.jpg");
			int data = 0;
			
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			long endTime = System.currentTimeMillis();
			System.out.println("실행시간: "+(endTime - startTime));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
	}
}
