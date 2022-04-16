package main;

public class Publication {
	private String title;
	private String language;
	private double price;
	
	public Publication(String title, String language, double price) {
		this.title = title;
		this.language = language;
		this.price = price;
	}
	
	public void print() {
		System.out.println("Title: "+title);
		System.out.println("Language: "+language);
		System.out.println("Price: "+price+"�");
	}
}
