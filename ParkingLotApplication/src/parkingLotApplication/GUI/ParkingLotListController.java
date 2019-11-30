package parkingLotApplication.GUI;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class ParkingLotListController {

	@FXML ListView regionList;
	@FXML ListView parkingLotList;
	@FXML AnchorPane anchorPane;
	
	@FXML public void enterButtonAction() {
		
	}
	
	@FXML public void logoutButtonAction() throws Exception{
		Parent login = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/Login.fxml"));
		anchorPane.getChildren().add(login);
	}
	
	@FXML public void exitButtonAction() {
		System.exit(1);
	}

}
