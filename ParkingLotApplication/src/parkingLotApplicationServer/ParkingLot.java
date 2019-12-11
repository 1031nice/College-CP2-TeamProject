package parkingLotApplicationServer;

import java.io.Serializable;

public class ParkingLot implements Serializable  { // 주차장
	
	private String name;				//주차장 이름
	private String location;			//주차장 지역(주소)
	private ParkingSpace[] _spaces = new ParkingSpace [8]; 		
	
	// constructor
	public ParkingLot(ParkingSpace[] spaces) {
		setSpaces(spaces);
	}
	public ParkingLot() {}
	
	public ParkingSpace[] getSpaces() {
		return _spaces;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	
	public void setSpaces(ParkingSpace[] spaces) {
		this._spaces = spaces;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
