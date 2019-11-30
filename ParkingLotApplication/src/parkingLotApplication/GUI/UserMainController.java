package parkingLotApplication.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class UserMainController {

	@FXML Button reservationButton;
	@FXML Button returnButton;
	@FXML Button paymentButton;
	@FXML Button changeInfoButton;
	@FXML Button logoutButton;
	@FXML Button exitButton;
	@FXML public void reservationAction() {}
	@FXML public void returnAction() {}
	@FXML public void paymentAction() {}
	@FXML public void changeInfoAction() {}
	@FXML public void logoutAction() {}
	@FXML public void exitAction() {
		System.exit(1);
	}

}
