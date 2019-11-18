package parkingLotApplication.model;

public class AppClient {
	
	private String _id;
	private String _password;
	private String _name;
	private int _age;
	private String _phoneNumber;

	public AppClient() {}
	
	public AppClient(String id, String password, String name, int age, String phoneNumber) {
		setId(id);
		setPassword(password);
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

	public void setName(String name) {
		this._name = name;
	}
	public void setAge(int age) {
		this._age = age;
	}
	public void setPhoneNumber(String phoneNumber) {
		this._phoneNumber = phoneNumber;
	}

	
	// getters

	public String getName() {
		return _name;
	}
	public int getAge() {
		return _age;
	}
	public String getPhoneNumber() {
		return _phoneNumber;
	}
	public String getId() {
		return _id;
	}
	public String getPassword() {
		return _password;
	}
}
