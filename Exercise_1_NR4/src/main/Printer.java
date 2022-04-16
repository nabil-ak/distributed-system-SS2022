package main;

public class Printer extends Thread{
	private int number;

	public Printer(int number) {
		super();
		this.number = number;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(number);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
