package main;

public class main {
	/**
	 * Calculate the Factorial of a non-negative Number
	 * @param number
	 * @return result
	 */
	public static int factorial(int number) {
		int result = 1;
		
		for(int i = 1; i <= number; i++) {
			result*=i;
			
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		System.out.println(factorial(4));

	}

}
