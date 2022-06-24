package main;

import javax.jms.*;
import javax.naming.*;
import java.util.Hashtable;

public class ReceiverWithListener {
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
      receiver.setMessageListener(new Listener(sender,session));
      
   }
}