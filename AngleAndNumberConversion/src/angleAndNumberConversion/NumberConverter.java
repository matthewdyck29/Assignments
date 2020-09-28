package angleAndNumberConversion;

import java.util.Scanner;

public class NumberConverter {
	
	public void displayMenu(Scanner scan) {
		int choice = 0;
		int number = 0;
		String input = "";
		
		do {
			System.out.println("Please select one of the following options. "
					+ "\n1. Convert from decimal to hexadecimal "
					+ "\n2. Convert from hexadecimal to decimal "
					+ "\n3. Return to previous menu ");
			input = scan.nextLine();
			
			try {
				choice = Integer.parseInt(input);
				switch(choice) {
					case 1: {
						System.out.print("Enter a decimal number: ");
						System.out.flush();
						input = scan.nextLine();
						number = Integer.parseInt(input);
						
						System.out.println("Decimal (original): " + input
								+ " Hexadecimal: " + decimalToHex(number) + "\n");
						break;
					}
					case 2: {
						System.out.print("Enter a hexadecimal number" 
								+ " (add a \"-\" for negative numbers): ");
						System.out.flush();
						input = scan.nextLine();
						
						if(validHexCheck(input)) {
							System.out.println("Hexadecimal (original): " + input
									+ " Decimal: " + hexToDecimal(input) + "\n");
						}
						break;
					}
					case 3: {
						return;
					}
					default: {
						System.err.println("Invalid input. \n");
					}
				}
			} catch(NumberFormatException nfe) {
				System.err.println("Invalid input. \n");
				System.err.flush();
			}
		} while(choice != 3);
	}
	
	private String decimalToHex(int number) {
		if(Integer.toHexString(number).length() > 4) {
			return Integer.toHexString(number).toUpperCase().substring(0, 4);
		} else {
			return Integer.toHexString(number).toUpperCase();
		}
	}
	
	private int hexToDecimal(String number) {
		boolean negativeHex = false;
		int decimal = 0;
		char current = '\0';
		
		for(int i = 0;i < number.length();i++) {
			current = number.charAt(i);
			if(i == 0 && current == '-') {
				i++;
				current = number.charAt(i);
				negativeHex = true;
			}
			if(current < 'A') {
				decimal += (new Integer(current) - 48) * (Math.pow(16, (number.length() - i - 1)));
			} else {
				switch(current) {
					case 'a': {
						
					}
					case 'A': {
						decimal += 10 * (Math.pow(16, number.length() - i - 1));
						break;
					}
					case 'b': {
						
					}
					case 'B': {
						decimal += 11 * (Math.pow(16, number.length() - i - 1));
						break;
					}
					case 'c': {
						
					}
					case 'C': {
						decimal += 12 * (Math.pow(16, number.length() - i - 1));
						break;
					}
					case 'd': {
						
					}
					case 'D': {
						decimal += 13 * (Math.pow(16, number.length() - i - 1));
						break;
					}
					case 'e': {
						
					}
					case 'E': {
						decimal += 14 * (Math.pow(16, number.length() - i - 1));
						break;
					}
					case 'f': {
						
					}
					case 'F': {
						decimal += 15 * (Math.pow(16, number.length() - i - 1));
						break;
					}
				}
			}
		}
		
		return negativeHex ? (decimal * -1) : decimal;
	}
	
	private boolean validHexCheck(String input) {
		boolean validInput = true;
		
		for(int i = 0;i < input.length();i++) {
			if(!(input.charAt(i) == '-' && i == 0)) {
				if(input.charAt(i) < '0' ||
						input.charAt(i) > '9' && input.charAt(i) < 'A'
						|| input.charAt(i) > 'F' && input.charAt(i) < 'a'
						|| input.charAt(i) > 'f') {
					validInput = false;
					System.err.println("Invalid input. \n");
					System.err.flush();
					break;
				}
			}
		}
		return validInput;
	}
	
}
