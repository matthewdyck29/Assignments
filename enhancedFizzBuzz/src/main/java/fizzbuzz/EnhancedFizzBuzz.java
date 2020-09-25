package fizzbuzz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EnhancedFizzBuzz {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		readInput(scan);
		scan.close();
	}
	
	public static void readInput(Scanner scan) {
		int start = 0;
		int end = 0;
		
		System.out.print("Enter the first number of the range: ");
		System.out.flush();
		try {
			start = scan.nextInt();
		} catch (InputMismatchException ime) {
			System.out.println("Invalid input.");
			return;
		}
		System.out.println("Enter the last number of the range: ");
		System.out.flush();
		try {
			end = scan.nextInt();
		} catch (InputMismatchException ime) {
			System.out.println("Invalid input.");
			return;
		}
		
		checkNumbers(start, end);
	}

	public static void checkNumbers(int start, int end) {
		String number;
		boolean luckyNumber = false;
		int fizzCount = 0;
		int buzzCount = 0;
		int fizzBuzzCount = 0;
		int luckyCount = 0;
		int intCount = 0;
		
		if(start > end) {
			System.out.println("Invalid range.");
			return;
		}
		
		for(int i = start;i <= end;i++) {
			number = new Integer(i).toString();
			if(number.contains("3")) {
				System.out.print("lucky ");
				luckyCount++;
				luckyNumber = true;
			}
			if(!luckyNumber) {
				if(i % 15 == 0) {
					if(i == 0) {
						System.out.print(i + " ");
						intCount++;
					} else {
						fizzBuzzCount++;
						System.out.print("fizzbuzz ");
					}
				} else if(i % 5 == 0) {
					buzzCount++;
					System.out.print("buzz ");
				} else if(i % 3 == 0) {
					fizzCount++;
					System.out.print("fizz ");
				} else {
					intCount++;
					System.out.print(i + " ");
				}
			}
			luckyNumber = false;
		}
		
		System.out.println("\nfizz: " + fizzCount + "\nbuzz: " + buzzCount
				+ "\nfizzbuzz: " + fizzBuzzCount + "\nlucky: " + luckyCount
				+ "\ninteger: " + intCount);
	}
	
}
