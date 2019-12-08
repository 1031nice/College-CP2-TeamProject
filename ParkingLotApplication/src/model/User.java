package model;

public class User extends AppClient {
	
	private String _carNumber;
	private boolean _nonperson;		//사회적 약자
	String parkingLotName;			//user가 현재 위치하는 주차장이름
		
	public User(String id, String password, String name, String age, String accountNumber, String carNumber, boolean nonPerson) {
		super(id, password, name, age, accountNumber);
		this.setCarNumber(carNumber);
		this.setNonperson(nonPerson);
	}
	
	// getters
	public boolean getNonperson() {
		return _nonperson;
	}
	public String getCarNumber() {
		return _carNumber;
	}
	public String getParkingLotName() {
		return parkingLotName;
	}
	
	// setters
	public void setNonperson(boolean nonperson) {
		this._nonperson = nonperson;
	}
	public void setCarNumber(String carNumber) {
		this._carNumber = carNumber;
	}
	public void setParkingLotName(String parkingLotName) {
		this.parkingLotName = parkingLotName;
	}
	public void setParkingLot(String parkingLotFile) {
		this.parkingLotFile = parkingLotFile;
	}
}
