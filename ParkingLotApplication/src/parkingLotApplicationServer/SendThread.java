package parkingLotApplicationServer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SendThread implements Runnable {

	ObjectInputStream objInputStream;
	BufferedInputStream bufInputStream;
	ObjectOutputStream objOutputStream;
	BufferedOutputStream bufOutputStream;
	
	@Override
	public void run() {
	}

}
