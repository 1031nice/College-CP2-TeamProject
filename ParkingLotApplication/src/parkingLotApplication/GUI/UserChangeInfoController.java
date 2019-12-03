package parkingLotApplication.GUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class UserChangeInfoController {

	@FXML AnchorPane anchorPane;

	@FXML public void changeInfo() {}

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
