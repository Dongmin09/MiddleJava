package kr.or.ddit.tcp;

import java.io.*;

import java.net.*;
import java.util.*;

public class MultiChatClient {
	private Scanner scan = new Scanner(System.in);
	private String name;
	
	public void clientStart() {
		System.out.print("대화명을 입력하세요 >> ");
		name = scan.next();
		try {
			Socket socket = new Socket("192.168.142.10", 7777);
			System.out.println("서버에 연결되었습니다.");
			// 송신용 스레드
			ClientSender sender = new ClientSender(socket, name);
			// 수신용 스레드
			ClientReceiver receiver = new ClientReceiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	class ClientSender extends Thread {
		private DataOutputStream dos;
		private String name;
		
		public ClientSender(Socket socket, String name) {
			this.name = name;
			try {
				dos = new DataOutputStream(socket.getOutputStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			try {
				// 시작하자 마자 자신의 대화명을 서버로 전송한다.
				if(dos != null) {
					dos.writeUTF(name);
				}
				while(dos != null) {
					// 키보드로 입력받은 메세지를 서버로 전송
					dos.writeUTF(scan.nextLine());
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	class ClientReceiver extends Thread {
		private DataInputStream dis;
		
		public ClientReceiver(Socket socket) {
			try {				
				dis = new DataInputStream(socket.getInputStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			while(dis != null) {
				try {
					// 서버로부터 수신한 메세지를 출력하기
					System.out.println(dis.readUTF());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new MultiChatClient().clientStart();
	}
}
