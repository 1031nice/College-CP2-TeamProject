package parkingLotApplication.app;

import java.util.Scanner;

import parkingLotApplication.model.AppClient;

public class ClientController extends AppController {
	
	@Override
	public void signUp() {
		AppClient c = new AppClient();
		Scanner scanner = new Scanner(System.in);
		System.out.println("회원가입");
		System.out.print("아이디: ");
		c.setId(scanner.next());
		System.out.print("비밀번호: ");
		c.setPassword(scanner.next());
		System.out.print(": ");
	}

	@Override
	public void editInfo() {
		// TODO Auto-generated method stub
		
	}

}
