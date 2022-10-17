package homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {

		FileInputStream fis = null;
		FileOutputStream fos = null;

		int data = 0;

		try {
			fis = new FileInputStream("d:/D_Other/Tulips.jpg");
			fos = new FileOutputStream("d:/D_Other/복사본_Tulips.jpg");

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}

		} catch (IOException ex) {
			ex.printStackTrace();

		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}