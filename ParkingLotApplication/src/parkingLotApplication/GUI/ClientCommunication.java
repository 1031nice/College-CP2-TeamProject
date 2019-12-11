package parkingLotApplication.GUI;

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
				//				send();
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
				try {
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
					objectOutputStream.writeObject(AppMain.parkingLot);
				} catch (Exception e) {
				}
			}
		};
		Thread thread = new Thread(send);
		thread.start();
	}

	//	 서버에게 객체를 받는 메소드
//	public void receive() {
//		//		while(true) {
//		try {
//			System.out.println("서버로부터 자리가 유효한지 확인하는 중입니다.");
//			ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
//			AppMain.user.setParkingLot((ParkingLot)objectInputStream.readObject());
//			System.out.println("receive완료. 전달받은 객체의 정보는 아래와 같습니다.");
//			System.out.println(AppMain.parkingLot.getName());
//			System.out.println(AppMain.parkingLot.getLocation());
//			for(int i=0; i<AppMain.parkingLot.getSpaces().length; i++) {
//				System.out.println(i + " 번째 공간 할당여부: " + AppMain.parkingLot.getSpaces()[i].getStatus());
//			}
//		} catch (Exception e) {
//			//			}
//		}
//	}
	
	// 서버에게 객체를 받는 스레드
	public void receive() {
		Runnable receive = new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("서버로부터 자리가 유효한지 확인하는 중입니다.");
					ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
					AppMain.parkingLot = (ParkingLot)objectInputStream.readObject();
					System.out.println("receive완료. 전달받은 객체의 정보는 아래와 같습니다.");
					System.out.println(AppMain.parkingLot.getName());
					System.out.println(AppMain.parkingLot.getLocation());
					for(int i=0; i<AppMain.parkingLot.getSpaces().length; i++) {
						System.out.println(i + " 번째 공간 할당여부: " + AppMain.parkingLot.getSpaces()[i].getStatus());
					}
				} catch (Exception e) {
				}

			}
		};
		Thread thread = new Thread(receive);
		thread.start();
	}
}
