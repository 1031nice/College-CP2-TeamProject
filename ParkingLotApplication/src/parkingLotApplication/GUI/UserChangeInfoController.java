package parkingLotApplication.GUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import parkingLotApplication.model.User;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;

public class UserChangeInfoController {

	@FXML AnchorPane anchorPane;
	@FXML TextField passWord;
	@FXML TextField name;
	@FXML TextField age;
	@FXML TextField phoneNum;
	@FXML RadioButton truebtn;
	@FXML RadioButton falsebtn;
	@FXML TextField carNum;

	@FXML public void changeInfo() {
		User user = AppMain.user;
		user.setPassword((String)passWord.getText());
		user.setName((String)name.getText());
		user.setAge((String)age.getText());
		user.setAccountNumber((String)phoneNum.getText());
	}

	@FXML public void userMain() throws IOException{
		StackPane root = (StackPane) anchorPane.getScene().getRoot();
		Parent logout = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/UserMain.fxml"));
		root.getChildren().remove(anchorPane);
		root.getChildren().add(logout);
	}

	@FXML public void logoutAction() throws IOException {
		AppMain.user = null;
		StackPane root = (StackPane) anchorPane.getScene().getRoot();
		Parent logout = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/Login.fxml"));
		root.getChildren().remove(anchorPane);
		root.getChildren().add(logout);
	}

	@FXML public void exitAction() {
		System.exit(1);
	}

}
