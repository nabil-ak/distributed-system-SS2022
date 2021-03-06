package main;

public class Book extends Publication{
	private String author;
	private String ISBN;
	
	public Book(String title, String language, double price, String author, String ISBN) {
		super(title, language, price);
		this.author = author;
		this.ISBN = ISBN;
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("Author: "+author);
		System.out.println("ISBN: "+ISBN);
	}
	
}
