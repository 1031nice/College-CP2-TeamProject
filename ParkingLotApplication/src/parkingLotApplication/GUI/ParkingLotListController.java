package parkingLotApplication.GUI;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import parkingLotApplication.model.ParkingLot;

public class ParkingLotListController implements Initializable {

	@FXML ListView locationListView;
	@FXML ListView parkingLotListView;
	@FXML AnchorPane anchorPane;
	private ObservableList<String> locationList;
	private ObservableList<String> parkingLotList;
	private ArrayList<ParkingLot> list;
	private ArrayList<String> idList = new ArrayList<>();
	private int parkingLotSelectedIndex;
	
	@FXML public void enterButtonAction() throws IOException{
		int parkingLotSelectedIndex = parkingLotListView.getSelectionModel().getSelectedIndex();
		if(parkingLotSelectedIndex < 0) {
			new Alert(Alert.AlertType.WARNING, "항목을 선택하세요.", ButtonType.CLOSE).show();
			return ;
		}else {
			AppMain.user.setParkingLotName(parkingLotList.get(parkingLotSelectedIndex));
			//AppMain.user.setParkingLot("");
			StackPane root = (StackPane) anchorPane.getScene().getRoot();
			Parent userMain = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/UserMain.fxml"));
			root.getChildren().remove(anchorPane);
			root.getChildren().add(userMain);
		}
	}
	
	@FXML public void logoutButtonAction() throws IOException{
		AppMain.user = null;
		StackPane root = (StackPane) anchorPane.getScene().getRoot();
		Parent logout = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/Login.fxml"));
		root.getChildren().remove(anchorPane);
		root.getChildren().add(logout);
	}
	
	@FXML public void exitButtonAction() {
		System.exit(1);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		parkingLotList = FXCollections.observableArrayList();
		parkingLotListView.setItems(parkingLotList);
		locationList = FXCollections.observableArrayList();
		locationListView.setItems(locationList);
		parkingLotListThread.start();
	}
	
	Thread parkingLotListThread = new Thread(new Runnable() {
		@Override
		public void run(){
			
			try {
				BufferedReader ownerIdReader = new BufferedReader(new FileReader("./src/data/OwnerInfo.txt"));
				String ownerIdLine = "";
				String[] ownerIdArray;
				while((ownerIdLine = ownerIdReader.readLine()) != null) {
					ownerIdArray = ownerIdLine.split(" ");
					idList.add(ownerIdArray[0]);
				}
				ownerIdReader.close();
				
				for(int i = 0; i < idList.size();i++) {
					BufferedReader parkingLotReader = new BufferedReader(new FileReader("./src/data/ParkingLotInfo_"+ idList.get(i) +".txt"));
					String parkingLotLine = "";
					String[] parkingLotArray;
					while((parkingLotLine = parkingLotReader.readLine()) != null) {
						parkingLotArray = parkingLotLine.split(" ");
						parkingLotList.add(parkingLotArray[0]);
						locationList.add(parkingLotArray[1]);
					}
					parkingLotReader.close();
				}
			}catch(IOException e){};
		}	
	});
}