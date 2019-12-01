package parkingLotApplication.app;

import java.io.*;
import java.util.*;

import parkingLotApplication.model.*;

public class OwnerController extends AppClientController{

	public OwnerController() {
		this.fileName = "OwnerInfo";
	}
	
	@Override
	public void signUp(AppClient appClient) throws IOException, ClassNotFoundException, FileNotFoundException{		
		Owner owner =  (Owner)appClient; // UserController에 들어올 객체는 User이므로 downcast
		// 관리자 텍스트 파일 만들고
		Writer writer = new FileWriter("./src/data/" + fileName + ".txt", true);
		writer.write(owner.getId().toCharArray());
		writer.write(' ');
		writer.write(owner.getPassword().toCharArray());
		writer.write(' ');
		writer.write(owner.getName().toCharArray());
		writer.write(' ');
		writer.write(owner.getAge().toCharArray());
		writer.write(' ');
		writer.write(owner.getAccountNumber().toCharArray());		
		writer.append('\n');
		writer.flush();
		writer.close();		
		// 관리자 별 주차장 텍스트 파일
		File file = new File("./src/data/" + fileName + "_" + owner.getId() + ".txt");
		Writer writer2 = new FileWriter(file, true);
		writer2.close();
	}
	
	@Override
	public void editInfo() {
		
	}

	@Override
	public void memberSecession() {
		
	}
	
}
