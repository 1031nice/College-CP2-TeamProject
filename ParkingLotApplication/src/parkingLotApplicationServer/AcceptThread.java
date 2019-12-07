package parkingLotApplicationServer;

import java.io.IOException;
import java.net.ServerSocket;

import model.AppClient;


public class AcceptThread implements Runnable {

	ServerSocket serverSocket;
	
	public AcceptThread(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	
	@Override
	public void run() {
		System.out.println("클라이언트의 연결을 기다립니다.");
		while(true) {
			try {
				Server.clientSocket = serverSocket.accept();
				System.out.println("connected client" + Server.clientSocket);
				Server.numberOfClient++;
                Server.appClientList.add(new AppClient(Server.clientSocket));
			}
			catch(IOException e) {
				System.err.println("다음의 포트 번호에 연결할 수 없습니다: " + Server.clientSocket);
				System.out.println("연결을 다시 시도합니다.");
			}
		}
	}

}
