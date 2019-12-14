package parkingLotApplication.GUI;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import parkingLotApplication.app.OwnerController;
import parkingLotApplication.app.UserController;

public class SignUpController implements Initializable{

	@FXML TextField id;
	@FXML TextField pw;
	@FXML TextField name;
	@FXML TextField age;
	@FXML TextField accountnumber;
	@FXML ToggleGroup nonperson;
	@FXML TextField carnumber;
	@FXML RadioButton truebtn;
	@FXML RadioButton falsebtn;
	@FXML AnchorPane anchorPane;
	@FXML RadioButton isuser;

	OwnerController ownerController = new OwnerController();
	UserController userController = new UserController();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		isuser.onMouseClickedProperty().set(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(truebtn.isDisable()) {
					truebtn.setDisable(false);
					falsebtn.setDisable(false);
					carnumber.setDisable(false);
				} else {
					truebtn.setDisable(true);
					falsebtn.setDisable(true);
					carnumber.setDisable(true);
				}
			}		
		});
		
	}
	
	@FXML public void backbutton() throws Exception{
		StackPane root = (StackPane) anchorPane.getScene().getRoot();
		root.getChildren().remove(anchorPane);
	}
	
	@FXML public void signup() throws InterruptedException {
		
		// 입력받고
		String inputId = id.getText();
		String inputPassword = pw.getText();
		String inputName = name.getText();
		String inputAge = age.getText();
		String inputAccountNumber = accountnumber.getText();
		String inputCarNumber = carnumber.getText();
		boolean isNonPerson = nonperson.getSelectedToggle().getUserData().equals("true");
		
		// 사용자일 경우
		if(isuser.isSelected()) {
			AppMain.communication.sendInfo(inputId, inputPassword, inputName, inputAge, inputAccountNumber, inputCarNumber, isNonPerson);
			AppMain.communication.checkReceive();
			if(AppMain.communication.user == null) {
				System.out.println("이미 존재하는 아이디입니다");
			}
			Thread.sleep(1000);
			StackPane root = (StackPane) anchorPane.getScene().getRoot();
			root.getChildren().remove(anchorPane);
		}
	
	}

}
