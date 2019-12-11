package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import javafx.application.Platform;
import model.ParkingLot;
import model.ParkingSpace;

public class AppMain2 {
	
    private static Socket socket;
    static ParkingLot parkingLot;
	
	public static void main(String[] args) {
		ParkingSpace[] parkingSpaces = new ParkingSpace[8];
		for(int i=0; i<parkingSpaces.length; i++) {
			parkingSpaces[i] = new ParkingSpace();
		}
		parkingLot = new ParkingLot("주차장1", "공대 5호관", parkingSpaces);
		startClient();
	}
	
	static void startClient() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                	// TODO 소켓을 생성하여 socket 필드에 대입하기
                	socket = new Socket();
    				socket.connect(new InetSocketAddress("192.168.56.1", 10002));
                } catch (IOException e) {
                }
                send();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

	static void receive() {
        while (true) {
            try {
                byte[] bytes = new byte[512];
                InputStream inputStream = socket.getInputStream();
                // 서버가 비정상적으로 종료했을 경우 IOException 발생
                int readByteCount = inputStream.read(bytes);
                // 서버가 정상적으로 Socket의 close()를 호출했을 경우
                if (readByteCount == -1) {
                    throw new IOException();
                }
            } catch (IOException e) {
                break;
            }
        }
    }

    static void send() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
				System.out.println("[클라이언트] send 시도");
				try {
					System.out.println("[클라이언트] send 실행");
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
					objectOutputStream.writeObject(parkingLot);
                } catch (IOException e) {
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
