package main;

import java.rmi.Naming;
import java.util.Iterator;

public class Client {

	public static void main(String[] args) {
		try {    
			  conferenceInterface conferenceOne = (conferenceInterface) Naming.lookup("rmi://localhost/conferenceOne");
			  conferenceInterface conferenceTwo = (conferenceInterface) Naming.lookup("rmi://localhost/conferenceTwo");
			  
			  conferenceOne.addParticipant("Nabil", "SAP", "Germany");
			  conferenceOne.addParticipant("Ibtehal", "Google", "UK");
			  conferenceOne.addParticipant("Tim", "Microsoft", "Germany");
			  conferenceOne.addParticipant("Jatender", "Netflix", "France");
			  conferenceOne.addParticipant("Niklas", "Meta", "USA");
			  
			  System.out.println ("Name of first conference: " + conferenceOne.getName());
			  System.out.println ("Name of second conference: " + conferenceTwo.getName());
			  
			  	//count all participants from germany
			    Iterator<participantInterface> pIterator = conferenceOne.getParticipants().iterator();
				int germanyCount = 0;
				
				while(pIterator.hasNext()) {
					if(pIterator.next().getCountry().equalsIgnoreCase("Germany")) {
						germanyCount++;
					}
				}
				
				System.out.println("Nabil is from "+conferenceOne.searchParticipant("Nabil").getCountry());
				
				System.out.println(germanyCount+" Participants are from Germany");
				
				
				//change tims's company
				participantInterface p = conferenceOne.searchParticipant("Tim");
				p.setCompany("Deutsche Bank");
				System.out.println(p.getName()+" is working at "+p.getCompany());
				
		        
		    } catch (Exception e) {
				System.out.println("Client: " + e.getMessage());
			    e.printStackTrace();
			}

	}

}
