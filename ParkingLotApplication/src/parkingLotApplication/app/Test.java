package parkingLotApplication.app;

import java.io.*;

public class Test { 
	//이 클래스는 텍스트파일에 회원정보들이 잘 입력되는지 테스트해보는 클래스입니다.
	
	public static void main(String[] args) {
	OwnerController control = new OwnerController();
		try {
		control.signUp();
		} catch(IOException e) {
			System.out.println("텍스트파일 쓰기 오류");
		}
	}
}
