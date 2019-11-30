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
<<<<<<< HEAD
	
	// 돌아가기 버튼을 누를 경우 다시 Login.fxml로
=======
	@FXML RadioButton isuser;
	OwnerController oc = new OwnerController();
	UserController uc = new UserController();
	ArrayList<String> idList = new ArrayList<>();  // 아이디 중복 확인을 위한 아이디저장리스트
	boolean signUpFlag; //아이디가 중복이 안됐으면 true를 리턴해 회원가입을 정상적으로 실행
	
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
	
>>>>>>> dfecc9c4b21c4fd379f249aa09990f594630d479
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
		String ID = id.getText();
		String PW = pw.getText();
		String Name = name.getText();
		String Age = age.getText();
<<<<<<< HEAD
		String PhoneNumber = phonenumber.getText();
		
		// 예외처리도 해야하고
		
		// 파일에 저장해야 함 그리고는 다시 Login.fxml로

	}
=======
		String AccountNumber = accountnumber.getText();
		
		for(String id : idList) {                 //아이디 중복 검사
			if(id.equals(ID)) {
				signUpFlag=false;
			}
		}
		if(!signUpFlag) {
			//"아이디가 중복됐습니다. 다른 아이디를 입력해주세요." 경고창 실행 
		}else {
			if(isuser.isSelected()) { 						
				User user = new User();
				user.setId(ID);
				user.setPassword(PW);
				user.setName(Name);
				user.setAge(Age);
				user.setAccountNumber(AccountNumber);
				user.setCarNumber(carnumber.getText());
				if(nonperson.getSelectedToggle().getUserData().equals("true")) { user.setNonperson(true); } 
				else { user.setNonperson(false); }
				
				try {
					uc.signUp(user);
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
	
			} else {
				Owner owner = new Owner();
				owner.setId(ID);
				owner.setPassword(PW);
				owner.setName(Name);
				owner.setAge(Age);
				owner.setAccountNumber(AccountNumber);
						
				try {
					oc.signUp(owner);
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}
		}
>>>>>>> dfecc9c4b21c4fd379f249aa09990f594630d479

	}
}
