package parkingLotApplication.model;

import java.io.*;
import java.util.ArrayList;

public class Owner extends AppClient {
	
	ArrayList<ParkingLot> _parkingLots; // 회원 가입 후 입력 받을 예정
	
	// getters
	public ArrayList<ParkingLot> getParkingLots() {
		return _parkingLots;
	}
	
	// setters
	public void setParkingLots(int numberOfParkingLots) {
		_parkingLots = new ArrayList<>();
	}

}
