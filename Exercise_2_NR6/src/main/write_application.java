package main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class write_application {

	public static void main(String[] args) {
		Display[] d = new Display[10];
		for(int i = 0; i < 10; i++) {
			if(i%3==0) {
				d[i]= new Book("Gregs Tagebuch", "German", 5.00, "Jeff Kinney", "978-3843200059");
			}else if(i%3==1){
				d[i]= new Publication("Gregs Tagebuch", "German", 5.00);
			}else {
				d[i]= new Car(1000, 150, "black");
			}
		}
		
		try {
			FileOutputStream fs = new FileOutputStream("publications.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(d);
			os.close();
			
		} catch (IOException e) { 
			System.err.println(e.toString()); 
		}
		
		

	}

}
