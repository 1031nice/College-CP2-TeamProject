package parkingLotApplication.model;

public class User extends AppClient {
	
	private String _carNumber;
	private boolean _nonperson;			//사회적 약자
		
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
