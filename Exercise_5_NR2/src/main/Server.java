package main;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server{


	public static void main(String[] args) {
		try {
			  conferenceImpl[] conferences = new conferenceImpl[2];
			  conferences[0] = new conferenceImpl("Distributed System");
			  conferences[1] = new conferenceImpl("Real-Time System");
		      Naming.rebind ("conferenceOne", conferences[0]);
		      Naming.rebind ("conferenceTwo", conferences[1]);
		      System.out.println("The server is up");
		      
		    } catch (Exception e) {
				System.out.println("Server: " + e.getMessage());
				e.printStackTrace();
			}
	}

}
