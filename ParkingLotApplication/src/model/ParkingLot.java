package model;

import java.io.*;
import java.util.ArrayList;

import javafx.scene.layout.*;

public class ParkingLot implements Serializable  { // 주차장
	
	private String name;				//주차장 이름
	private String location;			//주차장 지역(주소)
	public ParkingSpace[] spaces = new ParkingSpace [8]; 		
	
	// constructor
	public ParkingLot(ParkingSpace[] spaces) {
		setSpaces(spaces);
	}
	public ParkingLot() {}
	public ParkingLot(String name, String location, ParkingSpace[] spaces) {
		this.name = name;
		this.location = location;
		this.spaces = spaces;
	}
	
	public ParkingSpace[] getSpaces() {
		return spaces;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	
	public void setSpaces(ParkingSpace[] spaces) {
		this.spaces = spaces;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
