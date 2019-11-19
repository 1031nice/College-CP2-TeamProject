package parkingLotApplication.model;

import java.util.ArrayList;

public class ParkingLot { // 주차장
	
	private ArrayList<ParkingSpace> _spaces;
	
	public ParkingLot(ArrayList<ParkingSpace> spaces) {
		setSpaces(spaces);
	}
	public ParkingLot() {
		setSpaces(new ArrayList<ParkingSpace>());
	}

	public ArrayList<ParkingSpace> getSpaces() {
		return _spaces;
	}

	public void setSpaces(ArrayList<ParkingSpace> spaces) {
		this._spaces = spaces;
	}
	
}
