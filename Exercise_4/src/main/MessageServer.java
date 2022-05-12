package main;

import java.io.Serializable;

public class MessageServer implements Serializable{
	
	private Object returnValue;

	public MessageServer(Object returnValue) {
		this.returnValue = returnValue;
	}

	public Object getReturnValue() {
		return returnValue;
	}

}
