package parkingLotApplication.GUI;

import java.io.*;
import java.net.*;
import java.util.*;

import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import parkingLotApplication.app.*;
import parkingLotApplication.model.*;

public class AddParkingLotController implements Initializable {

	@FXML TextField parkinglotNameField;
	@FXML TextField feeForTenMinField;
	@FXML TextField parkingLotLocationField;
	@FXML ChoiceBox<String> regionChoiceBox;
	@FXML TextField numOfParkingSpaceField;
	@FXML VBox addParkingLotVbox;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> regionComboList = FXCollections.observableArrayList("수도권", "강원도", "충청도", "전라도", "경상도", "제주도");
		regionChoiceBox.setItems(regionComboList);	
	}
	
	@FXML public void parkingLotAddAction() {
		//오너가 입력한 정보를 가지고 ParkingLot객체 생성
		ParkingLot parkingLot = new ParkingLot();
		
		parkingLot.setName(parkinglotNameField.getText());	
		
		ArrayList parkingSpaceList = new ArrayList();											//주차장객체 생성하면서 그에 해당하는 레이아웃(주차장 모습) 생성
		int numOfPS = Integer.parseInt(numOfParkingSpaceField.getText());
		
		VBox vbox = new VBox();
		vbox.setPrefSize(450, 400);
		vbox.setSpacing(200);
		vbox.setStyle("-fx-background-color: silver");
		HBox aboveHbox = new HBox();
		aboveHbox.setPrefSize(450,100);
		HBox belowHbox = new HBox();
		belowHbox.setPrefSize(450,100);
		vbox.getChildren().addAll(aboveHbox,belowHbox);
		
		for(int i=1; i<=numOfPS; i++) {
			ParkingSpace parkingSpace = new ParkingSpace();
			parkingSpace.setId("Space" + i);
			
			Button button = new Button();
			button.setText("Space" + i);
			HBox.setHgrow(button, Priority.ALWAYS);
			button.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
			if( (numOfPS/2) >= i) { aboveHbox.getChildren().add(button); }
			else { belowHbox.getChildren().add(button); }
			
			parkingSpaceList.add(parkingSpace);
		}
		parkingLot.setParkingLotLayout(vbox);
		
		//레이아웃이 잘 만들어졌나 보기위해 임시로 만든코드//////////////////////////////////////////
		addParkingLotVbox.getChildren().add(vbox);					
		////////////////////////////////////////////////////////////////////////////////////////////////////
		
		parkingLot.setSpaces(parkingSpaceList);
		
		int feeForTenMin = Integer.parseInt(feeForTenMinField.getText());
		parkingLot.setFeeForTenMin(feeForTenMin);
		parkingLot.setLocation(parkingLotLocationField.getText());
		parkingLot.setRegion(regionChoiceBox.getValue());
		
		ParkingLotController pc = new ParkingLotController();
		
		/*
		try {
			pc.addParkingLot(parkingLot);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		*/
		
		//주차장목록으로 가는코드
	}

}
