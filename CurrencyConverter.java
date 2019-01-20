package java_hw;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This is a java program that
 * Asks the user to type the price for one dollar in Japanese yen.
 * Allows the user to convert from dollars to yen and vice versa.
 * Allows the user to request a change of conversion rate.
 * @author tianfu
 */

public class CurrencyConverter {
	
	/**
	 * prints a list of choices for user to choose
	 * @return the choice of user input in between 1 and 4
	 */
	private static int getUserChoice() {
		Scanner scan = new Scanner(System.in); // create a new scanner
		
		int choice = 0; // initialize user choice
		while (true) {
			try {
				// print menu choices
				System.out.println("Welcome! Please choose one of the following choice:");
				System.out.println("1    Convert US dollar to Japanese yen");
				System.out.println("2    Convert Japanese yen to US dollar");
				System.out.println("3    Set a new conversion rate (1 dollar in terms of yen)");
				System.out.println("4    Quit");
				choice = scan.nextInt();
				// only choices between 1 and 4 are valid
				if (choice>=1 && choice<=4) {
					break; // break the loop until the input is a valid integer choice
				}
			}
			// if the next token does not match the Integer regular expression
			// an exception will be thrown
			catch (InputMismatchException e) {
				System.out.println("Please enter a valid choice");
				scan.nextLine(); // skip the remaining invalid input
			}
		}
		return choice;
	}
	
	/**
	 * converts US dollar to Japanese yen
	 * @param conversion conversion rate to be used
	 * @param amount dollar amount to be converted
	 * @return converted amount in Japanese yen
	 */
	private static float dollarToYen(float conversion, float amount) {
		return conversion*amount;
	}
	
	/**
	 * converts Japanese yen to US dollar
	 * @param conversion conversion rate to be used
	 * @param amount yen amount to be converted
	 * @return converted amount in USD
	 */
	private static float yenToDollar(float conversion, float amount) {
		return amount/conversion;
	}
 
	/**
	 * main program execution
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // create a new scanner
		
		float rate; // initialize conversion rate as a float
		while (true) {
			try {
				// ask the user to specify a conversion rate before making a choice
				System.out.println("Please enter a conversion rate (1 dollar in terms of yen)");
				rate = scan.nextFloat();
				// conversion rate has to be positive
				if (rate > 0) {
				    break; // break the loop until the input is a valid float number
				}
			}
			// if the next token does not match the Integer regular expression
			// an exception will be thrown
			catch (InputMismatchException e) {
				System.out.println("Please enter a valid conversion rate");
				scan.nextLine(); // skip the remaining invalid input
			}
		}
		
		int user_input = getUserChoice(); // initialize user input
		
		// as long as the user does not choose to quit
		while (user_input != 4) {
			if (user_input == 1) { // when user chooses first option
				float dollarAmount; // initialize dollar amount to convert
				while (true) {
					try {
						// ask the user to specify a conversion rate before making a choice
						System.out.println("Please enter a US dollar amount to be converted to Japanese yen");
						dollarAmount = scan.nextFloat();
						// conversion rate has to be positive
						if (dollarAmount >= 0) {
						    break; // break the loop until the input is a valid float number
						}
					}
					// if the next token does not match the Integer regular expression
					// an exception will be thrown
					catch (InputMismatchException e) {
						System.out.println("Please enter a valid dollar amount");
						scan.nextLine(); // skip the remaining invalid input
					}
				}
				// calculate amount in japanese yen
				float convertedYen = dollarToYen(rate, dollarAmount);
				// print out the converted amount
				System.out.println("*************************************************");
				System.out.println(dollarAmount+" USD is equal to "+convertedYen+" Japanese Yen");
				System.out.println("*************************************************");
				
				user_input = getUserChoice(); // ask user choice again
			}
			else if (user_input == 2) { // when user chooses second option
				float yenAmount; // initialize yen amount to convert
				while (true) {
					try {
						// ask the user to specify a conversion rate before making a choice
						System.out.println("Please enter a Japanese yen amount to be converted to US dollar");
						yenAmount = scan.nextFloat();
						// conversion rate has to be positive
						if (yenAmount >= 0) {
						    break; // break the loop until the input is a valid float number
						}
					}
					// if the next token does not match the Integer regular expression
					// an exception will be thrown
					catch (InputMismatchException e) {
						System.out.println("Please enter a valid yen amount");
						scan.nextLine(); // skip the remaining invalid input
					}
				}
				// calculate amount in dollars
				float convertedDollar = yenToDollar(rate, yenAmount);
				// print out the converted amount
				System.out.println("*************************************************");
				System.out.println(yenAmount+" Japanese yen is equal to "+convertedDollar+" USD");
				System.out.println("*************************************************");
				
				user_input = getUserChoice(); // ask user choice again
			}
			else { // when user chooses third option
				while (true) {
					try {
						// ask the user to specify a new conversion rate
						System.out.print("Please enter the new conversion rate you want to use "+
						                 "(1 USD in terms of Japanese yen)");
						rate = scan.nextFloat();
						// conversion rate has to be positive
						if (rate >= 0) {
						    break; // break the loop until the input is a valid float number
						}
					}
					// if the next token does not match the Integer regular expression
					// an exception will be thrown
					catch (InputMismatchException e) {
						System.out.println("Please enter a valid dollar amount");
						scan.nextLine(); // skip the remaining invalid input
					}
				}
				// print the newly set conversion rate
				System.out.println("*********************************************************************");
				System.out.println("The new conversion rate you choose is " +
				                   "1 USD = " + rate +" Japanese yen");
				System.out.println("*********************************************************************");
				
				user_input = getUserChoice(); // ask user choice again
			}
		}
		
        if (user_input == 4) {
        	System.out.print("ByeBye!!!"); // exit the program
        }
	}

}
