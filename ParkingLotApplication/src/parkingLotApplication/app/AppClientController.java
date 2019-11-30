package parkingLotApplication.app;

import java.io.*;

import parkingLotApplication.model.*;

public abstract class AppClientController {

	public abstract void signUp(AppClient appClient) throws IOException, ClassNotFoundException, FileNotFoundException;
	public abstract void editInfo();
	public void memberSecession() {
		// 회원탈퇴
	}
	
}