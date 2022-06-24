package main;

import javax.jms.*;
import javax.naming.*;
import java.util.Hashtable;

public class Sender {
   
   public static String send(String query) throws Exception {
      Hashtable<String, String> properties = new Hashtable<String, String>();
	  properties.put(Context.INITIAL_CONTEXT_FACTORY, 
	                     "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
	  properties.put(Context.PROVIDER_URL, "tcp://localhost:61616");

      Context context = new InitialContext(properties);

      QueueConnectionFactory connFactory = 
          (QueueConnectionFactory)context.lookup("ConnectionFactory");
    
      QueueConnection conn = connFactory.createQueueConnection();
      QueueSession session = conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
      
      Queue sendQuene = (Queue) context.lookup("dynamicQueues/quene1");
      Queue receiveQuene = (Queue) context.lookup("dynamicQueues/queue2");

      QueueSender sender = session.createSender(sendQuene);
      QueueReceiver receiver = session.createReceiver(receiveQuene);
     
      conn.start();
      TextMessage msg = session.createTextMessage();
      
      msg.setText(query);
      System.out.println("Sending Message: "+msg.getText());
      sender.send(msg);
      
      msg = (TextMessage) receiver.receive();
      System.out.println("Receive Message: "+msg.getText());
      session.close();
      conn.close();
      
      return msg.getText();
   }
}
