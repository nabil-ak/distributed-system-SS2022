package main;

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
