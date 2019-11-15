package parkingLotApplication.model;

public class Client {
	
	private String _id;
	private String _password;
	private String _name;
	private int _age;
	private int _phoneNumber;
	private boolean _nonperson;			//사회적 약자
	private String _carNumber;

	public Client() {}
	
	public Client(String id, String password, String name, int age, int phoneNumber, boolean nonperson) {
		setId(id);
		setPassword(password);
		setNonperson(nonperson);
		setName(name);
		setAge(age);
		setPhoneNumber(phoneNumber);
	}
	
	// setters
	public void setId(String id) {
		this._id = id;
	}
	public void setPassword(String password) {
		this._password = password;
	}
	public void setNonperson(boolean nonperson) {
		this._nonperson = nonperson;
	}
	public void setName(String name) {
		this._name = name;
	}
	public void setAge(int age) {
		this._age = age;
	}
	public void setPhoneNumber(int phoneNumber) {
		this._phoneNumber = phoneNumber;
	}
	public void setCarNumber(String carNumber) {
		this._carNumber = carNumber;
	}
	
	// getters
	public boolean getNonperson() {
		return _nonperson;
	}
	public String getName() {
		return _name;
	}
	public int getAge() {
		return _age;
	}
	public int getPhoneNumber() {
		return _phoneNumber;
	}
	public String getCarNumber() {
		return _carNumber;
	}
	public String getId(String id) {
		this._id = id;
	}
	public String getPassword(String password) {
		this._password = password;
	}
}
