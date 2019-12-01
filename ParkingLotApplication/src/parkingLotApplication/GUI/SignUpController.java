package parkingLotApplication.GUI;

import java.io.*;

import java.net.*;
import java.util.*;

import javafx.animation.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.util.*;
import parkingLotApplication.app.*;
import parkingLotApplication.model.*;
import parkingLotApplication.GUI.AppMain;

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
		Parent Login = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/Login.fxml"));
		anchorPane.getChildren().add(Login);
		
		Login.setTranslateX(Login.getLayoutX());
		
		Timeline timeline = new Timeline();
		KeyValue keyValue = new KeyValue(Login.translateXProperty(), 0);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
	}
	
	@FXML public void signup() {
		
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
			// 아이디 중복 검사
			String isIdExist = null;
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
					Parent login = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/Login.fxml"));
					anchorPane.getChildren().add(login);
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
			// 아이디 중복 검사
			// 아이디가 중복됐으면 경고창 실행 후 재입력
			// 아이디가 중복되지 않았으면 Owner 객체 생성후 ownerController 객체에 전달
			/*
			 * 	Owner owner = new Owner(inputId, inputPassword, inputName, inputAge, inputAccountNumber, inputCarNumber, isNonPerson);
				try {
					ownerController.signUp(owner);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			 */
			
		}
		
	}
}
