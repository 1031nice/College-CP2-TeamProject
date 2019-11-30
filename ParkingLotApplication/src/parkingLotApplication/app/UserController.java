package parkingLotApplication.app;

import java.io.*;
import java.util.*;

import parkingLotApplication.model.*;

public class UserController extends AppClientController {
	ObjectInputStream ois = null;
	BufferedInputStream bis = null;
	FileInputStream fis = null;		
	ObjectOutputStream oos1 = null;
	BufferedOutputStream bos1 = null;
	FileOutputStream fos1 = null;
	ObjectOutputStream oos2 = null;
	BufferedOutputStream bos2 = null;
	FileOutputStream fos2 = null;
	ArrayList<User> userList;
	int numOfUser = 0;

	@Override
	public void signUp(AppClient appClient) throws IOException, ClassNotFoundException, FileNotFoundException {
		fis  = new FileInputStream("./src/parkingLotApplication/app/UserInfo.txt");
		bis = new BufferedInputStream(fis);
		ois = new ObjectInputStream(bis);
		fos1 = new FileOutputStream("./src/parkingLotApplication/app/UserInfo.txt");
		bos1 = new BufferedOutputStream(fos1);
		oos1 = new ObjectOutputStream(bos1);
		fos2 = new FileOutputStream("./src/parkingLotApplication/app/UserInfo.txt");
		bos2 = new BufferedOutputStream(fos2);
		oos2 = new ObjectOutputStream(bos2);
		
		if(numOfUser == 0) {
			userList = new ArrayList<>(); 
			oos2.writeObject(userList);
			oos2.flush();
			oos2.close(); bos2.close(); fos2.close();
		}
		
		userList = (ArrayList<User>) ois.readObject();
		userList.add((User) appClient);
		oos1.writeObject(userList);
		numOfUser++;
		
		oos1.flush();
		ois.close(); bis.close(); fis.close();
		oos1.close(); bos1.close(); fos1.close();		
	}

	@Override
	public void editInfo() {
		
		
	}
}
