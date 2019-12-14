package z_garbage;

import java.io.IOException;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import model.User;
import parkingLotApplication.GUI.AppMain;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

public class UserChangeInfoController {

	private @FXML AnchorPane anchorPane;
	private @FXML TextField passWord;
	private @FXML TextField name;
	private @FXML TextField age;
	private @FXML TextField phoneNum;
	private @FXML RadioButton truebtn;
	private @FXML RadioButton falsebtn;
	private @FXML TextField carNum;
	private @FXML ToggleGroup nonperson;
	private @FXML Label changeCarNum;
	String error = "";

	@FXML public void changeInfo() {
		User user = AppMain.communication.user;
		if(!passWord.getText().isBlank() == false) {
			user.setPassword((String)passWord.getText());
		}else {
			error += " PassWord ";
		}
		if(!name.getText().isBlank() == false) {
			user.setName((String)name.getText());
		}else {
			error += " Name ";
		}
		if(age.getText().length() > 1 && !age.getText().isBlank() == false) {
			user.setAge((String)age.getText());
		}else {
			error += " Age ";
		}
		if(phoneNum.getText().length() == 11) {
			user.setAccountNumber((String)phoneNum.getText());
		}else {
			error += " phone_Number ";
		}
		user.setNonperson(nonperson.getSelectedToggle().getUserData().equals("true"));
		if(!name.getText().isBlank() == false) {
			user.setCarNumber((String)changeCarNum.getText());
		}else {
			error += " CarNumber ";
		}
		if(error.length() > 0) {
			if(true) {
				AppMain.communication.user = user;
				user = null;
			}else {
				Alert alert = new Alert(Alert.AlertType.ERROR, "전송을 실패하였습니다.", ButtonType.OK );
				Optional<ButtonType> ok = alert.showAndWait();
			}
		}else {
			Alert alert = new Alert(Alert.AlertType.ERROR, error + "에서 오류가 발생하였습니다.", ButtonType.OK );
			Optional<ButtonType> ok = alert.showAndWait();
			error = "";
		}
	}

	@FXML public void userMain() throws IOException{
		StackPane root = (StackPane) anchorPane.getScene().getRoot();
		Parent logout = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/UserMain.fxml"));
		root.getChildren().remove(anchorPane);
		root.getChildren().add(logout);
	}

	@FXML public void logoutAction() throws IOException {
		AppMain.communication.user = null;
		StackPane root = (StackPane) anchorPane.getScene().getRoot();
		Parent logout = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/Login.fxml"));
		root.getChildren().remove(anchorPane);
		root.getChildren().add(logout);
	}

	@FXML public void exitAction() {
		System.exit(1);
	}

}
