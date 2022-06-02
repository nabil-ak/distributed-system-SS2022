package main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Iterator;

public class conferenceImpl extends UnicastRemoteObject implements conferenceInterface{
	private String name;
	private HashSet<participantInterface> participants;
	
	public conferenceImpl(String name) throws RemoteException {
		this.name = name;
		this.participants = new HashSet<participantInterface>();
	}
	
	
	public participantInterface searchParticipant(String name) throws RemoteException{
		Iterator<participantInterface> i = participants.iterator();
		while(i.hasNext()) {
			participantInterface p = i.next();
			if(p.getName().equalsIgnoreCase(name)) {
				return p;
			}
		}
		return null;
	}
	
	public void addParticipant(String name, String company, String country) throws RemoteException{
		this.participants.add(new participantImpl(name, company, country));
	}

	public HashSet<participantInterface> getParticipants() throws RemoteException{
		return participants;
	}
	
	public String getName() throws RemoteException{
		return name;
	}
}
