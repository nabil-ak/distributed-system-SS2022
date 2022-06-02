package main;

import java.rmi.Naming;
import java.util.Date;

public class DateClient {
  public static void main (String[] args) throws Exception {
 
          
    try {    
      DateServer dateServer = (DateServer) Naming.lookup("rmi://localhost/DateServer");
      Date when = dateServer.getDate ();
      System.out.println ("Date: " + when);
        
    } catch (Exception e) {
		System.out.println("DateClient: " + e.getMessage());
	    e.printStackTrace();
	}
    
  }
}
