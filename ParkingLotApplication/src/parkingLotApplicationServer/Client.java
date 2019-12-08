package parkingLotApplicationServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
	
    Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
        receive();
    }

    /**
     * 클라이언트로부터 데이터 받기
     */
    private void receive() {
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

    /**
     * 클라이언트로 데이터 보내기
     * @param msg
     */
    private void send(String msg) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write(bytes);
                    outputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                    disconnectClient(null);
                }
            }
        };
        SocketServerController.service.submit(runnable);
    }

    /**
     * 클라이언트와 통신이 안될 때 현재 클라이언트 제거
     */
    private void disconnectClient(String errorMsg) {
        try {
        	SocketServerController.clientList.remove(Client.this);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
