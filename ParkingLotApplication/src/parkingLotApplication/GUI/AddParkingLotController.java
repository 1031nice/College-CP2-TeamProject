package parkingLotApplication.GUI;

import java.io.*;
import java.net.*;
import java.util.*;

import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import parkingLotApplication.app.*;
import parkingLotApplication.model.*;

public class AddParkingLotController implements Initializable {

	@FXML TextField parkinglotNameField;
	@FXML TextField feeForTenMinField;
	@FXML TextField parkingLotLocationField;
	@FXML ChoiceBox<String> regionChoiceBox;
	@FXML TextField numOfParkingSpaceField;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> regionComboList = FXCollections.observableArrayList("수도권", "강원도", "충청도", "전라도", "경상도", "제주도");
		regionChoiceBox.setItems(regionComboList);	
	}
	
	@FXML public void parkingLotAddAction() {
		//오너가 입력한 정보를 가지고 ParkingLot객체 생성
		ParkingLot parkingLot = new ParkingLot();
		parkingLot.setName(parkinglotNameField.getText());
		ArrayList parkingSpaceList = new ArrayList();
		for(int i=1; i<=Integer.parseInt(numOfParkingSpaceField.getText()); i++) {
			ParkingSpace parkingSpace = new ParkingSpace();
			parkingSpace.setId("Space" + i);			
			parkingSpaceList.add(parkingSpace);
		}
		parkingLot.setSpaces(parkingSpaceList);
		parkingLot.setFeeForTenMin(Integer.parseInt(feeForTenMinField.getText()));
		parkingLot.setLocation(parkingLotLocationField.getText());
		
		//오너의 아이디는 로그인한 Owner의 ID를 가져와 넘겨줌
		//parkingLot.setownerID();
		
		ParkingLotController pc = new ParkingLotController();
		try {
			pc.addParkingLot(parkingLot);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
