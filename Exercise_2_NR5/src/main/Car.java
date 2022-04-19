package main;

public class Car implements Display{
	private double weight;
	private int horsepower;
	private String colour;
	
	public Car(double weight, int horsepower, String colour) {
		this.weight = weight;
		this.horsepower = horsepower;
		this.colour = colour;
	}
	
	@Override
	public void print() {
		System.out.println("Weight: "+weight);
		System.out.println("Horsepower: "+horsepower);
		System.out.println("Colour: "+colour);
	}
	
}
