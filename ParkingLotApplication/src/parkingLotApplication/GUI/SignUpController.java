package parkingLotApplication.GUI;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class SignUpController {

	@FXML TextField id;
	@FXML TextField pw;
	@FXML TextField name;
	@FXML TextField age;
	@FXML TextField phonenumber;
	@FXML ToggleGroup userposition;
	@FXML ToggleGroup nonperson;
	@FXML TextField carnumber;
	@FXML TextField parkinglotposition;
	@FXML TextField parkinglotnum;
	@FXML AnchorPane anchorPane;
	@FXML public void backbutton() throws Exception{
		Parent Login = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/Login.fxml"));
		anchorPane.getChildren().add(Login);
		
		Login.setTranslateX(Login.getLayoutX());
		
		Timeline timeline = new Timeline();
		KeyValue keyValue = new KeyValue(Login.translateXProperty(), 0);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
	}
	@FXML public void signup() {
		String ID = id.getText();
		String PW = pw.getText();
		String Name = name.getText();
		String Age = age.getText();
		String PhoneNumber = phonenumber.getText();
		if(토글 관리자 사람) {
			
			if(빈문자열체크) {
				if() {
				
				}else if() {
				
				}
			}else if{
				if() {
				
				}else if() {
				
				}
			}
		}else {
			
		}
	}

}
