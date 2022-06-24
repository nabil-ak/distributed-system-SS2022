package main;
import javax.jms.*;

public class Listener implements MessageListener{
	
	QueueSender sender;
	QueueSession session;
	
	public Listener(QueueSender sender, QueueSession session){
		this.sender = sender;
		this.session = session;
	}

	@Override
	public void onMessage(Message msg) {
		try {
		  TextMessage query = (TextMessage)msg;
	      TextMessage answer = session.createTextMessage();
	      String[] querySplited = query.getText().split(":");
	      conference conference;
	      if(querySplited[1].equals("0")) {
				conference = ReceiverWithListener.rts;
	      }else {
				conference = ReceiverWithListener.distributed;
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
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
