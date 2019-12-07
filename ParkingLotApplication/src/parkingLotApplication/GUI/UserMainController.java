package parkingLotApplication.GUI;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import model.ParkingLot;
import javafx.scene.control.Label;

public class UserMainController implements Initializable{

	@FXML AnchorPane anchorPane;
	@FXML Label userName;
	@FXML Label parkingLotName;
	@FXML Button P1;
	@FXML Button P2;
	@FXML Button P3;
	@FXML Button P4;
	@FXML Button P5;
	@FXML Button P6;
	@FXML Button P7;
	@FXML Button P8;
	
	private ArrayList<ParkingLot> list = new ArrayList<>();
	FileInputStream fis = null;
	BufferedInputStream bis = null;
	ObjectInputStream ois = null;
	
	@FXML public void reservationAction() {
		
	}
	@FXML public void returnAction() {
		
	}
	@FXML public void paymentAction() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION, "결제되었습니다.", ButtonType.OK );
		Optional<ButtonType> ok = alert.showAndWait();
	}
	@FXML public void changeInfoAction() throws IOException {
		StackPane root = (StackPane) anchorPane.getScene().getRoot();
		Parent changeInfo = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/UserChangeInfo.fxml"));
		root.getChildren().remove(anchorPane);
		root.getChildren().add(changeInfo);
	}
	@FXML public void logoutAction() throws IOException {
		AppMain.user = null;
		StackPane root = (StackPane) anchorPane.getScene().getRoot();
		Parent logout = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/Login.fxml"));
		root.getChildren().remove(anchorPane);
		root.getChildren().add(logout);
	}
	@FXML public void exitAction() {
		System.exit(1);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//userName.setText(AppMain.user.getName());
		//parkingLotName.setText(AppMain.user.getParkingLot().getName());
		
	}

}
