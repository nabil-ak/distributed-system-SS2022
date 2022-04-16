package main;

public class main {

	public static void main(String[] args) {
		Publication[] p = new Publication[10];
		for(int i = 0; i < 10; i++) {
			if(i%2==0) {
				p[i]= new Book("Gregs Tagebuch", "German", 5.00, "Jeff Kinney", "978-3843200059");
			}else {
				p[i]= new Publication("Gregs Tagebuch", "German", 5.00);
			}
		}
		
		for(int i = 0; i < 10; i++) {
			p[i].print();
		}
	}

}
