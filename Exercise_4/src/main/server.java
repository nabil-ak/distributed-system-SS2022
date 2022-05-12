package main;
import java.io.*;
import java.net.*;

public class server {
	
	public static void main(String[] args) {
		conference[] conferences = new conference[3];
		conferences[0] = new conference("Distributed System");
		conferences[1] = new conference("Real-Time System");
		conferences[2] = new conference("Discrete Math");
		
		System.out.println("The server is up");
		try{
			DatagramSocket aSocket = new DatagramSocket (6789);
			byte[] buffer = new byte[2000];
			
			while(true){
			DatagramPacket request = new DatagramPacket (buffer, buffer.length);
			aSocket.receive (request);
			ByteArrayInputStream byteis = new ByteArrayInputStream(buffer);
			ObjectInputStream is = new ObjectInputStream(byteis);
			MessageClient message = (MessageClient)is.readObject();
			MessageServer response = null;
			
			int c = message.getConferenceID();
			String[] params = message.getParams();
			
			if(message.getMethod() == 0)
			{
				conferences[c].addParticipant(params[0], params[1], params[2]);
				response = new MessageServer(true);
			}else if(message.getMethod() == 1) {
				response = new MessageServer(conferences[c].searchParticipant(params[0]));
			}else {
				response = new MessageServer(conferences[c].getName());
			}
			ByteArrayOutputStream byteos = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(byteos);
			os.writeObject(response);
			os.close();
			
			DatagramPacket reply = new DatagramPacket (byteos.toByteArray(),
					byteos.toByteArray().length, request.getAddress(), request.getPort());
			aSocket.send (reply);
			}
		}catch (Exception e){ e.printStackTrace();
		}

	}

}
