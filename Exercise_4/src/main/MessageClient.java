package main;

import java.io.Serializable;

public class MessageClient implements Serializable{
	private int conferenceID;
	private int method;
	private String[] params;
	
	public MessageClient(int conferenceID, int method, String[] params) {
		this.conferenceID = conferenceID;
		this.method = method;
		this.params = params;
	}
	
	public MessageClient(int conferenceID, int method) {
		this.conferenceID = conferenceID;
		this.method = method;
		this.params = new String[0];
	}
	
	public int getConferenceID() {
		return conferenceID;
	}

	public int getMethod() {
		return method;
	}

	public String[] getParams() {
		return params;
	}
	

}
