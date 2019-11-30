package parkingLotApplication.GUI;

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
	
	
	@FXML public void loginButtonAction() throws Exception {
		/*
		 *  1. idTextField와 pwTextField에서 값을 읽어온다
		 *  2. 사용자/관리자 계정이 들어 있는 파일에 접근하여 값을 비교한다
		 *  3-1. 파일에 없는 정보라면 경고창을 띄운다.
		 *  3-2. 파일에 있는 정보라면 프로그램으로 정보를 가져와 저장
		 *  4. 사용자는 ParkingLotList로 이동하여 주차장을 선택할 수 있다
		 *  5. 선택된 화면이 Client (이름을 보다 직관적으로 이해할 수 있게 변경해야할듯)
		 *  6. space번호의 입력이 아니라 클릭으로 가능했으면 좋겠다. 1. 명색이 GUI이므로 2. 입력시 예외 처리를 해야하므로
		 *  7. 예약이 되면 주차장의 색이 변한다. 다른 Thread에 밀려 예약이 안되면 적절한 메시지 출력해 주차장의 색을 역시 변화시킨다
		 *  @ 반납과 결제가 따로 있을 필요가 있나?
		 *  @ 정보 변경시 별도의 fxml을 쓰지 말고 기존의 SignUp.fxml을 이용하면 어떨까? 대신 변경이 불가능한 아이디 같은경우는 출력만 하고 나머지는 입력 가능하게
		 *  @ 정보 변경시 우측의 메뉴는 없애는게 어떨까? 위에 주차장 고르는 버튼도
		 *  Q Thread를 어떃게 적용할 것인가. 콘솔이라면 한대의 컴퓨터로 여러개의 Thread 만들어서 하면 되지만
		 *    GUI이므로 클릭이 일어나야 할텐데 이것도 한대의 컴퓨터에서 임의로 동작시킬 수 있나?
		 *  Q 프로그램 전체에서 사용되야 할 정보는 어디서 저장하는가
		 *  Q controller는 객체를 생성하지 않고 action이 일어낭메 따라 실행되므로 static class 같은 개념인가
		 */
	}
	

	@FXML public void signUpButtonAction() throws Exception {
		// sign up button을 누르면 signUp.fxml로 이동
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