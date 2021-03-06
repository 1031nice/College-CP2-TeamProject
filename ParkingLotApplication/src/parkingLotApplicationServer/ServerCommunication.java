package parkingLotApplicationServer;

import java.io.DataInputStream;
import java.io.IOException;
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
				try {
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
					objectOutputStream.writeObject(user);
					objectOutputStream.flush();
					//						System.out.println("[서버] 로그인된 정보 send 완료");
				} catch (Exception e) {
					e.printStackTrace();
					//					disconnectClient(null);
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
					DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
					String id = dataInputStream.readUTF();
					String pw = dataInputStream.readUTF();
					System.out.println("전송받은 id: " + id + "pw: " + pw);
					if(FileIO.find(id, pw)) {
						user = FileIO.getAppClientDataFromFile(id, "User");
						if(Server.communicationList.size() != 0) {
							user.setParkingLot(Server.communicationList.get(0).user.getParkingLot());
						}
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
						Server.parkingLot = user.getParkingLot();

						for (ServerCommunication communication : Server.communicationList) {
							communication.user.setParkingLot(Server.parkingLot);
							communication.send();
						}

						System.out.println("receive완료. 전달받은 객체의 정보는 아래와 같습니다.");
						System.out.println(user.getId());
						for(int i=0; i<user.getParkingLot().getSpaces().length; i++) {
							System.out.println(i+1 + " 번째 공간 할당여부: " + user.getParkingLot().getSpaces()[i].getStatus()
									+ " 사용자: " + user.getParkingLot().getSpaces()[i].toString());
						}

					} catch (Exception e) {
						//						disconnectClient(e.getMessage());
					}

				}
			}
		};
		Server.threadPool.submit(receive);
	}

	/**
	 * 클라이언트와 통신이 안될 때 현재 클라이언트 제거
	 */
	private void disconnectClient(String errorMsg) {
		try {
			Server.communicationList.remove(ServerCommunication.this);
			String msg = "[" + user.getId() + (errorMsg != null ? errorMsg : "클라이언트 통신 안됨");
			System.out.println(msg);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
