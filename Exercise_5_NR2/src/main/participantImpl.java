package main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class participantImpl extends UnicastRemoteObject implements participantInterface{
	
	private String name;
	private String company;
	private String country;
	
	public participantImpl(String name, String company, String country) throws RemoteException{
		this.name = name;
		this.company = company;
		this.country = country;
	}

	public String getCompany() throws RemoteException{
		return company;
	}

	public void setCompany(String company) throws RemoteException{
		this.company = company;
	}

	public String getName() throws RemoteException{
		return name;
	}

	public String getCountry() throws RemoteException{
		return country;
	}
}
