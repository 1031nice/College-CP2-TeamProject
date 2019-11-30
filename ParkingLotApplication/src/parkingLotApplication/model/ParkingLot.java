package parkingLotApplication.model;

import java.util.ArrayList;

public class ParkingLot { // 주차장
	
	private String ownerID;
	private String name;
	private String region;
	private String location;
	private String feeForTenMin;
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
	public String getFeeForTenMin() {
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
	public void setFeeForTenMin(String feeForTenMin) {
		this.feeForTenMin = feeForTenMin;
	}
	public void setownerID(String ownerName) {
		this.ownerID = ownerName;
	}
}
