package parkingLotApplication.GUI;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import model.ParkingLot;
import model.User;

public class ClientCommunication {

	Socket socket;
	User user;

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

	// 서버에게 로그인 정보를 주는 Thread
	public void sendIdAndPassword(String id, String pw) {
		Runnable send = new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("[클라이언트] 서버에게 id와 pw를 전송하는 thread");
					DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
					dataOutputStream.writeUTF(id);
					dataOutputStream.writeUTF(pw);
					dataOutputStream.flush();
					System.out.println("[클라이언트] 전송완료");
				} catch (Exception e) {
				}
			}
		};
		Thread thread = new Thread(send);
		thread.start();
	}
	
	public void sendInfo(String id, String pw, String name, String age,
			String accountNumber, String carNumber, boolean isNonPerson) {
		Runnable send = new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("[클라이언트] 서버에게 회원가입 정보를 전송하는 thread");
					DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
					dataOutputStream.writeUTF(id);
					dataOutputStream.writeUTF(pw);
					dataOutputStream.writeUTF(name);
					dataOutputStream.writeUTF(age);
					dataOutputStream.writeUTF(accountNumber);
					dataOutputStream.writeUTF(carNumber);
					String str = String.valueOf(isNonPerson);
					dataOutputStream.writeUTF(str);
					dataOutputStream.flush();
					System.out.println("[클라이언트] 전송완료");
				} catch (Exception e) {
				}
			}
		};
		Thread thread = new Thread(send);
		thread.start();
	}

	
	// 서버에게 객체를 주는 Thread
	public void send() {
		Runnable send = new Runnable() {
			@Override
			public void run() {
				try {
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
					objectOutputStream.writeObject(user.getParkingLot());
					System.out.println("send완료. 전달받은 객체의 정보는 아래와 같습니다.");
					System.out.println(user.getParkingLot().getName());
					System.out.println(user.getParkingLot().getLocation());
					for(int i=0; i<user.getParkingLot().getSpaces().length; i++) {
						System.out.println(i + " 번째 공간 할당여부: " + user.getParkingLot().getSpaces()[i].getStatus());
					}
				} catch (Exception e) {
				}
			}
		};
		Thread thread = new Thread(send);
		thread.start();
	}
	
	// 로그인 또는 회원가입이 유효한지 확인하는 스레드
	public void checkReceive() {
		Runnable receive = new Runnable() {
			@Override
			public void run() {
				try {
					ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
					user = (User)objectInputStream.readObject();
					System.out.println("receive완료. 전달받은 객체의 정보는 아래와 같습니다.");
					System.out.println(user.getParkingLot().getName());
					System.out.println(user.getParkingLot().getLocation());
					for(int i=0; i<user.getParkingLot().getSpaces().length; i++) {
						System.out.println(i + " 번째 공간 할당여부: " + user.getParkingLot().getSpaces()[i].getStatus());
					}
					if(user == null) // user에 정보가 안담겼으면
						System.out.println("사용자의 로그인 정보가 일치하지 않습니다.");
					else { // user에 정보가 담겼으면

					}
				} catch (Exception e) {
				}
			}
		};
		Thread thread = new Thread(receive);
		thread.start();
	}
	
	// 서버에게 객체를 받는 스레드
	public void receive() {
		Runnable receive = new Runnable() {
			@Override
			public void run() {
				try {
					ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
					user.setParkingLot((ParkingLot)objectInputStream.readObject());
					System.out.println("receive완료. 전달받은 객체의 정보는 아래와 같습니다.");
					System.out.println(user.getParkingLot().getName());
					System.out.println(user.getParkingLot().getLocation());
					for(int i=0; i<user.getParkingLot().getSpaces().length; i++) {
						System.out.println(i + " 번째 공간 할당여부: " + user.getParkingLot().getSpaces()[i].getStatus());
					}
					AppMain.flag = false;
				} catch (Exception e) {
				}
			}
		};
		Thread thread = new Thread(receive);
		thread.start();
	}
}
