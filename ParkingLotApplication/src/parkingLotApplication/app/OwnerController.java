package parkingLotApplication.app;

import java.io.*;

import parkingLotApplication.model.*;

public class OwnerController extends AppController {
	BufferedReader ownerOut = null;
	FileWriter ownerIn = null;
	
	@Override
	public void signUp() throws IOException{
		
		
		Owner owner1 = new Owner("onion", "1234", "김아영", 21, "01029372522"); //임시로 객체 생성 	
		ownerIn = new FileWriter("OwnerInfo.txt");
		ownerIn.write("Id:"+owner1.getId() + " Pw:" + owner1.getPassword() + " Name:" + owner1.getName() + " Age:" + owner1.getAge() + " PhoneNumber:" + owner1.getPhoneNumber());
		ownerIn.write("\n"); //개행이 안됨 나중에 코드 고치기!
		ownerIn.flush();
	}

	@Override
	public void editInfo() {
		
		
	}
	
	
}
