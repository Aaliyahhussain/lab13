package lab13;

import java.util.Scanner;
import java.util.TreeMap;

public class RoshamboApp {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		inputName();
		
	}

	private static void inputName() {
		System.out.println("Welcome to Rock Paper Scissors!");
		Scanner sc = new Scanner(System.in);
		String name = Validator
				.getStringMatchingRegex(sc, "Enter your name: ", "[a-zA-Z]+");
		System.out.print("Hi " + name + ". ");
		inputOpponent(sc, name); 
	}

	private static void inputOpponent(Scanner sc, String name) {
		String opponent = Validator.getStringMatchingRegex
				(sc, "Would you like to play against The Jets or The Sharks? "
				+ "Type exactly 'The Jets' or 'The Sharks'", "The Jets|The Sharks");
		createPlayers(sc, name, opponent);
	}
	private static void createPlayers(Scanner sc, String name, String opponent) {
		AlwaysRock user = new AlwaysRock(name);
		RandomPlayer sharkUser = new RandomPlayer(opponent);
		AlwaysRock jetUser = new AlwaysRock(opponent);
		TreeMap<Player, Integer> score = new TreeMap<>();
		if (opponent.equals("The Jets"))
			inputRPS(sc, name, opponent, user, jetUser, score);
		if (opponent.equals("The Sharks"))
			inputRPS(sc, name, opponent, user, sharkUser, score);
	}

	private static void inputRPS(Scanner sc, String name, String stringOpponent, AlwaysRock user,
			Player opponent, TreeMap<Player, Integer> score) {
		Roshambo userChoice = user.generateRoshambo();
		Roshambo opponentChoice = opponent.generateRoshambo();
		play(sc, name, stringOpponent, user, opponent, userChoice, opponentChoice, score);
	}

	private static void play(Scanner sc, String name, String stringOpponent,AlwaysRock user,
			Player opponent, Roshambo userChoice, Roshambo opponentChoice, TreeMap<Player, Integer> score) {
		displayChoices(sc, stringOpponent, stringOpponent, user, opponent, opponentChoice, opponentChoice);
		if (userChoice.equals(Roshambo.PAPER)) {
			if (opponentChoice.equals(Roshambo.ROCK)) {
				askToContinue(sc, stringOpponent, stringOpponent, user, opponent, opponentChoice, opponentChoice, score);
			}
			else if (opponentChoice.equals(Roshambo.SCISSORS)) {
				askToContinue(sc, stringOpponent, stringOpponent, user, opponent, opponentChoice, opponentChoice, score);
			
			}
		} else if (userChoice.equals(Roshambo.ROCK)) {
			if (opponentChoice.equals(Roshambo.PAPER)) {
				askToContinue(sc, stringOpponent, stringOpponent, user, opponent, opponentChoice, opponentChoice, score);
			}
			else if (opponentChoice.equals(Roshambo.SCISSORS)) {
				askToContinue(sc, stringOpponent, stringOpponent, user, opponent, opponentChoice, opponentChoice, score);
			} else {
				System.out.println("Draw!");
				askToContinue(sc, stringOpponent, stringOpponent, user, opponent, opponentChoice, opponentChoice, score);
			}
		} else {
			if (opponentChoice.equals(Roshambo.PAPER)) {
				askToContinue(sc, stringOpponent, stringOpponent, user, opponent, opponentChoice, opponentChoice, score);
			}
			else if (opponentChoice.equals(Roshambo.ROCK)) {
				askToContinue(sc, stringOpponent, stringOpponent, user, opponent, opponentChoice, opponentChoice, score);
			}
			else {
				System.out.println("Draw!");
				askToContinue(sc, stringOpponent, stringOpponent, user, opponent, opponentChoice, opponentChoice, score);
			}
		}
	}

	private static void askToContinue(Scanner sc, String name, String stringOpponent, AlwaysRock user,
			Player opponent, Roshambo userChoice, Roshambo opponentChoice, TreeMap<Player, Integer> score) {
		    if (Validator.getString(sc, "Play again?").matches("[y][e]*[s]*")){
		    	inputRPS(sc, stringOpponent, stringOpponent, user, opponent, score);
		   
		   
		    } else {
		    	askToContinue(sc, stringOpponent, stringOpponent, user, opponent, opponentChoice, opponentChoice, score);
		    }
	}



	private static void displayChoices(Scanner sc, String name, String stringOpponent, AlwaysRock user,
			Player opponent, Roshambo userChoice, Roshambo opponentChoice) {
		System.out.println(user.getName() + " chose " + userChoice + " and " + opponent.getName() + " chose " + opponentChoice);
	}
}

