package main;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashSet;

public interface conferenceInterface extends Remote{
	public participantInterface searchParticipant(String name) throws RemoteException;
	public void addParticipant(String name, String company, String country) throws RemoteException;
	public HashSet<participantInterface> getParticipants() throws RemoteException;
	public String getName() throws RemoteException;
}
