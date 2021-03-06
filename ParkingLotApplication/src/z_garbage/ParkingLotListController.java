package z_garbage;

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
import model.ParkingLot;
import model.ParkingSpace;
import model.User;
import parkingLotApplication.GUI.AppMain;

public class ParkingLotListController implements Initializable {

	@FXML ListView<String> locationListView;
	@FXML ListView<String> parkingLotListView;
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
			AppMain.communication.user.setParkingLot(new ParkingLot());
			StackPane root = (StackPane) anchorPane.getScene().getRoot();
			Parent userMain = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/UserMain.fxml"));
			root.getChildren().remove(anchorPane);
			root.getChildren().add(userMain);
		}
	}
	
	@FXML public void logoutButtonAction() throws IOException{
		AppMain.communication.user = null;
		StackPane root = (StackPane) anchorPane.getScene().getRoot();
		Parent logout = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/Login.fxml"));
		root.getChildren().remove(anchorPane);
		root.getChildren().add(logout);
	}
	
	@FXML public void exitButtonAction() {
		System.exit(1);
	}

	@SuppressWarnings("null")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1){					
		parkingLotList = FXCollections.observableArrayList();
		locationList = FXCollections.observableArrayList();
		locationListView.setItems(locationList);
		parkingLotListView.setItems(parkingLotList);

//		try {
//			Reader fr = new FileReader("./src/data/OwnerInfo.txt");
//			BufferedReader br = new BufferedReader(fr);
//			String[] ownerInfoArr = new String[100];
//			String[] ownerIdArr = new String[100];
// 			String line = "";
// 			int i =0;
//			while((line = br.readLine()) != null) {
//				ownerInfoArr = line.split(" ");
//				ownerIdArr[i]=ownerInfoArr[0];
//				i++;
//			}
//			br.close(); fr.close();
//			for(String ownerId : ownerIdArr) {
//				Reader fr2 = new FileReader("./src/data/ParkingLotInfo_" + ownerId +".txt");
//				BufferedReader br2 = new BufferedReader(fr2);
//				String[] parkingLotInfoArr;
//				String line2 = "";
//				while((line2 = br2.readLine()) != null) {
//					parkingLotInfoArr = line2.split(" ");
//					locationList.add(parkingLotInfoArr[1]);
//					parkingLotList.add(parkingLotInfoArr[0]);
//				}
//				fr2.close();
//				br2.close();
// 			}
//		} catch (FileNotFoundException e) {e.printStackTrace();}
//		catch (IOException e) {e.printStackTrace();}	

		parkingLotListThread.start();
		locationListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue) {				
				parkingLotListView.getSelectionModel().select(newValue.intValue());
				parkingLotListView.scrollTo(newValue.intValue());
			}
			
		});
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
				
				for(int i = 1; i < idList.size(); i++) {
					if(idList.get(i) == null)
						continue;
					BufferedReader parkingLotReader = new BufferedReader(new FileReader("./src/data/ParkingLotInfo_"+ idList.get(i) +".txt"));
					String parkingLotLine = "";
					String[] parkingLotArray;
					while((parkingLotLine = parkingLotReader.readLine()) != null) {
						parkingLotArray = parkingLotLine.split(" ");
						parkingLotList.add(parkingLotArray[0]);
//						locationList.add(parkingLotArray[1]);
					}
					parkingLotReader.close();
				}
			}catch(IOException e){};
		}	
	});
}