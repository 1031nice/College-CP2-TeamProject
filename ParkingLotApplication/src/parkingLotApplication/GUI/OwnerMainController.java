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
	}
	
	@FXML public void addParkinglotAction() throws Exception{
		Popup popup = new Popup();
		Parent parent = FXMLLoader.load(getClass().getResource("AddParkingLot.fxml"));
		 popup.getContent().add(parent);
		 popup.setAutoHide(true);
		 popup.show(parkinglotList.getScene().getWindow());		 
	}
	
	@FXML public void ParkingotListAction() throws Exception{
		Parent ownerMain = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/OwnerMain.fxml"));
		anchorPane.getChildren().add(ownerMain);
	}
	
	@FXML public void enterParkinglotAction() throws Exception{
		//Owner가 선택한 주차장이 가지고 있는 레이아웃 필드를 anchorpane에 띄운다.
		
	}

	@FXML public void deleteParkinglotAction() {
		//ListView에서 해당 주차장을 지운다.
		
	}
	
	@FXML public void changeInfoAction() throws Exception{
		Parent ownerChangeInfo = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/OwnerChangeInfo.fxml"));
		anchorPane2.getChildren().add(ownerChangeInfo);
	}

	@FXML public void logoutAction() throws Exception{
		Parent login = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/Login.fxml"));
		anchorPane.getChildren().add(login);
	}

	@FXML public void exitAction() {Platform.exit();}

	

	

}
