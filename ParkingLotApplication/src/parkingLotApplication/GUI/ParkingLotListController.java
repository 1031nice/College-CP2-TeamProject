package parkingLotApplication.GUI;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import parkingLotApplication.model.ParkingLot;

public class ParkingLotListController implements Initializable {

	@FXML ListView locationListView;
	@FXML ListView parkingLotListView;
	@FXML AnchorPane anchorPane;
	private ObservableList<String> locationList;
	private ObservableList<String> parkingLotList;
	private ArrayList<ParkingLot> list;
	ParkingLot parkingLot;
	FileInputStream fis = null;
	BufferedInputStream bis = null;
	ObjectInputStream ois = null;
	
	
	@FXML public void enterButtonAction() throws IOException{
		int regionSelectedIndex = locationListView.getSelectionModel().getSelectedIndex();
		int parkingLotSelectedIndex = parkingLotListView.getSelectionModel().getSelectedIndex();
		if(regionSelectedIndex < 0 || parkingLotSelectedIndex < 0) {
			new Alert(Alert.AlertType.WARNING, "항목을 선택하세요.", ButtonType.CLOSE).show();
			return ;
		}else {
			parkingLot = list.get(parkingLotSelectedIndex);
			parkingLotListThread.interrupt();
			Parent userMain = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/UserMain.fxml"));
			anchorPane.getChildren().add(userMain);
		}
	}
	
	@FXML public void logoutButtonAction() throws IOException{
		Parent login = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/Login.fxml"));
		anchorPane.getChildren().add(login);
	}
	
	@FXML public void exitButtonAction() {
		System.exit(1);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		locationList = FXCollections.observableArrayList();
		locationListView.setItems(locationList);
		parkingLotList = FXCollections.observableArrayList();
		parkingLotListView.setItems(parkingLotList);
		
		try {
		fis  = new FileInputStream("./src/parkingLotApplication/app/ParkingLotInfo.txt");
		bis = new BufferedInputStream(fis);
		ois = new ObjectInputStream(bis);
		list = (ArrayList<ParkingLot>) ois.readObject();
		
		fis.close();
		bis.close();
		ois.close();
		}  catch (IOException e) {} catch (ClassNotFoundException e) {}
		
		parkingLotListThread.start();
	}
	
	Thread parkingLotListThread = new Thread(new Runnable() {
		@Override
		public void run() {
			for(int i = 0; i < list.size(); i++) {
				locationList.add(list.get(i).getLocation());
				parkingLotList.add(list.get(i).getName());
			}
		}	
	});
}
