package parkingLotApplication.GUI;

import java.io.IOException;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

public class UserMainController {

	@FXML Button reservationButton;
	@FXML Button returnButton;
	@FXML Button paymentButton;
	@FXML Button changeInfoButton;
	@FXML Button logoutButton;
	@FXML Button exitButton;
	@FXML AnchorPane anchorPane;
	@FXML public void reservationAction() {
		
	}
	@FXML public void returnAction() {
		
	}
	@FXML public void paymentAction() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION, "결제되었습니다.", ButtonType.OK );
		Optional<ButtonType> ok = alert.showAndWait();
	}
	@FXML public void changeInfoAction() throws IOException {
		Parent changeInfo = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/UserChangeInfo.fxml"));
		anchorPane.getChildren().add(changeInfo);
	}
	@FXML public void logoutAction() throws IOException {
		Parent login = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/Login.fxml"));
		anchorPane.getChildren().add(login);
	}
	@FXML public void exitAction() {
		System.exit(1);
	}

}
