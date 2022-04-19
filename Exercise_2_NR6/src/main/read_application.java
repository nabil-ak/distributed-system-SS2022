package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class read_application {

	public static void main(String[] args) {
		try {
			FileInputStream fs = new FileInputStream("publications.ser");
			ObjectInputStream is = new ObjectInputStream(fs);
			Display[] d = (Display[])is.readObject();
			is.close();
			
			for(Display dis: d) {
				dis.print();
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.toString());
		} catch (IOException e) {
			System.err.println(e.toString());
		} catch (ClassNotFoundException e) {
			System.err.println(e.toString());
		}
		
	}

}
