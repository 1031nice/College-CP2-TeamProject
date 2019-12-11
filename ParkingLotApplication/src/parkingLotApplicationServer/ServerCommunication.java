package parkingLotApplicationServer;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import model.ParkingLot;


public class ServerCommunication {

	Socket socket;

	public ServerCommunication(Socket socket) {
		this.socket = socket;
		receive();
	}

	// 사용자에게 객체를 주는 thread
	public void send(ParkingLot parkingLot) {
		Runnable send = new Runnable() {
			@Override
			public void run() {
				System.out.println("[서버] 사용자에게 객체를 보내는 thread 실행");
//				while (true) {
					try {
						ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
						objectOutputStream.writeObject(parkingLot);
						System.out.println("send완료. 전달한 객체의 정보는 아래와 같습니다.");
						System.out.println(Server.parkingLot.getName());
						System.out.println(Server.parkingLot.getLocation());
						for(int i=0; i<Server.parkingLot.getSpaces().length; i++) {
							System.out.println(i + " 번째 공간 할당여부: " + Server.parkingLot.getSpaces()[i].getStatus());
						}
					} catch (Exception e) {
						if (!Server.serverSocket.isClosed()) {
							Server.stopServer();
						}
//						break;
					}

//				}
			}
		};
		Server.threadPool.submit(send);
	}
	
	// 사용자에게 객체를 받는 thread
	public void receive() {
		Runnable receive = new Runnable() {
			@Override
			public void run() {
				System.out.println("[서버] 사용자 객체를 받는 thread 실행");
				while (true) {
					try {
						ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
						Server.parkingLot = (ParkingLot)objectInputStream.readObject();
//						for (ServerCommunication communication : Server.communicationList) {
//							communication.send(Server.parkingLot);
//						}
						System.out.println("receive완료. 전달받은 객체의 정보는 아래와 같습니다.");
						System.out.println(Server.parkingLot.getName());
						System.out.println(Server.parkingLot.getLocation());
						for(int i=0; i<Server.parkingLot.getSpaces().length; i++) {
							System.out.println(i + " 번째 공간 할당여부: " + Server.parkingLot.getSpaces()[i].getStatus());
						}
						send(Server.parkingLot);
					} catch (Exception e) {
//						if (!Server.serverSocket.isClosed()) {
//							Server.stopServer();
//						}
//						break;
					}

				}
			}
		};
		Server.threadPool.submit(receive);
	}

	/**
	 * 클라이언트와 통신이 안될 때 현재 클라이언트 제거
	 */
	//    private void disconnectClient(String errorMsg) {
	//        try {
	//        	SocketServerController.clientList.remove(Client.this);
	//            socket.close();
	//        } catch (IOException e) {
	//            e.printStackTrace();
	//        }
	//
	//    }

}
