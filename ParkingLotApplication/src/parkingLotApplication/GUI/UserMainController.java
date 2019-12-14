package parkingLotApplication.GUI;

import java.io.IOException;
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
	Button[] buttonArray = new Button[8];
	int select = 0;

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
			select = Integer.parseInt(parkingLotSpace);
			System.out.println(select + "를 선택하셨습니다");
			//			AppMain.communication.receive(); // 어떻게 send 보다 receive를 먼저 보장하지?
			//			Thread.sleep(1000);
			if(AppMain.communication.user.getParkingLot().getSpaces()[select-1].getStatus() == 1)
				System.out.println("다른 주차장을 선택해주세요!");
			else {
				System.out.println(select + "번 주차공간이 예약되었습니다!");
				//
				AppMain.communication.user.getParkingLot().spaces[select-1].setStatus(1);
				AppMain.communication.send();
			}
		}
	}

	@FXML public void returnAction() {
		if(parkingLotSpace == null) {
			Alert alert = new Alert(Alert.AlertType.WARNING, "반납할 주차장을 선택해주십시오.", ButtonType.OK );
			Optional<ButtonType> ok = alert.showAndWait();
		}
		else {
			select = Integer.parseInt(parkingLotSpace);
		}
		if(AppMain.communication.user.getParkingLot().getSpaces()[select-1].getStatus() == 0){
			Alert alert = new Alert(Alert.AlertType.INFORMATION, "자신의 주차공간이 아닙니다.", ButtonType.OK );
			Optional<ButtonType> ok = alert.showAndWait();
		}
		else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION, parkingLotSpace + "반납 요청중입니다.", ButtonType.OK );
			Optional<ButtonType> ok = alert.showAndWait();
			select = Integer.parseInt(parkingLotSpace);
			System.out.println(select + "를 선택하셨습니다");
			AppMain.communication.user.getParkingLot().spaces[select-1].setStatus(0);
			AppMain.communication.send();
			System.out.println(select + "번 주차공간이 반납되었습니다!");
		}
	}

	@FXML public void paymentAction() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION, "결제되었습니다.", ButtonType.OK );
		Optional<ButtonType> ok = alert.showAndWait();
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

	//	@Override
	//	public void initialize(URL arg0, ResourceBundle arg1) {
	//		userName.setText(AppMain.communication.user.getName());
	//		for(int i = 0; i < AppMain.communication.user.getParkingLot().getSpaces().length;i++) {
	//			if(AppMain.communication.user.getParkingLot().getSpaces()[i].getStatus() == 0) {
	//				buttonList.get(i).setStyle("-fx-background-color:green;");
	//			}else if (AppMain.communication.user.getParkingLot().getSpaces()[i].getStatus() == 1){
	//				buttonList.get(i).setStyle("-fx-background-color:red;");
	//			}
	//		}
	//	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		buttonArray[0] = p1;
		buttonArray[1] = p2;
		buttonArray[2] = p3;
		buttonArray[3] = p4;
		buttonArray[4] = p5;
		buttonArray[5] = p6;
		buttonArray[6] = p7;
		buttonArray[7] = p8;
		userName.setText(AppMain.communication.user.getName());
		setColor();
	}

	public void setButtonColor(Button button, User user) {
		for(int i = 0; i < AppMain.communication.user.getParkingLot().getSpaces().length;i++) {
			if(AppMain.communication.user.getParkingLot().getSpaces()[i].getStatus() == 0) {
				buttonArray[i].setStyle("-fx-background-color:green;");
			}else if (AppMain.communication.user.getParkingLot().getSpaces()[i].getStatus() == 1){
				buttonArray[i].setStyle("-fx-background-color:red;");
			}
		}
		button.setStyle("-fx-background-color:yellow;");
	}

	public void setColor() {
		for(int i = 0; i < AppMain.communication.user.getParkingLot().getSpaces().length;i++) {
			if(AppMain.communication.user.getParkingLot().getSpaces()[i].getStatus() == 0) {
				buttonArray[i].setStyle("-fx-background-color:green;");
			}else if (AppMain.communication.user.getParkingLot().getSpaces()[i].getStatus() == 1){
				buttonArray[i].setStyle("-fx-background-color:red;");
			}
		}
	}
}
