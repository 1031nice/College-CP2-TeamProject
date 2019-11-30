package parkingLotApplication.model;

import java.util.ArrayList;

public class ParkingLot { // 주차장
	
	private String ownerID;			//주차장 소유자 아이디
	private String name;				//주차장 이름
	private String region;				//주차장이 있는 지역(예: 수도권,강원도,충청도 등등)
	private String location;			//주차장 지역(주소)
	private int feeForTenMin;		//10분당 요금
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
	public String getName() {
		return name;
	}
	public String getRegion() {
		return region;
	}
	public String getLocation() {
		return location;
	}
	public int getFeeForTenMin() {
		return feeForTenMin;
	}
	public String getownerID() {
		return ownerID;
	}
	
	public void setSpaces(ArrayList<ParkingSpace> spaces) {
		this._spaces = spaces;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setFeeForTenMin(int feeForTenMin) {
		this.feeForTenMin = feeForTenMin;
	}
	public void setownerID(String ownerName) {
		this.ownerID = ownerName;
	}
}
