package kayParkingLotAppClient;

import java.io.*;
import java.net.*;

import model.*;

public class ClientThread extends Thread {
		User user;
		
		public ClientThread(User user) {
			this.user = user;
		}
		
		@Override
		public void run() {
			try {
				String host = "localhost";
				int port = 10002;
				Socket socket = new Socket(host, port);
				
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(user); //입출력을 확인하기 위해 User객체대신 임시적으로 String을 사용했습니다.
				oos.flush();
				
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				User user = (User) ois.readObject(); 
				System.out.println(user.getName() + " 을 가진 객체를 서버로 부터 받음");
				
			} catch (Exception e) {e.printStackTrace();}	
		}
	
}
