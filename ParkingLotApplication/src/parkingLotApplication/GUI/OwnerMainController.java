package parkingLotApplication.GUI;

import java.net.*;
import java.util.*;

import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import parkingLotApplication.model.*;

public class OwnerMainController implements Initializable{

	@FXML ListView<ParkingLot> parkinglotList;
	@FXML AnchorPane anchorPane;
	@FXML AnchorPane anchorPane2;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//ParkingLotInfo에서 ParkingLotList를 가져와 오너의 아이디랑 일치한 주차장만
		//ParkingLotListView에 띄운다.
		//ListView vs Tableview(지역이랑 주차장이름을 가져와 2열로 만든다.) 고민중

		//버튼 이벤트핸들러
		//button.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyButtonEventHandler());
	}
	
	@FXML public void addParkinglotAction() throws Exception{
		Popup popup = new Popup();
		Parent parent = FXMLLoader.load(getClass().getResource("AddParkingLot.fxml"));
		 popup.getContent().add(parent);
		 popup.setAutoHide(true);
		 popup.show(parkinglotList.getScene().getWindow());		 
	}
	
	@FXML public void enterParkinglotAction() throws Exception{
		Parent parkingLot = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/ParkingLot.fxml"));
		anchorPane2.getChildren().add(parkingLot);
	}

	@FXML public void deleteParkinglotAction() {
		
	}
	
	@FXML public void changeInfoAction() throws Exception{
		
	}

	@FXML public void logoutAction() throws Exception{
		Parent login = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/Login.fxml"));
		anchorPane.getChildren().add(login);
	}

	@FXML public void exitAction() {Platform.exit();}

	

	

}
