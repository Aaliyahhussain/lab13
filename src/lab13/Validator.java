package lab13;



	import java.util.InputMismatchException;
	import java.util.Scanner;

	public class Validator {
		
		public static int getInt(Scanner scnr, String prompt) {
		
			System.out.print(prompt);
			try {
				int num = scnr.nextInt();
				scnr.nextLine();
				return num;
			} catch (InputMismatchException e) {
			
				return getInt(scnr, prompt);
			}
		}

	
		public static double getDouble(Scanner scnr, String prompt) {

			boolean isValid = false;
			do {
				System.out.print(prompt);
				isValid = scnr.hasNextDouble();
				if (!isValid) {
			
				}
			} while (!isValid);
			
			double number = scnr.nextDouble();
			scnr.nextLine();
			return number;
		}
	
		
		public static String getString(Scanner scnr, String prompt) {
			
			System.out.print(prompt);
			return scnr.nextLine();
		}
		
		
		public static int getInt(Scanner scnr, String prompt, int min, int max) {
			boolean isValid = false;
			int number;
			do {
				number = getInt(scnr, prompt);
				
				if (number < min) {
					isValid = false;
					System.out.println(min);
				} else if (number > max) {
					isValid = false;
					System.out.println(max);
				} else {
					isValid = true;
				}
				
			} while (!isValid);
			return number;
		}
		
	
		 
		public static double getDouble(Scanner scnr, String prompt, double min, double max) {
			boolean isValid = false;
			double number;
			do {
				number = getDouble(scnr, prompt);
				
				if (number < min) {
					isValid = false;
					System.out.println(min);
				} else if (number > max) {
					isValid = false;
					System.out.println(max);
				} else {
					isValid = true;
				}
				
			} while (!isValid);
			return number;
		}
		
		
		public static String getStringMatchingRegex(Scanner scnr, String prompt, String regex) {
			boolean isValid = false;
			String input;
			do {
				input = getString(scnr, prompt);
				
				if (input.matches(regex)) {
					isValid = true;
				} else {
					System.out.println("Invalid Input");
					isValid = false;
				}
				
			} while (!isValid);
			return input;
		}

	
		

	}