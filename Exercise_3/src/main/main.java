package main;

import java.util.Iterator;

public class main {

	public static void main(String[] args) {
		conference conference = new conference("Introduction to Distributed Systems");
		conference.addParticipant("Nabil", "SAP", "Germany");
		conference.addParticipant("Ibtehal", "Google", "UK");
		conference.addParticipant("Tim", "Microsoft", "Germany");
		conference.addParticipant("Jatender", "Netflix", "France");
		conference.addParticipant("Niklas", "Meta", "USA");
		
		Iterator<participant> p = conference.getParticipants().iterator();
		int germanyCount = 0;
		
		while(p.hasNext()) {
			if(p.next().getCountry().equalsIgnoreCase("Germany")) {
				germanyCount++;
			}
		}
		
		System.out.println("Nabil is from "+conference.searchParticipant("Nabil").getCountry());
		
		System.out.println(germanyCount+" Participants are from Germany");
	}

}
