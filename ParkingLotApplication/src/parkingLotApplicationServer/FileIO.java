package parkingLotApplicationServer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import javafx.scene.layout.StackPane;
import model.AppClient;
import model.Owner;
import model.ParkingLot;
import model.ParkingSpace;
import model.User;

public class FileIO {

	public static boolean findId(String id) throws IOException {
		Reader reader = new FileReader("./src/data/UserInfo.txt");
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = "";
		String[] array;
		while((line = bufferedReader.readLine()) != null) {
			array = line.split(" ");
			if(array[0].compareTo(id) == 0) {
				return true;
			}
		}
		reader.close();
		bufferedReader.close();
		return false;
	}

	public static boolean find(String id, String pw) throws IOException {
		Reader reader = new FileReader("./src/data/UserInfo.txt");
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = "";
		String[] array;
		while((line = bufferedReader.readLine()) != null) {
			array = line.split(" ");
			if(array[0].compareTo(id) == 0) {
				if(array[1].compareTo(pw) == 0) {
					reader.close();
					bufferedReader.close();
					return true;
				}
			}
		}
		reader.close();
		bufferedReader.close();
		return false;
	}

	public static AppClient getAppClientDataFromFile(String id, String userType) throws IOException {
		AppClient appClient = null;
		if(userType.equals("User")) {
			Reader reader = new FileReader("./src/data/" + "UserInfo.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line = "";
			String[] array;
			while((line = bufferedReader.readLine()) != null) {
				array = line.split(" ");
				if(array[0].equals(id)) {
					appClient = new User(array[0], array[1], array[2], array[3], array[4], array[5], Boolean.parseBoolean(array[6]));
					appClient.setParkingLot(new ParkingLot());
					ParkingSpace[] spaces = new ParkingSpace[8];
					for(int i=0; i<spaces.length; i++) {
						spaces[i] = new ParkingSpace();
					}
					appClient.getParkingLot().setSpaces(spaces);
					break;
				}
			}			
			reader.close();
			bufferedReader.close();
		}
		return appClient;
	}

	public static void signUp(String id, String pw, String name, String age,
			String accountNumber, String carNumber, boolean isNonPerson) throws IOException {
		User user = new User(id, pw, name, age, accountNumber, carNumber, isNonPerson);
		Writer writer = new FileWriter("./src/data/UserInfo.txt", true);
		writer.write(user.getId().toCharArray());
		writer.write(' ');
		writer.write(user.getPassword().toCharArray());
		writer.write(' ');
		writer.write(user.getName().toCharArray());
		writer.write(' ');
		writer.write(user.getAge().toCharArray());
		writer.write(' ');
		writer.write(user.getAccountNumber().toCharArray());		
		writer.write(' ');
		writer.write(user.getCarNumber().toCharArray());
		writer.write(' ');
		writer.write(String.valueOf(user.getNonperson()).toCharArray());
		writer.append('\n');
		writer.flush();
		writer.close();
	}
}