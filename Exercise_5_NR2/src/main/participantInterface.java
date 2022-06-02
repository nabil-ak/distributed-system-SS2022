package main;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface participantInterface extends Remote{
	public String getCompany() throws RemoteException;
	public void setCompany(String company) throws RemoteException;
	public String getName() throws RemoteException;
	public String getCountry() throws RemoteException;
}
