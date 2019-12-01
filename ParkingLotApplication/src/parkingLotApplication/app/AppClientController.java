package parkingLotApplication.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import parkingLotApplication.model.AppClient;

public abstract class AppClientController {

	String fileName;
	
	public abstract void signUp(AppClient appClient) throws IOException, ClassNotFoundException, FileNotFoundException;
	public abstract void editInfo();
	public abstract void memberSecession();
	public boolean findId(String id) throws IOException {
		Reader reader = new FileReader("./src/data/" + fileName +".txt");
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = "";
		String[] array;
		while((line = bufferedReader.readLine()) != null) {
			array = line.split(" ");
			if(array[0].equals(id)) {
				// test
				for(String str : array) {
					System.out.println(str);
				}
				reader.close();
				bufferedReader.close();
				return true;
			}
		}
		reader.close();
		bufferedReader.close();
		return false;
	}
	
}