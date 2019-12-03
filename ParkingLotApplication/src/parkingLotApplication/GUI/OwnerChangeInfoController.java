package parkingLotApplication.GUI;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class OwnerChangeInfoController {

	@FXML TextField passwordField;
	@FXML TextField nameField;
	@FXML TextField ageField;
	@FXML TextField accountNumField;
	@FXML AnchorPane anchorPane;

	@FXML public void changeInfoBtn() throws Exception {
		Parent ownerMain = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/OwnerMain.fxml"));
		anchorPane.getChildren().add(ownerMain);
		
		//OwnerInfo 정보변경
	}

}
