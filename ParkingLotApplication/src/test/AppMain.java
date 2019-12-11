package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import javafx.application.Platform;
import model.Owner;
import model.ParkingLot;
import model.ParkingSpace;
import model.User;


public class AppMain  {

	public static User user;
	public static Owner owner;
	public static ClientCommunication communication;

	public static void main(String[] args) {
		User testUser = new User("testId", "testPassword", "testName", "testAge", "testAccountNum", "testCarNum", false);
		ParkingSpace[] parkingSpaces = new ParkingSpace[8];
		for(int i=0; i<parkingSpaces.length; i++) {
			parkingSpaces[i] = new ParkingSpace();
		}
		testUser.parkingLot = new ParkingLot("주차장1", "공대 5호관", parkingSpaces);
		testUser.parkingLot.spaces[1].setStatus(1);
		communication = new ClientCommunication();
		user = testUser;
		while(true) {
			
		}
		
		// 잘 주입된거 확인.
		//		System.out.println(user.getId());
		//		System.out.println(user.getPassword());
		//		System.out.println(user.getName());
		//		System.out.println(user.getAge());
		//		System.out.println(user.getAccountNumber());
		//		System.out.println(user.getCarNumber());
		//		System.out.println(user.getNonperson());
		//		System.out.println(user.getParkingLot().getName());
		//		System.out.println(user.getParkingLot().getLocation());
		//		for(int i=0; i<user.getParkingLot().getSpaces().length; i++) {
		//			System.out.println(user.getParkingLot().getSpaces()[i].getStatus());
		//		}
	}

}