package parkingLotApplication.app;

import java.util.Scanner;

public class ManagerController extends AppController {

	@Override
	public void signUp() {
		String id;
		String password;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("회원가입");
		System.out.print("아이디: ");
		id = scanner.next();
		System.out.print("비밀번호: ");
		password = scanner.next();

	}

	@Override
	public void editInfo() {
		// TODO Auto-generated method stub
		
	}
	
}
