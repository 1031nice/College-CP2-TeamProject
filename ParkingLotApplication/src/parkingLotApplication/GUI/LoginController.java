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

public class LoginController {

	@FXML Button loginButton;
	@FXML TextField idTextField;
	@FXML PasswordField pwTextField;
	@FXML RadioButton appClient;
	@FXML ToggleGroup type;
	@FXML RadioButton owner;
	@FXML Button exitButton;
	@FXML Button signUpButton;
	@FXML AnchorPane anchorPane;
	
	@FXML public void loginButtonAction() throws Exception {

		String inputId = idTextField.getText();
		String inputPassword = pwTextField.getText();

		if(type.getSelectedToggle().getUserData().equals("고객")) {
			String password = AppMain.findId(inputId, "UserInfo");
			System.out.println(password);
			if(inputPassword.equals(password)) {
				Parent ParkingLotList = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/ParkingLotList.fxml"));
				anchorPane.getChildren().add(ParkingLotList);
			}
			else {
				System.out.println("사용자의 로그인 정보가 일치하지 않습니다.");
			}
		}
		else {
			String password = AppMain.findId(inputId, "OwnerInfo");
			if(inputPassword.equals(password)) {
				Parent ownerMain = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/OwnerMain.fxml"));
				anchorPane.getChildren().add(ownerMain);
			}
			else {
				System.out.println("관리자의 로그인 정보가 일치하지 않습니다.");
			}
		}
	}

	@FXML public void signUpButtonAction() throws Exception {
		// sign up button을 누르면 signUp.fxml로 이동
		Parent signUp = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/signUp.fxml"));
		anchorPane.getChildren().add(signUp);

		signUp.setTranslateX(signUp.getLayoutX());

		Timeline timeline = new Timeline();
		KeyValue keyValue = new KeyValue(signUp.translateXProperty(), 0);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
	}


	@FXML public void exitButtonAction() {
		System.exit(1);
	}
}