package parkingLotApplicationServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.AppClient;
import parkingLotApplication.GUI.AppMain;

public class Server {

	public static Vector<AppClient> appClientList = new Vector<AppClient>();

	public static ExecutorService threadPool; // 스레드풀

	public static ServerSocket serverSocket;
	public static Socket clientSocket;

	public static void main(String[] args) {
		
		// 코어 개수만큼의 thread를 만들어놓고
		threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), Executors.defaultThreadFactory());

		// server socket 생성하고
		try {
        	serverSocket = new ServerSocket(10002);
			System.out.println("server socket이 설정되었습니다");
        } catch (IOException e) {
            e.printStackTrace();
            if (!serverSocket.isClosed()) {
            }
            return;
        }
        
		// 여기는 사용자를 연결시켜주는 thread
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Socket socket = serverSocket.accept();  // 연결 수락
                        appClientList.add(new AppClient(socket));
                    } catch (Exception e) {
                        if (!serverSocket.isClosed()) {
                        }
                        break;
                    }

                }
            }
        };
        // 스레드 풀에서 처리
        threadPool.submit(runnable);
		
//		try { // 사용자를 연결하는 thread
//			AcceptThread acceptThread = new AcceptThread(serverSocket);
//			new Thread(acceptThread).start();
//			// threadPool.submit(acceptThread);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//			System.out.println("사용자를 accept하는 thread 생성에 실패했습니다");
//		}
//
//		try { // 사용자 객체를 주고받는 thread
//			SendThread sendThread = new SendThread();
//			ReceiveThread receiveThread = new ReceiveThread();
//			new Thread(sendThread).start();
//			new Thread(receiveThread).start();
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}

	}

	//    public static void stopServer() {
	//        try {
	//            Iterator<AppClient> iterator = appClientList.iterator();
	//            while (iterator.hasNext()) {
	//                iterator.next().socket.close();
	//                iterator.remove();
	//            }
	//            if (serverSocket != null && !serverSocket.isClosed()) {
	//                serverSocket.close();
	//            }
	//            if (threadPool != null && !threadPool.isShutdown()) {
	//            	threadPool.shutdown();
	//            }
	//        } catch (Exception e) {
	//            e.printStackTrace();
	//        }
	//    }
}
