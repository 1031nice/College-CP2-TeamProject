package parkingLotApplication.GUI;

import java.io.*;
import java.util.*;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.util.Duration;
import parkingLotApplication.model.*;
import javafx.scene.layout.AnchorPane;

public class LoginController {

	@FXML Button loginButton;
	@FXML TextField idTextField;
	@FXML PasswordField pwTextField;
	@FXML RadioButton appClient;
	@FXML ToggleGroup type;
	@FXML RadioButton owner;
	@FXML Button exitButton;
	@FXML Button signUpButton;
	@FXML AnchorPane anchorPane;
	
	ObjectInputStream ownerois = null;
	BufferedInputStream ownerbis = null;
	FileInputStream ownerfis = null;	
	ObjectInputStream userois = null;
	BufferedInputStream userbis = null;
	FileInputStream userfis = null;	
	ArrayList<Owner> ownerList;
	ArrayList<User> userList;
	boolean loginFlag = false;						//아이디와 비밀번호 모두 일치하면 true
	boolean isCorrectID = false;					//아이디는 맞고 비밀번호는 틀린경우 true
	
	@FXML public void loginButtonAction() throws Exception {
		if(type.getSelectedToggle()==null)
			//"앱 사용자 종류를 선택해주세요" 경고창
			return;
		if(type.getSelectedToggle().getUserData().equals("고객")) {
			Parent ParkingLotList = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/ParkingLotList.fxml"));
			anchorPane.getChildren().add(ParkingLotList);
		}else {
			Parent ownerMain = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/OwnerMain.fxml"));
			anchorPane.getChildren().add(ownerMain);
		}
		//로그인이 정상적으로 되기까지 화면이동을 위해 만든 임시코드입니다.
		//로그인하고 나서 사용자 객체 생성해주세요. 고객은 user, 관리자는 client
		/*
		if(type.getSelectedToggle().getUserData().equals("고객")) {
			
			userfis  = new FileInputStream("./src/parkingLotApplication/app/UserInfo.txt");
			userbis = new BufferedInputStream(userfis);
			userois = new ObjectInputStream(userbis);
			userList = (ArrayList<User>) userois.readObject();
			for(User user : userList) {                
				if( user.getId().equals(idTextField.getText()) ) {
					if( user.getPassword().equals(pwTextField.getText()) ) {
						loginFlag=true;
						break;
					}else {
						isCorrectID=true; 
						break;
					}					
				}
			}
			userfis.close(); userbis.close(); userois.close();
			if(!loginFlag) {
				if(isCorrectID) {
				//"패스워드를 잘못 입력하셨습니다" 경고창
				}else {
					//"아이디를 잘못 입력하셨습니다" 경고창
				}
			} else {
			
				//주차장 목록으로 화면 이동
				//Parent login = FXMLLoader.load(getClass().getResource("parkingLotApplication.GUI."));
			
			}
		} else {
			ownerfis  = new FileInputStream("./src/parkingLotApplication/app/OwnerInfo.txt");
			ownerbis = new BufferedInputStream(ownerfis);
			ownerois = new ObjectInputStream(ownerbis);
			ownerList = (ArrayList<Owner>) ownerois.readObject();
			for(Owner owner : ownerList) {                
				if( owner.getId().equals(idTextField.getText()) ) {
					if( owner.getPassword().equals(pwTextField.getText()) ) {
						loginFlag=true;
						break;
					}else {
						isCorrectID=true; 
						break;
					}					
				}
			}
			ownerfis.close(); ownerbis.close(); ownerois.close();
			if(!loginFlag) {
				if(isCorrectID) {
				//"패스워드를 잘못 입력하셨습니다" 경고창
				}else {
				//"아이디를 잘못 입력하셨습니다" 경고창
				}
			} else {
			
				Parent ownerMain = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/OwnerMain.fxml"));
				anchorPane.getChildren().add(ownerMain);
				
			}
		}
		*/
		
	}
	

	@FXML public void signUpButtonAction() throws Exception {
		
		Parent signUp = FXMLLoader.load(getClass().getResource("/parkingLotApplication/GUI/signUp.fxml"));
		anchorPane.getChildren().add(signUp);
		
		signUp.setTranslateX(signUp.getLayoutX());
		
		Timeline timeline = new Timeline();
		KeyValue keyValue = new KeyValue(signUp.translateXProperty(), 0);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
	}

	
	@FXML public void exitButtonAction() {
		System.exit(1);
	}
}