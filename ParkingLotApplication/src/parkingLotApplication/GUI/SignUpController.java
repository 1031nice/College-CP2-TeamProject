package parkingLotApplication.GUI;

import java.io.FileNotFoundException;
import java.io.IOException;
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
import model.Owner;
import model.User;
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
	
	@FXML public void signup() {
		
		// 입력받고
		String inputId = id.getText();
		String inputPassword = pw.getText();
		String inputName = name.getText();
		String inputAge = age.getText();
		String inputAccountNumber = accountnumber.getText();
		String inputCarNumber = carnumber.getText();
		String isIdExist = null; // 아이디 중복 검사용 변수
		
		// 사용자일 경우
		if(isuser.isSelected()) {
			boolean isNonPerson = nonperson.getSelectedToggle().getUserData().equals("true");
			// 아이디 중복 검사
			try {
				isIdExist = AppMain.findId(inputId, "UserInfo");
			} catch (IOException e1) {
				System.out.println("아이디를 찾는 도중 오류가 발생했습니다.");
			}
			// 아이디가 중복되지 않았으면 User 객체 생성후 userController 객체에 전달
			if(isIdExist == null) {
				System.out.println("아이디가 없으니까 만들겠습니다.");
				User user = new User(inputId, inputPassword, inputName, inputAge, inputAccountNumber, inputCarNumber, isNonPerson);
				try {
					userController.signUp(user);
					System.out.println("만들었습니다.");
					StackPane root = (StackPane) anchorPane.getScene().getRoot();
					root.getChildren().remove(anchorPane);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else { // 중복됐으면
				// 경고창
				System.out.println("아이디가 이미 존재합니다. 다시 입력해주세요");
			}
		}
		
		// 관리자일 경우 경우
		else {
			try {
				isIdExist = AppMain.findId(inputId, "UserInfo");
			} catch (IOException e1) {
				System.out.println("아이디를 찾는 도중 오류가 발생했습니다.");
			}
			// 아이디가 중복되지 않았으면 Owner 객체 생성후 uController 객체에 전달
			if(isIdExist == null) {
				System.out.println("아이디가 없으니까 만들겠습니다.");
				Owner owner = new Owner(inputId, inputPassword, inputName, inputAge, inputAccountNumber);
				try {
					ownerController.signUp(owner);
					System.out.println("만들었습니다.");
					StackPane root = (StackPane) anchorPane.getScene().getRoot();
					root.getChildren().remove(anchorPane);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else { // 중복됐으면
				// 경고창
				System.out.println("아이디가 이미 존재합니다. 다시 입력해주세요");
			}
			
		}
		
	}
}
