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
import parkingLotApplication.model.ParkingLot;
import javafx.scene.control.Label;

public class UserMainController implements Initializable{

	@FXML Button reservationButton;
	@FXML Button returnButton;
	@FXML Button paymentButton;
	@FXML Button changeInfoButton;
	@FXML Button logoutButton;
	@FXML Button exitButton;
	@FXML AnchorPane anchorPane;
	@FXML Label userName;
	@FXML Label parkingLotName;
	private ArrayList<ParkingLot> list;
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
		Parent changeInfo = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/UserChangeInfo.fxml"));
		anchorPane.getChildren().add(changeInfo);
	}
	@FXML public void logoutAction() throws IOException {
		Parent login = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/Login.fxml"));
		anchorPane.getChildren().add(login);
	}
	@FXML public void exitAction() {
		System.exit(1);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			fis  = new FileInputStream("./src/parkingLotApplication/app/ClientInfo.txt");
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			list = (ArrayList<ParkingLot>) ois.readObject();
			
			fis.close();
			bis.close();
			ois.close();
		}  catch (IOException e) {} catch (ClassNotFoundException e) {}
		
		for(int i = 0; i < list.size(); i++) {
			if(user.getName().equls(list.get(i).getName())) {
				userName.setText(user.getName());
			}
			if() {
				
			}
		}
	}
}