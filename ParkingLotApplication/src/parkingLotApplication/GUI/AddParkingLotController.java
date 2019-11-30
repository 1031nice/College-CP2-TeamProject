package parkingLotApplication.GUI;

import javafx.fxml.*;
import javafx.scene.control.*;

public class AddParkingLotController {

	@FXML TextField parkinglotNameField;
	@FXML ChoiceBox<String> regionChoice;
	@FXML TextField numOfParkinglotField;
	@FXML TextField feeForTenMinField;
	@FXML TextField parkingLotLocationField;

	@FXML public void parkingLotAddAction() {
		//오너가 입력한 정보를 가지고 ParkingLot객체 생성
		//오너의 아이디는 로그인정보에서 가져와 넘겨줌
	}

}
