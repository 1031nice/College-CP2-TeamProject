package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Writer;

public class Main {
	
	static FileOutputStream fileOutputStream;
	static BufferedOutputStream bufferedOutputStream;
	static String fileName = "test";
	
	public static void signUp(AppClient appClient) throws IOException, ClassNotFoundException, FileNotFoundException {
		// file stream을 연다
//		fileOutputStream = new FileOutputStream("./src/parkingLotApplication/app/" + fileName + ".txt", true);
//		bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
//		bufferedOutputStream.write(appClient.getId().getBytes());
		
		Writer writer = new FileWriter("./src/parkingLotApplication/app/" + fileName + ".txt", true);
		writer.write(appClient.getId().toCharArray());
		writer.append('\n');
		writer.flush();
		writer.close();
	}

	public static void main(String[] args) throws Exception {
		
		AppClient appClient1 = new AppClient("aaaaa","11111","강","24","650702");
		AppClient appClient2 = new AppClient("bbbbb","22222","동","24","650702");
		AppClient appClient3 = new AppClient("ccccc","33333","김","24","650702");
		AppClient appClient4 = new AppClient("ddddd","44444","훈","24","650702");
		AppClient appClient5 = new AppClient("eeeee","55555","","24","650702");
		
		try {
			signUp(appClient1);
			signUp(appClient2);
			signUp(appClient3);
			signUp(appClient4);
			signUp(appClient5);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
//		String fileName = "test";
//		FileInputStream fileInputStream = new FileInputStream("./src/parkingLotApplication/app/" + fileName + ".txt");
//		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
//
//		int readByteNo;
//		byte[] readBytes = new byte[3];
//		String data = "";
//		while( true ) {
//			readByteNo = bufferedInputStream.read(readBytes);
//			if(readByteNo == -1) break;
//			data += new String(readBytes, 0, readByteNo);
//			System.out.println(readByteNo);
//		}
//		System.out.println(data);
		
//		for(int i=0; i<5; i++) {
//			AppClient appClient = new AppClient();
//			appClient = (AppClient)objectInputStream.readObject();
//			if(appClient.getId().equals(appClient4.getId())) {
//				System.out.println("찾았습니다.");
//				System.out.println(appClient4);		
//			}
//		}
		
		
	}

}
