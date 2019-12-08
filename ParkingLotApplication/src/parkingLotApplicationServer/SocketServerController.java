package parkingLotApplicationServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Platform;
import javafx.beans.binding.DoubleBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;

public class SocketServerController {
 
	public static ExecutorService service;            // 스레드풀
	public static ServerSocket serverSocket;
	public static List<Client> clientList = new Vector<>();

	public static void main(String[] args) {

    	// CPU 코어의 수만큼 스레드를 만들도록 한다.
    	service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), Executors.defaultThreadFactory());
        try {
        	serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(8888));
        } catch (IOException e) {
            e.printStackTrace();
            if (!serverSocket.isClosed()) {
                stopServer();
            }
            return;
        }
        
        accept();
        receive();
	}
	
	public static void accept() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Socket socket = serverSocket.accept();  // 연결 수락
                        clientList.add(new Client(socket));
                    } catch (Exception e) {
                        if (!serverSocket.isClosed()) {
                            stopServer();
                        }
                        break;
                    }

                }
            }
        };
        // 스레드 풀에서 처리
        service.submit(runnable);
	}

	
    public static void receive() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        byte[] bytes = new byte[256];
                        InputStream inputStream = socket.getInputStream();
                        // 클라이언트가 비정상 종료를 했을 경우 IOException 발생
                        int readByteCount = inputStream.read(bytes);
                        // 클라이언트가 정상적으로 Socket의 close()를 호출했을 경우
                        if (readByteCount == -1) {
                            throw new IOException("클라이언트 종료");
                        }
                        String data = new String(bytes, 0, readByteCount, StandardCharsets.UTF_8);
                        for (Client client : SocketServerController.clientList) {
                            client.send(data);
                        }
                    }
                } catch (IOException e) {
                    disconnectClient(e.getMessage());
                }
            }
        };
        SocketServerController.service.submit(runnable);
    }

    public static void stopServer() {
    	try {
    		Iterator<Client> iterator = clientList.iterator();
    		while (iterator.hasNext()) {
    			iterator.next().socket.close();
    			iterator.remove();
    		}
    		if (serverSocket != null && !serverSocket.isClosed()) {
    			serverSocket.close();
    		}
    		if (service != null && !service.isShutdown()) {
    			service.shutdown();
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

}
