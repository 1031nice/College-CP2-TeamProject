package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import javafx.application.Platform;
import model.ParkingLot;

public class ClientCommunication {

	Socket socket;

	public ClientCommunication() {
		init();
	}

	void init() {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					// TODO 소켓을 생성하여 socket 필드에 대입하기
					socket = new Socket();
					socket.connect(new InetSocketAddress("192.168.56.1", 10002));
					System.out.println("[클라이언트] 서버와 연결완료");
				} catch (IOException e) {
				}
				send();
//				receive();
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}

	// 서버에게 객체를 주는 Thread
	public void send() {
		Runnable send = new Runnable() {
			@Override
			public void run() {
				System.out.println("[클라이언트] send 시도");
				try {
					System.out.println("[클라이언트] send 실행");
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
					objectOutputStream.writeObject(AppMain.user.parkingLot);
				} catch (Exception e) {
				}
			}
		};
		Thread thread = new Thread(send);
		thread.start();
	}

	// 서버에게 객체를 받는 메소드
//	public void receive() {
//		while(true) {
//			try {
//				ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
//				AppMain.user.setParkingLot((ParkingLot)objectInputStream.readObject());
//			} catch (Exception e) {
//			}
//		}
//	}
	//	public void receive() {
	//		Runnable receive = new Runnable() {
	//			@Override
	//			public void run() {
	//				try {
	//					ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
	//					AppMain.user.setParkingLot((ParkingLot)objectInputStream.readObject());
	//				} catch (Exception e) {
	//				}
	//
	//			}
	//		};
	//        Thread thread = new Thread(receive);
	//        thread.start();
	//	}

}
