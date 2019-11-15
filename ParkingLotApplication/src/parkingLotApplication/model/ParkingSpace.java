package parkingLotApplication.model;

public class ParkingSpace { // 주차장 속 하나하나의 공간
	
	private static final int OCCUPIED = 1;
	private static final int EMPTY = 0;
	private static final int DEFAULT_STATUS = EMPTY;

	private int status = DEFAULT_STATUS;
	private String id;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int givenStatus) {
		this.status = givenStatus;
	}
	public void setStatusOccupied() {
		this.status = OCCUPIED;
	}
	public void setStatusEmpty() {
		this.status = EMPTY;
	}
	public boolean isEmpty() {
		if(status == OCCUPIED)
			return false;
		else
			return true;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
		public String toString() {
			return id;
		}
}
