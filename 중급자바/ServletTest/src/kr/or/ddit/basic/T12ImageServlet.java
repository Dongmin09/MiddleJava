package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T12ImageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("image/jpg"); // 이미지를 보내기 위한 서블릿 셋팅
		
		ServletOutputStream out =  resp.getOutputStream();
		
		FileInputStream fis = new FileInputStream("C:\\xampp\\htdocs\\jsstudy\\images\\족제비.jpg");
		
		BufferedInputStream bis = new BufferedInputStream(fis); 
		BufferedOutputStream bos = new BufferedOutputStream(out);
		
		int bytesCnt = 0;
		while((bytesCnt = bis.read()) !=-1) {
			bos.write(bytesCnt);
		}
		
		bis.close();
		bos.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
}
