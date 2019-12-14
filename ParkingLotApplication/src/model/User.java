package model;

public class User extends AppClient {
	
	private String _carNumber;
	private boolean _nonperson;		//사회적 약자
	public ParkingLot parkingLot;
//	public Socket socket;
		
	public User(String id, String password, String name, String age, String accountNumber, String carNumber, boolean nonPerson) {
		super(id, password, name, age, accountNumber);
		this.setCarNumber(carNumber);
		this.setNonperson(nonPerson);
//		try {
//			socket = new Socket("192.168.218.1",10002);
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	// getters
	public boolean getNonperson() {
		return _nonperson;
	}
	public String getCarNumber() {
		return _carNumber;
	}
	public ParkingLot getParkingLot() {
		return parkingLot;
	}
	
	// setters
	public void setNonperson(boolean nonperson) {
		this._nonperson = nonperson;
	}
	public void setCarNumber(String carNumber) {
		this._carNumber = carNumber;
	}
	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

}
