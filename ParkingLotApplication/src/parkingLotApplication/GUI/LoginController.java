package parkingLotApplication.GUI;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.scene.layout.StackPane;

public class LoginController {

	@FXML TextField idTextField;
	@FXML PasswordField pwTextField;
	@FXML RadioButton appClient;
	@FXML ToggleGroup type;
	@FXML RadioButton owner;
	@FXML StackPane stackPane;
	@FXML AnchorPane anchorPane;
	
	@FXML public void loginButtonAction() throws Exception {

		String inputId = idTextField.getText();
		String inputPassword = pwTextField.getText();

		if(type.getSelectedToggle().getUserData().equals("고객")) {
			String password = AppMain.findId(inputId, "UserInfo");
			if(inputPassword.equals(password)) {
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