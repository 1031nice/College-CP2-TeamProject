package z_garbage;

import java.io.*;
import java.util.ArrayList;

import model.AppClient;
import model.ParkingLot;

public class Owner extends AppClient {
	
	public Owner(String id, String password, String name, String age, String accountNumber) {
		super(id, password, name, age, accountNumber);
	}
	
	ArrayList<ParkingLot> _parkingLots = new ArrayList<ParkingLot>(); // 회원 가입 후 입력 받을 예정
	
	// getters
	public ArrayList<ParkingLot> getParkingLots() {
		return _parkingLots;
	}
	
	// setters
	public void setParkingLots(int numberOfParkingLots) {
		_parkingLots = new ArrayList<>();
	}

}
