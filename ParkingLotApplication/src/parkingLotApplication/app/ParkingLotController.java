package parkingLotApplication.app;

import java.io.*;
import java.util.*;

import parkingLotApplication.model.*;

public class ParkingLotController {
	ObjectInputStream ois = null;
	BufferedInputStream bis = null;
	FileInputStream fis = null;		
	ObjectOutputStream oos1 = null;
	BufferedOutputStream bos1 = null;
	FileOutputStream fos1 = null;
	ObjectOutputStream oos2 = null;
	BufferedOutputStream bos2 = null;
	FileOutputStream fos2 = null;
	ArrayList<ParkingLot> parkingLotList;
	int numOfParkingLot = 0;
	
	public void addParkingLot(ParkingLot parkingLot) throws IOException, ClassNotFoundException, FileNotFoundException{		
		fis  = new FileInputStream("./src/parkingLotApplication/app/ParkingLotInfo.txt");
		bis = new BufferedInputStream(fis);
		ois = new ObjectInputStream(bis);
		fos1 = new FileOutputStream("./src/parkingLotApplication/app/ParkingLotInfo.txt");
		bos1 = new BufferedOutputStream(fos1);
		oos1 = new ObjectOutputStream(bos1);
		fos2 = new FileOutputStream("./src/parkingLotApplication/app/ParkingLotInfo.txt");
		bos2 = new BufferedOutputStream(fos2);
		oos2 = new ObjectOutputStream(bos2);
		
		if(numOfParkingLot == 0) {
			parkingLotList = new ArrayList<>(); 
			oos2.writeObject(parkingLotList);
			oos2.flush();
			oos2.close(); bos2.close(); fos2.close();
		}
		
		parkingLotList = (ArrayList<ParkingLot>) ois.readObject();
		parkingLotList.add(parkingLot);
		oos1.writeObject(parkingLotList);
		numOfParkingLot++;
		
		oos1.flush();
		ois.close(); bis.close(); fis.close();
		oos1.close(); bos1.close(); fos1.close();			
	}
}
