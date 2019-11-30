package parkingLotApplication.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import parkingLotApplication.model.*;

public class AppMain extends Application {

	User user;
	Owner owner;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("UserMain.fxml"));
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("ParkingLot.css").toString());
		primaryStage.setTitle("주차장 관리 및 대여 시스템");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}