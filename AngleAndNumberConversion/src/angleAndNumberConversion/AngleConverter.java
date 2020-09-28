package angleAndNumberConversion;

import java.util.Scanner;

public class AngleConverter {
	
	public void displayMenu(Scanner scan) {
		int choice = 0;
		double number = 0.0;
		String input = "";
		
		do {
			System.out.println("Please select one of the following options. "
					+ "\n1. Convert from degrees to radians "
					+ "\n2. Convert from radians to degrees "
					+ "\n3. Return to previous menu ");
			input = scan.nextLine();
			
			try {
				choice = Integer.parseInt(input);
				switch(choice) {
					case 1: {
						System.out.print("Enter an angle in degrees: ");
						System.out.flush();
						input = scan.nextLine();
						number = Double.parseDouble(input);
						
						System.out.println("Degrees (original): " + input
								+ " Radians: " + degreesToRadians(number) + "\n");
						break;
					}
					case 2: {
						System.out.print("Enter an angle in radians: ");
						System.out.flush();
						input = scan.nextLine();
						number = Double.parseDouble(input);
						
						System.out.println("Radians (original): " + input
								+ " Degrees: " + radiansToDegrees(number) + "\n");
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
	
	private double degreesToRadians(double angle) {
		return Math.toRadians(angle);
	}
	
	private double radiansToDegrees(double angle) {
		return Math.toDegrees(angle);
	}
}
