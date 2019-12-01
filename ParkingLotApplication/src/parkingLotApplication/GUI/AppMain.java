package parkingLotApplication.GUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import parkingLotApplication.model.*;

public class AppMain extends Application {

	public static User user;
	public static Owner owner;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("ParkingLot.css").toString());
		primaryStage.setTitle("주차장 관리 및 대여 시스템");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public static String findId(String id, String fileName) throws IOException {
		Reader reader = new FileReader("./src/data/" + fileName +".txt");
		BufferedReader bufferedReader = new BufferedReader(reader);
		String password;
		String line = "";
		String[] array;
		while((line = bufferedReader.readLine()) != null) {
			array = line.split(" ");
			if(array[0].equals(id)) {
				password = array[1];
				reader.close();
				bufferedReader.close();
				return password;
			}
		}
		reader.close();
		bufferedReader.close();
		return null;
	}
}