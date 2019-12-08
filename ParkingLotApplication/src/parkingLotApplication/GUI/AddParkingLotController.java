package parkingLotApplication.GUI;

import java.io.*;
import java.net.URL;
import java.util.*;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class AddParkingLotController implements Initializable {

	@FXML TextField parkinglotNameField;
	@FXML TextField parkingLotLocationField;
	@FXML TextField feeForTenMinField;
	@FXML TextField numOfParkingSpaceField;
	@FXML VBox addParkingLotVbox;
	
	Writer writer = null;
	String ownerParkingLotInfo;
	String parkingLotSpace = "0";
	int numOfParkingSpace;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)  {

	}
	
	@FXML public void addParkingLotAction() throws Exception {
		
		//해당 정보들을 오너주차장 정보 텍스트파일에 넣는다.
		writer  = new FileWriter("./src/data/ParkingLotInfo_" + AppMain.owner.getId() + ".txt", true);
		numOfParkingSpace = Integer.parseInt(numOfParkingSpaceField.getText());
		for(int i = 0; i < numOfParkingSpace-1; i++) {
			parkingLotSpace += "0";
		}
		ownerParkingLotInfo =  "\n" + parkinglotNameField.getText() + " " + parkingLotLocationField.getText() + " " + feeForTenMinField.getText() + " " + parkingLotSpace;
				
		char[] data = ownerParkingLotInfo.toCharArray();
		writer.write(data);		
		writer.flush();
		writer.close(); 		
		
		Alert alert = new Alert(Alert.AlertType.INFORMATION, "주차장 등록이 완료되었습니다.", ButtonType.CLOSE);
		Optional<ButtonType> result = alert.showAndWait();
		if(result.get() == ButtonType.CLOSE) {
			new Alert(Alert.AlertType.INFORMATION, "주차장 목록을 눌러 새로고침 해주세요.", ButtonType.CLOSE).show();
		}
		
		//보류 코드
		//오너가 입력한 정보를 가지고 ParkingLot객체 생성
		/*
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
		
	}

}
