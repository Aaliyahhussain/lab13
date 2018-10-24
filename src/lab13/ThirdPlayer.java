package lab13;


import java.util.Scanner;

public class ThirdPlayer extends Player {

	public ThirdPlayer() {}
	public ThirdPlayer(String name) {
		super(name);
	}

	@Override
	public Roshambo generateRoshambo() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String choice = Validator.getStringMatchingRegex(sc, 
				"Choose between 'ROCK', 'PAPER', and 'SCISSORS'.", "ROCK|PAPER|SCISSORS");
		Roshambo userRoshambo = Roshambo.ROCK;
		switch (choice) { 
	        case "ROCK":  
	            userRoshambo = Roshambo.ROCK;
	            break; 
	        case "PAPER": 
	            userRoshambo = Roshambo.PAPER; 
	            break; 
	        case "SCISSORS": 
	            userRoshambo = Roshambo.SCISSORS;
	            break; 
		 }
		return userRoshambo;
	}
	
	

}