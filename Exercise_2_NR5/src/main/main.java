package main;

public class main {

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
		
		for(int i = 0; i < 10; i++) {
			d[i].print();
			System.out.println("__________________________________________________________");
		}
	}

}
