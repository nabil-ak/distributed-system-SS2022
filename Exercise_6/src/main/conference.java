package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class conference {
	private String name;
	private HashSet<participant> participants;
	
	public conference(String name) {
		this.name = name;
		this.participants = new HashSet<participant>();
	}
	
	public participant searchParticipant(String name) {
		Iterator<participant> i = participants.iterator();
		while(i.hasNext()) {
			participant p = i.next();
			if(p.getName().equalsIgnoreCase(name)) {
				return p;
			}
		}
		return null;
	}
	
	public ArrayList<String> getParticipantNames(){
		ArrayList<String> participants = new ArrayList<String>();
		Iterator<participant> i = this.participants.iterator();
		while(i.hasNext()) {
			participants.add(i.next().getName());
		}
		
		return participants;
	}
	
	public void addParticipant(String name, String company, String country) {
		this.participants.add(new participant(name, company, country));
	}

	public HashSet<participant> getParticipants() {
		return participants;
	}
	
	public String getName() {
		return name;
	}
	
}
