package kayParkingLotAppServer;
import java.io.*;
import java.net.*;

import model.*;

public class ServerThread extends Thread{
	User user;
	
	@Override
	public void run() {
		int port = 10002;
		try {
			ServerSocket serverSocket = new ServerSocket(port); //서버 실행
			System.out.println("[서버 실행]");
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.println("[서버 연결]");
				
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				user = (User) ois.readObject();
				System.out.println(user.getId() + " User를 클라이언트로부터 받음");
				user.setName("서버가 임의로 바꾼 이름");
				
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(user);
				oos.flush();
				
				socket.close();
				//프로그램을 종료시킬때마다 socket.close() 실행해주기
			}
		} catch (Exception e) {e.printStackTrace();}
	}

}
