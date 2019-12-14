package parkingLotApplication.GUI;

import java.io.*;
import java.net.*;
import java.util.*;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.ParkingLot;
import model.ParkingSpace;

public class LoginController implements Initializable {

	@FXML TextField idTextField;
	@FXML PasswordField pwTextField;
	@FXML RadioButton appClient;
	@FXML ToggleGroup type;
	@FXML RadioButton owner;
	@FXML StackPane stackPane;
	@FXML AnchorPane anchorPane;
//	private String name;
	
//	public LoginController(String name) {
//		this.name = name;
//	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	@FXML public void loginButtonAction() throws Exception {
		owner.getStyleClass().add(".class");
		if(type.equals(null)) {
			System.out.println("사용자이신가요? 관리자이신가요?");
			return;
		}

		String inputId = idTextField.getText();
		String inputPassword = pwTextField.getText();

		if(type.getSelectedToggle().getUserData().equals("고객")) {
			AppMain.communication.sendIdAndPassword(inputId, inputPassword);
			AppMain.communication.firstReceive();
			
			Thread.sleep(1000);
			Parent UserMain = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/UserMain.fxml"));
			stackPane.getChildren().remove(anchorPane);
			stackPane.getChildren().add(UserMain);

		}
//		else { // owner는 일단 생략
//			String password = AppMain.findId(inputId, "OwnerInfo");
//			if(inputPassword.equals(password)) {
//				AppMain.getAppClientDataFromFile(inputId, "Owner");
//				Parent ownerMain = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/OwnerMain.fxml"));
//				stackPane.getChildren().remove(anchorPane);
//				stackPane.getChildren().add(ownerMain);
//			}
//			else {
//				System.out.println("관리자의 로그인 정보가 일치하지 않습니다.");
//			}
//		}
	}

	@FXML public void signUpButtonAction() throws Exception {
		Parent signUp = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/signUp.fxml"));
		stackPane.getChildren().add(signUp);
	}


	@FXML public void exitButtonAction() {
		System.exit(1);
		
	}
}