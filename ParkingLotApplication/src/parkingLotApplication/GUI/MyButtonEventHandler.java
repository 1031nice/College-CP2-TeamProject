package parkingLotApplication.GUI;

import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.*;

public class MyButtonEventHandler implements EventHandler<MouseEvent> {

	@Override
	public void handle(final MouseEvent ME) {
		Object obj = ME.getSource();
		// 모든 버튼을 포함하는 상위 클래스인 ButtonBase를 사용
	    ButtonBase button = (ButtonBase) obj;
	    button.setCursor(Cursor.HAND);
		
	}



}
