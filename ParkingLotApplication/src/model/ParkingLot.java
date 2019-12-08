package model;

import java.io.*;
import java.util.ArrayList;

import javafx.scene.layout.*;

public class ParkingLot implements Serializable  { // 주차장
	
	private String name;				//주차장 이름
	private String location;			//주차장 지역(주소)
	private ArrayList<ParkingSpace> _spaces; 		
	
	public ParkingLot(ArrayList<ParkingSpace> spaces) {
		setSpaces(spaces);
	}
	public ParkingLot() {
		setSpaces(new ArrayList<ParkingSpace>());
	}
	public ArrayList<ParkingSpace> getSpaces() {
		return _spaces;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	
	public void setSpaces(ArrayList<ParkingSpace> spaces) {
		this._spaces = spaces;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
