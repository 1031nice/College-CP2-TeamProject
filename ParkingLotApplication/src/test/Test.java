package test;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test {

	public static void main(String[] args) {

		while(true) {
			try {
				Socket socket = new Socket("192.168.56.1", 10002);
				System.out.println("접속 성공!");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				socket.close();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
