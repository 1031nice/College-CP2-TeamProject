package parkingLotApplication.app;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import model.AppClient;
import model.User;

public class UserController extends AppClientController {

	public UserController() {
		this.fileName = "UserInfo";
	}

	@Override
	public void signUp(AppClient appClient) throws IOException, ClassNotFoundException, FileNotFoundException {
		User user =  (User)appClient; // UserController에 들어올 객체는 User이므로 downcast
		Writer writer = new FileWriter("./src/data/" + fileName + ".txt", true);
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

	@Override
	public void editInfo() {
		
		
	}

	@Override
	public void memberSecession() {
		// TODO Auto-generated method stub
		
	}
}
