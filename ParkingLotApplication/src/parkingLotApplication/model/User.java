package parkingLotApplication.model;

public class User extends AppClient {
	
	private String _carNumber;
	private boolean _nonperson;			//사회적 약자
	
	public User(String id, String password, String name, int age, int phoneNumber, String carNumber, boolean nonperson) {
		super(id, password, name, age, phoneNumber);
		setCarNumber(carNumber);
		setNonperson(nonperson);
	}
	
	// getters
	public boolean getNonperson() {
		return _nonperson;
	}
	public String getCarNumber() {
		return _carNumber;
	}
	
	// setters
	public void setNonperson(boolean nonperson) {
		this._nonperson = nonperson;
	}
	public void setCarNumber(String carNumber) {
		this._carNumber = carNumber;
	}

}
