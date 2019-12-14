package parkingLotApplicationServer;

import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import model.AppClient;
import model.User;


public class ServerCommunication {

	Socket socket;
	private AppClient user;

	public ServerCommunication(Socket socket) {
		this.socket = socket;
		receiveIdAndPassword();
//		receiveInfo();
	}

	// 사용자에게 객체를 주는 thread
	public void send() {
		Runnable send = new Runnable() {
			@Override
			public void run() {
				System.out.println("[서버] 사용자에게 객체를 보내는 thread 실행");
				//				while (true) {
				try {
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
					objectOutputStream.writeObject(user);
					System.out.println("send완료. 전달한 객체의 정보는 아래와 같습니다.");
					System.out.println(user.getName());
					for(int i=0; i<Server.parkingLot.getSpaces().length; i++) {
						System.out.println(i + " 번째 공간 할당여부: " + user.getParkingLot().getSpaces()[i].getStatus());
					}
				} catch (Exception e) {
					if (!Server.serverSocket.isClosed()) {
						Server.stopServer();
					}
				}
			}
		};
		Server.threadPool.submit(send);
	}

	// 사용자에게 아이디 비밀번호를 받는 thread
	public void receiveIdAndPassword() {
		Runnable receive = new Runnable() {
			@Override
			public void run() {
				System.out.println("[서버] 사용자 아이디/비밀번호를 받는 thread 실행");
				try {
					//					InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
					//					BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
					DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
					String id = dataInputStream.readUTF();
					String pw = dataInputStream.readUTF();
					System.out.println("전송받은 id: " + id + "pw: " + pw);
					if(FileIO.find(id, pw)) {
						user = FileIO.getAppClientDataFromFile(id, "User");
						if(user != null) {
							receive();
							send();
						}
					}
				} catch (Exception e) {
				}
			}
		};
		Server.threadPool.submit(receive);
	}

	// 사용자에게 회원가입 정보를 받는 thread
	public void receiveInfo() {
		Runnable receive = new Runnable() {
			@Override
			public void run() {
				System.out.println("[서버] 사용자 회원가입 정보를 받는 thread 실행");
				try {
					DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
					String id = dataInputStream.readUTF();
					String pw = dataInputStream.readUTF();
					String name = dataInputStream.readUTF();
					String age = dataInputStream.readUTF();
					String accountNumber = dataInputStream.readUTF();
					String carNumber = dataInputStream.readUTF();
					String isNonPerson = dataInputStream.readUTF();
					boolean bool = Boolean.valueOf(isNonPerson);
					System.out.println("전송받은 id: " + id + "\n전송받은 pw: " + pw);
					if(FileIO.findId(id)) {
						System.out.println("이미 존재하는 아이디입니다!");
					}
					else {
						FileIO.signUp(id, pw, name, age, accountNumber, carNumber, bool);
						receive();
						send();
					}
				} catch (Exception e) {
				}
			}
		};
		Server.threadPool.submit(receive);
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
						user = (User)objectInputStream.readObject();
						//						for (ServerCommunication communication : Server.communicationList) {
						//							communication.send(Server.parkingLot);
						//						}
						System.out.println("receive완료. 전달받은 객체의 정보는 아래와 같습니다.");
						System.out.println(user.getName());
						for(int i=0; i<user.getParkingLot().getSpaces().length; i++) {
							System.out.println(i + " 번째 공간 할당여부: " + user.getParkingLot().getSpaces()[i].getStatus());
						}
						send();
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
