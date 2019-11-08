package parkingLotApplication;

public class AppController {
	private String id;
	private String password;
	
	public void register(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public void changeInfo(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	
	
}
