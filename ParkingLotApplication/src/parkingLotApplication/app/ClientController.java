package parkingLotApplication.app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import parkingLotApplication.model.AppClient;

public class ClientController extends AppController {
	
	@Override
	public void signUp() {
		AppClient c = new AppClient();
		Scanner scanner = new Scanner(System.in);
		System.out.println("***회원가입***");
		System.out.print("아이디: ");
		c.setId(scanner.next());
		System.out.print("비밀번호: ");
		c.setPassword(scanner.next());
		System.out.print("이름: ");
		c.setId(scanner.next());
		System.out.print("나이: ");
		c.setAge(scanner.nextInt());
		System.out.print("번호: ");
		c.setPhoneNumber(scanner.next());
		
		try {
			OutputStream output = new FileOutputStream("ClientInfo.txt");
			String str = "Id: " + c.getId() + " Pw: " + c.getPassword() + " Name: " + c.getName() + " Age: " + c.getAge() + " PhoneNumber: " + c.getPhoneNumber();
			byte[] by = str.getBytes();
			try {
				output.write(by);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		scanner.close();
	}

	@Override
	public void editInfo() {
		// TODO Auto-generated method stub
		
	}

}
