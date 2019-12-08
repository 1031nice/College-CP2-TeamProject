package parkingLotApplicationServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import model.AppClient;
import parkingLotApplication.GUI.AppMain;

public class Server {

	public static Vector<AppClient> appClientList = new Vector<AppClient>();

	//    public static ExecutorService threadPool; // 스레드풀

	public static ServerSocket serverSocket;
//	public static Socket[] clientSockets;
	public static Socket clientSocket;
	public static int numberOfClient = 0;
	public static boolean[] parkingLot = new boolean[8];


	public static void main(String[] args) throws Exception {
		
		try { // server socket 생성
			serverSocket = new ServerSocket(10002);
			System.out.println("server socket이 설정되었습니다");
		} catch (IOException e) {
			e.printStackTrace();
			if (!serverSocket.isClosed()) {
				//                stopServer();
			}
			return;
		}
		
		ObjectInputStream objInputStream = new ObjectInputStream(AppMain.user.socket.getInputStream());
		parkingLot = (boolean[])objInputStream.readObject();
		for(int i=0; i<parkingLot.length; i++) {
			System.out.println(parkingLot[i]);
		}
		
		
		
		//		threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), Executors.defaultThreadFactory());



		try { // 사용자를 연결하는 thread
			AcceptThread acceptThread = new AcceptThread(serverSocket);
			new Thread(acceptThread).start();
			//			threadPool.submit(acceptThread);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		try { // 사용자 객체를 주고받는 thread
			SendThread sendThread = new SendThread();
			ReceiveThread receiveThread = new ReceiveThread();
			new Thread(sendThread).start();
			new Thread(receiveThread).start();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

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
