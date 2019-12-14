package parkingLotApplication.GUI;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import model.User;
import javafx.scene.control.Label;
import model.ParkingLot;
import model.ParkingSpace;
import model.User;
import model.ParkingLot;
import model.ParkingSpace;
import model.User;

public class UserMainController implements Initializable{

	@FXML static AnchorPane anchorPane;
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
	
	private String parkingLotSpace = null;
	private ObservableList<Button> buttonList = FXCollections.observableArrayList(p1,p2,p3,p4,p5,p6,p7,p8);
	
	@FXML public void p1selectSpace() {parkingLotSpace = (String)p1.getText();setButtonColor(p1,AppMain.communication.user);}
	@FXML public void p2selectSpace() {parkingLotSpace = (String)p2.getText();setButtonColor(p2,AppMain.communication.user);}
	@FXML public void p3selectSpace() {parkingLotSpace = (String)p3.getText();setButtonColor(p3,AppMain.communication.user);}
	@FXML public void p4selectSpace() {parkingLotSpace = (String)p4.getText();setButtonColor(p4,AppMain.communication.user);}
	@FXML public void p5selectSpace() {parkingLotSpace = (String)p5.getText();setButtonColor(p5,AppMain.communication.user);}
	@FXML public void p6selectSpace() {parkingLotSpace = (String)p6.getText();setButtonColor(p6,AppMain.communication.user);}
	@FXML public void p7selectSpace() {parkingLotSpace = (String)p7.getText();setButtonColor(p7,AppMain.communication.user);}
	@FXML public void p8selectSpace() {parkingLotSpace = (String)p8.getText();setButtonColor(p8,AppMain.communication.user);}
	
	@FXML public void reservationAction() throws InterruptedException {
		if(parkingLotSpace == null) {
			Alert alert = new Alert(Alert.AlertType.WARNING, "주차장을 선택하여 주십시오!", ButtonType.OK );
			Optional<ButtonType> ok = alert.showAndWait();
		}else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION, parkingLotSpace + "공간을 요청중입니다.", ButtonType.OK );
			Optional<ButtonType> ok = alert.showAndWait();
			int select = Integer.parseInt(parkingLotSpace);
			System.out.println(select + "를 선택하셨습니다");
			AppMain.communication.receive(); // 어떻게 send 보다 receive를 먼저 보장하지?
			Thread.sleep(1000);
			if(AppMain.communication.user.getParkingLot().getSpaces()[select-1].getStatus() == 1)
				System.out.println("다른 주차장을 선택해주세요!");
			else
				System.out.println(select + "번 주차공간이 예약되었습니다!");
			AppMain.communication.user.getParkingLot().spaces[select-1].setStatus(1);
			AppMain.communication.send();
//			boolean request = reservationSpace(AppMain.user);
//			if(request) {
//				alert = new Alert(Alert.AlertType.CONFIRMATION, parkingLotSpace + "자리를 선택하였습니다.", ButtonType.OK);
//			}else if(request) {
//				alert = new Alert(Alert.AlertType.ERROR, "이미 선택된 주차공간입니다.", ButtonType.CANCEL);
//			}
		}
	}
	
	@FXML public void returnAction() {
		if(parkingLotSpace == null) {
			Alert alert = new Alert(Alert.AlertType.WARNING, "주차장을 가지고 있지 않습니다!", ButtonType.OK );
			Optional<ButtonType> ok = alert.showAndWait();
		}else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION, parkingLotSpace + "공간을 반환 요청중입니다.", ButtonType.OK );
			Optional<ButtonType> ok = alert.showAndWait();
//			boolean request = returnSpace(AppMain.communication.user);
//			if(request) {
//				alert = new Alert(Alert.AlertType.CONFIRMATION, parkingLotSpace + "공간을 반환하였습니다.", ButtonType.OK);
//			}else if(request) {
//				alert = new Alert(Alert.AlertType.ERROR, "자리 반환을 실패하였습니다.", ButtonType.CANCEL);
//			}
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
		AppMain.communication.user = null;
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
		userName.setText(AppMain.communication.user.getName());
		for(int i = 0; i < AppMain.communication.user.getParkingLot().getSpaces().length;i++) {
			if(AppMain.communication.user.getParkingLot().getSpaces()[i].getStatus() == 0) {
				buttonList.get(i).setStyle("-fx-background-color:green;");
			}else if (AppMain.communication.user.getParkingLot().getSpaces()[i].getStatus() == 1){
				buttonList.get(i).setStyle("-fx-background-color:red;");
			}
		}
	}
	
	public void setButtonColor(Button button, User user) {
		for(int i = 0; i < AppMain.communication.user.getParkingLot().getSpaces().length;i++) {
			if(AppMain.communication.user.getParkingLot().getSpaces()[i].getStatus() == 0) {
				buttonList.get(i).setStyle("-fx-background-color:green;");
			}else if (AppMain.communication.user.getParkingLot().getSpaces()[i].getStatus() == 1){
				buttonList.get(i).setStyle("-fx-background-color:red;");
			}
		}
		button.setStyle("-fx-background-color:yellow;");
	}
	
	public void setColor() {
		for(int i = 0; i < AppMain.communication.user.getParkingLot().getSpaces().length;i++) {
			if(AppMain.communication.user.getParkingLot().getSpaces()[i].getStatus() == 0) {
				buttonList.get(i).setStyle("-fx-background-color:green;");
			}else if (AppMain.communication.user.getParkingLot().getSpaces()[i].getStatus() == 1){
				buttonList.get(i).setStyle("-fx-background-color:red;");
			}
		}
	}
}
