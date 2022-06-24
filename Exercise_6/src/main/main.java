package main;

public class main {

	public static void main(String[] args) throws Exception{
		/**
			Syntax method:conferneceID:<params>
			Create Participant method = 0, get All Participants of Course = 1, search for Participant = 2
			RTS = 0, Distributed = 1
		**/
		
		//create participant
		Sender.send("0:0:Nabil:SAP:Germany");
		
		//get all participants
		Sender.send("1:0");
		
		//search for participant
		Sender.send("2:0:Nabil");
	}

}
