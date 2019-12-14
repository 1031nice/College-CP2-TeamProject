package parkingLotApplication.GUI;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ParkingLot;

public class AppMain extends Application implements Initializable {

	public static ClientCommunication communication = new ClientCommunication();
	public static ParkingLot other = new ParkingLot();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("ParkingLot.css").toExternalForm());
		primaryStage.setTitle("Sharing ParkingLot Platform");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}