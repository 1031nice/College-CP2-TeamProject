package test;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class AppClientController {

	FileOutputStream fileOutputStream;
	BufferedOutputStream bufferedOutputStream;
	ObjectOutputStream objectOutputStream;
	String fileName = "test";
	
	public void signUp(AppClient appClient) throws IOException, ClassNotFoundException, FileNotFoundException {
		// file stream을 연다
		fileOutputStream = new FileOutputStream("./src/parkingLotApplication/app/" + fileName + ".txt", true);
		bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		bufferedOutputStream.write(appClient.getId().getBytes());
	}
	
	public void editInfo() {
		
	}
	public void memberSecession() {
		// 회원탈퇴
	}
	
}