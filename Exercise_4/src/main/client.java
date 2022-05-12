package main;
import java.io.*;
import java.net.*;

public class client {

	public static void main(String[] args) {
		MessageServer m;
		
		//Get name of second conference
		m = sendMessage(new MessageClient(0, 2));
		System.out.println("Name of the second conference: "+m.getReturnValue().toString());
		
		//Add Participant to first conference 
		String[] params = {"Nabil", "SAP", "Germany"};
		m = sendMessage(new MessageClient(0, 0, params));
		
		//Get Nabil from the first conference 
		m = sendMessage(new MessageClient(0, 1, params));
		System.out.println("Nabil works at: " + ((participant)m.getReturnValue()).getCompany());
	}
	
	public static MessageServer sendMessage(MessageClient messsage) {
		try {
			ByteArrayOutputStream byteos = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(byteos);
			DatagramSocket aSocket = new DatagramSocket();
			os.writeObject(messsage);
			os.close();
			
			InetAddress aHost = InetAddress.getByName("localhost");
			int serverPort = 6789;
			DatagramPacket request = new DatagramPacket (byteos.toByteArray(), byteos.toByteArray().length, aHost, serverPort);
			aSocket.send (request);
			
			byte[] buffer = new byte[2000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			aSocket.receive (reply);
			ByteArrayInputStream byteis = new ByteArrayInputStream(buffer);
			ObjectInputStream is = new ObjectInputStream(byteis);
			
			MessageServer messageServer = (MessageServer)is.readObject();
			aSocket.close();
			
			return messageServer;
			}catch (Exception e){ e.printStackTrace();
		}
		return null;
	}

}
