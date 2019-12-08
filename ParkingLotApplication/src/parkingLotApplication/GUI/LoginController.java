package parkingLotApplication.GUI;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class LoginController {

	@FXML TextField idTextField;
	@FXML PasswordField pwTextField;
	@FXML RadioButton appClient;
	@FXML ToggleGroup type;
	@FXML RadioButton owner;
	@FXML StackPane stackPane;
	@FXML AnchorPane anchorPane;
	private String name;
	
//	public LoginController(String name) {
//		this.name = name;
//	}
	
	@FXML public void loginButtonAction() throws Exception {

		String inputId = idTextField.getText();
		String inputPassword = pwTextField.getText();

		if(type.getSelectedToggle().getUserData().equals("고객")) {
			String password = AppMain.findId(inputId, "UserInfo");
			if(inputPassword.equals(password)) {
				AppMain.getAppClientDataFromFile(inputId, "User");
				Parent ParkingLotList = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/ParkingLotList.fxml"));
				stackPane.getChildren().remove(anchorPane);
				stackPane.getChildren().add(ParkingLotList);
			}
			else {
				System.out.println("사용자의 로그인 정보가 일치하지 않습니다.");
			}
		}
		else {
			String password = AppMain.findId(inputId, "OwnerInfo");
			if(inputPassword.equals(password)) {
				AppMain.getAppClientDataFromFile(inputId, "Owner");
				Parent ownerMain = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/OwnerMain.fxml"));
				stackPane.getChildren().remove(anchorPane);
				stackPane.getChildren().add(ownerMain);
			}
			else {
				System.out.println("관리자의 로그인 정보가 일치하지 않습니다.");
			}
		}
	}

	@FXML public void signUpButtonAction() throws Exception {
		Parent signUp = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/signUp.fxml"));
		stackPane.getChildren().add(signUp);
	}


	@FXML public void exitButtonAction() {
		System.exit(1);
	}
}