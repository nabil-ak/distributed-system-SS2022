package main;

import java.util.Scanner;

public class Waiter {

	public static void main(String[] args) {
		int counter = 0;
		Scanner sc = new Scanner(System.in);
		while(true) {
			sc.nextLine();
			new Printer(counter).start();
			counter++;
		}

	}

}
