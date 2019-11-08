package parkingLotApplication;

public class ParkingLot { // 주차장
	
	private static final int DEFAULT_SIZE = 1;
	
	private ParkingSpace [] spaces;
	
	public ParkingLot() {
		spaces = new ParkingSpace [DEFAULT_SIZE];
	}
}
