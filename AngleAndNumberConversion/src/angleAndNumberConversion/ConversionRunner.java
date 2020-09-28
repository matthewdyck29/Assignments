package angleAndNumberConversion;

import java.util.Scanner;

public class ConversionRunner {
	
	static AngleConverter ac;
	static NumberConverter nc;
	static Scanner scan;
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		ac = new AngleConverter();
		nc = new NumberConverter();
		displayMainMenu();
		scan.close();
	}

	public static void displayMainMenu() {
		int choice = 0;
		String input = "";
		
		do {
			System.out.println("Please select one of the following options."
					+ "\n1. Convert angles"
					+ "\n2. Convert numbers"
					+ "\n3. Quit");
			input = scan.nextLine();
			
			try {
				choice = Integer.parseInt(input);
				switch (choice) {
					case 1: {
						ac.displayMenu(scan);
						break;
					}
					case 2: {
						nc.displayMenu(scan);
						break;
					}
					case 3: {
						System.exit(0);
						break;
					}
					default: {
						System.err.println("Invalid input. \n");
						System.err.flush();
					}
				}
			} catch (NumberFormatException nfe) {
				System.err.println("Invalid input. \n");
				System.err.flush();
			}
		} while (choice != 3);
	}
	
}
