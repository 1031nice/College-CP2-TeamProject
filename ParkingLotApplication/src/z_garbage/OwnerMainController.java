package z_garbage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;
import parkingLotApplication.GUI.AppMain;

public class OwnerMainController implements Initializable{

	@FXML ListView<String> ownerParkingLotListView;
	@FXML AnchorPane bigAnchorPane;
	@FXML AnchorPane smallAnchorPane;
	@FXML Label banner;
	
	private ObservableList<String> ownerParkingLotList;
	String ownerParkingLotInfo="";
	String[] infoArr = new String[10];

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		banner.setText(AppMain.owner.getName() + "님 환영합니다!");
		
		//오너가 소지한 주차장들의 이름을 리스트에 나열합니다.

		ownerParkingLotList = FXCollections.observableArrayList();
		ownerParkingLotListView.setItems(ownerParkingLotList);
		try {
			BufferedReader br = new BufferedReader(new FileReader("./src/data/ParkingLotInfo_"+AppMain.owner.getId()+".txt"));			
			while((ownerParkingLotInfo = br.readLine()) != null) {
				infoArr = ownerParkingLotInfo.split(" ");
				ownerParkingLotList.add(infoArr[0] + " / 주차장 위치 : " +  infoArr[1]);			
			}
			br.close(); 
		} catch (IOException e) {e.printStackTrace();}

	}
	
	@FXML public void addParkinglotAction() throws Exception{
		Popup popup = new Popup();
		Parent parent = FXMLLoader.load(getClass().getResource("AddParkingLot.fxml"));
		 popup.getContent().add(parent);
		 popup.setAutoHide(true);
		 popup.show(ownerParkingLotListView.getScene().getWindow());		 
	}
	
	@FXML public void ParkingLotListAction() throws Exception{	
		Parent ownerMain = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/OwnerMain.fxml"));
		bigAnchorPane.getChildren().add(ownerMain);
	}
	
	@FXML public void enterParkinglotAction() throws Exception{
		int selectedIndex = ownerParkingLotListView.getSelectionModel().getSelectedIndex();
		if(selectedIndex < 0) {
			new Alert(Alert.AlertType.WARNING, "입장할 주차장을 선택하세요.", ButtonType.CLOSE).show();
			return;
		}
		
	}

	@FXML public void deleteParkinglotAction() {
		int selectedIndex = ownerParkingLotListView.getSelectionModel().getSelectedIndex();
		if(selectedIndex < 0) {
			new Alert(Alert.AlertType.WARNING, "삭제할 항목을 선택하세요.", ButtonType.CLOSE).show();
			return;
		}
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION, " 정말 삭제하시겠습니까?", ButtonType.OK, ButtonType.CANCEL);
		Optional<ButtonType> result = alert.showAndWait();
		if(result.get() == ButtonType.OK) {
			ownerParkingLotList.remove(selectedIndex);
			//오너주차장정보 텍스트파일에서도 해당 주차장정보를 지운다.
		}
		
	}
	
	@FXML public void changeInfoAction() throws Exception{
		Parent ownerChangeInfo = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/OwnerChangeInfo.fxml"));
		smallAnchorPane.getChildren().add(ownerChangeInfo);
	}

	@FXML public void logoutAction() throws Exception{
		StackPane root = (StackPane) bigAnchorPane.getScene().getRoot();
		Parent logout = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/Login.fxml"));
		root.getChildren().remove(bigAnchorPane);
		root.getChildren().add(logout);
	}

	@FXML public void exitAction() {Platform.exit();}


}