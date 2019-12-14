package model;

import java.io.Serializable;
import java.net.Socket;

public class AppClient implements Serializable {

	private static final long serialVersionUID = 1042650382560984791L;
	private String _id;
	private String _password;
	private String _name;
	private String _age;
	private String _AccountNumber;
	public Socket socket;
	private ParkingLot parkingLot;
	
	public AppClient() {}
	
//	public AppClient(Socket socket) {
//		this.socket = socket;
//	}
	
	public AppClient(String id, String password, String name, String age, String accountNumber) {
		setId(id);
		setPassword(password);
		setName(name);
		setAge(age);
		setAccountNumber(accountNumber);
	}
	
	public AppClient(String _id, String _password, String _name, String _age, String _AccountNumber,
			ParkingLot parkingLot) {
		this._id = _id;
		this._password = _password;
		this._name = _name;
		this._age = _age;
		this._AccountNumber = _AccountNumber;
		this.parkingLot = parkingLot;
	}

	// setters
	public void setId(String id) {
		this._id = id;
	}
	public void setPassword(String password) {
		this._password = password;
	}
	public void setName(String name) {
		this._name = name;
	}
	public void setAge(String age) {
		this._age = age;
	}
	public void setAccountNumber(String _AccountNumber) {
		this._AccountNumber = _AccountNumber;
	}
	
	// getters
	public String getName() {
		return _name;
	}
	public String getAge() {
		return _age;
	}
	public String getId() {
		return _id;
	}
	public String getPassword() {
		return _password;
	}
	public String getAccountNumber() {
		return _AccountNumber;
	}

	public ParkingLot getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

}
