package parkingLotApplication.GUI;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.util.Duration;
import javafx.scene.layout.AnchorPane;

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
//		Parent login = FXMLLoader.load(getClass().getResource("parkingLotApplication.GUI."));
	}
	

	@FXML public void signUpButtonAction() throws Exception {
		
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