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
import parkingLotApplication.model.ParkingLot;
import parkingLotApplication.model.User;
import javafx.scene.control.Label;

public class UserMainController implements Initializable{

	@FXML AnchorPane anchorPane;
	@FXML Label userName;
	@FXML Label parkingLotName;
	@FXML Button p1;
	@FXML Button p2;
	@FXML Button p3;
	@FXML Button p4;
	@FXML Button p5;
	@FXML Button p6;
	@FXML Button p7;
	@FXML Button p8;
	
	FileInputStream fis = null;
	BufferedInputStream bis = null;
	ObjectInputStream ois = null;
	String parkingLotSpace = null;
	
	@FXML public void p1selectSpace() {parkingLotSpace = (String)p1.getText();}
	@FXML public void p2selectSpace() {parkingLotSpace = (String)p2.getText();}
	@FXML public void p3selectSpace() {parkingLotSpace = (String)p3.getText();}
	@FXML public void p4selectSpace() {parkingLotSpace = (String)p4.getText();}
	@FXML public void p5selectSpace() {parkingLotSpace = (String)p5.getText();}
	@FXML public void p6selectSpace() {parkingLotSpace = (String)p6.getText();}
	@FXML public void p7selectSpace() {parkingLotSpace = (String)p7.getText();}
	@FXML public void p8selectSpace() {parkingLotSpace = (String)p8.getText();}
	
	
	@FXML public void reservationAction() {
		if(parkingLotSpace == null) {
			Alert alert = new Alert(Alert.AlertType.WARNING, "주차장을 선택하여 주십시오!", ButtonType.OK );
			Optional<ButtonType> ok = alert.showAndWait();
		}else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION, parkingLotSpace + "공간을 요청중입니다.", ButtonType.OK );
			Optional<ButtonType> ok = alert.showAndWait();
			boolean request = reservationSpace(AppMain.user);
			if(request) {
				alert = new Alert(Alert.AlertType.CONFIRMATION, parkingLotSpace + "자리를 선택하였습니다.", ButtonType.OK);
			}else if(request) {
				alert = new Alert(Alert.AlertType.ERROR, "이미 선택된 주차공간입니다.", ButtonType.CANCEL);
			}
		}
	}
	
	@FXML public void returnAction() {
		if(parkingLotSpace == null) {
			Alert alert = new Alert(Alert.AlertType.WARNING, "주차장을 가지고 있지 않습니다!", ButtonType.OK );
			Optional<ButtonType> ok = alert.showAndWait();
		}else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION, parkingLotSpace + "공간을 반환 요청중입니다.", ButtonType.OK );
			Optional<ButtonType> ok = alert.showAndWait();
			boolean request = returnSpace(AppMain.user);
			if(request) {
				alert = new Alert(Alert.AlertType.CONFIRMATION, parkingLotSpace + "공간을 반환하였습니다.", ButtonType.OK);
			}else if(request) {
				alert = new Alert(Alert.AlertType.ERROR, "자리 반환을 실패하였습니다.", ButtonType.CANCEL);
			}
		}
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
		userName.setText(AppMain.user.getName());
		parkingLotName.setText(AppMain.user.getParkingLotName());	
	}

	private boolean reservationSpace(User user) {
		
		return true;
	}
	
	private boolean returnSpace(User user) {
		
		return true;
	}
}
