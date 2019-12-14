package model;

import java.io.*;

public class ParkingSpace implements Serializable  { // 주차장 속 하나하나의 공간
	
	private static final int OCCUPIED = 1;
	private static final int EMPTY = 0;
	private static final int DEFAULT_STATUS = EMPTY;

	private int status = DEFAULT_STATUS;
	private String id;

	public synchronized int getStatus() {
		return status;
	}
	public synchronized void setStatus(int givenStatus) {
		this.status = givenStatus;
	}
	public synchronized void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id;
	}
}
