package kr.or.ddit.tcp.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TcpMultiChatServer {

    // 접속한 클라이언트들을 저장할 Map객체 선언
    // => key값 : 접속한 사람의 이름, value값 : 접속한 클라이언트의 socket객체
    private Map<String, Socket> clientMap;

    // 생성자
    public TcpMultiChatServer() {
        // clientMap을 동기화 처리가 되도록 생성한다.
        clientMap = Collections.synchronizedMap(new HashMap<String, Socket>());
    }

    // clientMap에 저장된 전체 사용자에게 메시지를 전송하는 메서드
    private void sendToAll(String msg) {
        // clientMap의 데이터 개수만큼 반복
        for (String name : clientMap.keySet()) {
            try {
                // 각 사용자의 Socket을 이용하여 OutputStream 객체를 구한다.
                DataOutputStream dos = new DataOutputStream(clientMap.get(name)
                        .getOutputStream());

                dos.writeUTF(msg);

            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    public void privateMessage(String msg, String from, String flag) {
        Iterator<String> it = clientMap.keySet().iterator();

        while (it.hasNext()) {
            try {
                String name = null;
                if (name.equals(flag)) {
                    name = it.next();
                    // 대화명에 해당하는 소캣객체 가져와 DataOutputStream객체 생성하기
                    DataOutputStream dos = new DataOutputStream(clientMap.get(name).getOutputStream());
                    dos.writeUTF(msg); // 메시지 보내기
                } else {
                    System.out.println("귓속말을 할 수 없습니다.");
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    public void serverStart() {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(7777);
            System.out.println("서버가 시작");

            while (true) {
                socket = server.accept(); // 접속을 기다린다.
                System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]에서 접속했습니다...");

                // 메시지를 받아서 전체에게 전송하는  Thread 객체를 생성하여 작동시킨다.
                ServerReceiver serverThread = new ServerReceiver(socket);
                serverThread.start();
            }


        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (server != null) try {
                server.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }

    }

    public static void main(String[] args) {
        new TcpMultiChatServer().serverStart();
    }

    // Inner Class로 서버에서 클라이언트로 메시지를 전송하는 Thread를 만든다.
    class ServerReceiver extends Thread {
        private Socket socket;
        private DataInputStream dis;
        private DataOutputStream dos;

        // 생성자
        public ServerReceiver(Socket socket) {
            this.socket = socket;

            try {
                // 수신용 객체 생성
                dis = new DataInputStream(socket.getInputStream());

                // 송신용 객체 생성
                dos = new DataOutputStream(socket.getOutputStream());

            } catch (Exception e) {
                // TODO: handle exception
            }
        } // 생성자 끝...




        @Override
        public void run() {
            String name = "";
            try {
                while (true) {
                    // 클라이언트가 접속이 완료되면 최초로 사용자의 이름을 전송하는데
                    // 이 이름이 중복되는지 여부를feedback으로 클라이언트에게 보내준다.

                    name = dis.readUTF();

                    if (clientMap.containsKey(name)) { //이름이 중복될 때...
                        dos.writeUTF("이름중복");

                    } else { // 이름이 중복되지 않을 때...
                        dos.writeUTF("OK");
                        break; // 반복문 탈출
                    }
                }

                // 현재 접속해 있는 다른 클라이언트들에게 대화명(이름)을 이용해서
                // 대화방 참여 메시지를 보낸다.
                sendToAll("[" + name + "]님이 대화방에 입장했습니다...");

                // 대화명과 클라이언트의 Socket객체를 Map에 저장한다.
                clientMap.put(name, socket);

                System.out.println("현재 서버 접속자 수 : " + clientMap.size() + "명");

                // 한 클라이언트가 보낸 메시지를 다른 클라이언트에게 전송해 준다.
                while (dis != null) {
                    sendToAll(dis.readUTF());

                    if (dis.readUTF().equals("/w")) {
                    }
                }

            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            } finally {
                clientMap.remove(name);
                sendToAll("[" + name + "]님이 대화방을 나갔습니다...");
                System.out.println("[" + socket.getInetAddress()
                        + " : " + socket.getPort() + "]에서 접속을 종료했습니다...");
                System.out.println("현재 서버 접속자 수 : " + clientMap.size() + "명");
            }
        }
    }
}