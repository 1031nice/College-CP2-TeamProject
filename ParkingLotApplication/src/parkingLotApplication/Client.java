package parkingLotApplication;

public class Client {
	
	private boolean nonperson;			//사회적 약자
	private String name;
	private int age;
	private int phoneNumber;

	public Client(String name, int age, int phoneNumber, boolean nonperson) {
		this.nonperson = nonperson;
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}
	public void setNonperson(boolean nonperson) {
		this.nonperson = nonperson;
	}
	public boolean getNonperson() {
		return nonperson;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
}
