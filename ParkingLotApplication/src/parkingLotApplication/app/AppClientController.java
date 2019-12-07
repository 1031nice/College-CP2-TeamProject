package parkingLotApplication.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import model.AppClient;

public abstract class AppClientController {

	String fileName;
	
	public abstract void signUp(AppClient appClient) throws IOException, ClassNotFoundException, FileNotFoundException;
	public abstract void editInfo();
	public abstract void memberSecession();

	
}