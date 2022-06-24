package main;

import javax.jms.*;
import javax.naming.*;
import java.util.Hashtable;

public class Receiver {
	public static conference rts = new conference("RTS");
	public static conference distributed = new conference("Distributed");
   public static void main(String argv[]) throws Exception {

      Hashtable<String, String> properties = new Hashtable<String, String>();
	  properties.put(Context.INITIAL_CONTEXT_FACTORY, 
	                     "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
	  properties.put(Context.PROVIDER_URL, "tcp://localhost:61616");

      Context context = new InitialContext(properties);

      QueueConnectionFactory connFactory = 
          (QueueConnectionFactory)context.lookup("ConnectionFactory");
      
      QueueConnection conn = connFactory.createQueueConnection();
      QueueSession session = conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
      
      Queue receiveQuene = (Queue) context.lookup("dynamicQueues/quene1");
      Queue sendQuene = (Queue) context.lookup("dynamicQueues/queue2");
      
      QueueReceiver receiver = session.createReceiver(receiveQuene);
      QueueSender sender = session.createSender(sendQuene);
      
      conn.start();
      System.out.print("Server started");
      while(true) {
	      TextMessage query = (TextMessage)receiver.receive();
	      TextMessage answer = session.createTextMessage();
	      String[] querySplited = query.getText().split(":");
	      conference conference;
	      if(querySplited[1].equals("0")) {
				conference = rts;
	      }else {
				conference = distributed;
	      }
	      switch(querySplited[0]) {
	      	case "0":
	      		conference.addParticipant(querySplited[2], querySplited[3], querySplited[4]);
	      		answer.setText("Successfully added "+querySplited[2]+ " to "+conference.getName());
	      		break;
	      	case "1":
	      		String participants = "All Participants of "+conference.getName()+": ";
	      		for(String name: conference.getParticipantNames()) {
	      			participants+=name+", ";
	      		}
	      		answer.setText(participants);
	      		break;
	      	case "2":
	      		participant participant = conference.searchParticipant(querySplited[2]);
	      		if(participant != null) {
	      			answer.setText(participant.getName()+" works at "+ participant.getCompany());
	      		}else {
	      			answer.setText("This Participant dosent exist.");
	      		}
	      		break;
	      	default:
	      		answer.setText("This Method doesent exist.");
	      }
	      System.out.println("Message Received: "+query.getText());
	      System.out.println("Message Sended: "+answer.getText());
	      sender.send(answer);
      }
      
   }
}