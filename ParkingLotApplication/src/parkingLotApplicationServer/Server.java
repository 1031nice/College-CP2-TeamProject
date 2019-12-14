package parkingLotApplicationServer;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

import model.ParkingLot;
import model.ParkingSpace;

public class Server {
	
	public static ExecutorService threadPool; // 스레드풀
	public static ServerSocket serverSocket;
	// 정보 주고 받는 걸 관리할 객체의 리스트
	public static Vector<ServerCommunication> communicationList = new Vector<ServerCommunication>();
	public static ParkingLot parkingLot = new ParkingLot();

	public static void main(String[] args) {
		ParkingSpace[] spaces = new ParkingSpace[8];
		for(int i=0; i<spaces.length; i++)
			spaces[i] = new ParkingSpace();
		parkingLot.setSpaces(spaces);
		
		// 400개의 thread 미리 생성
		threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 100, Executors.defaultThreadFactory());

		// server socket 생성
		try {
			serverSocket = new ServerSocket(10002);
			System.out.println("[서버] server socket이 설정완료");
		} catch (IOException e) {
			e.printStackTrace();
			//서버종료
			if (!serverSocket.isClosed()) {
				stopServer();
			}
			return;
		}

		// 사용자 연결 thread
		Runnable connect = new Runnable() {
			@Override
			public void run() {
				System.out.println("[서버] 사용자 연결 thread를 실행");
				while (true) {
					try {
						Socket socket = serverSocket.accept();
						System.out.println("[서버] 클라이언트 연결 완료");
						communicationList.add(new ServerCommunication(socket));
					} catch (Exception e) {
						//서버종료
						if (!serverSocket.isClosed()) {
							stopServer();
						}
						break;
					}

				}
			}
		};
		threadPool.submit(connect);
	}
	
	public static void stopServer() {
		try {
			Iterator<ServerCommunication> iterator = communicationList.iterator();
			while (iterator.hasNext()) {
				iterator.next().socket.close();
				iterator.remove();
			}
			if (serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
			if (threadPool != null && !threadPool.isShutdown()) {
				threadPool.shutdown();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
