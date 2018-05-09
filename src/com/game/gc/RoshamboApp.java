package com.game.gc;

import java.util.Scanner;
import com.game.gc.Validator;

public class RoshamboApp {

	static int playerWin = 0;//global variable
	static int playerLoss = 0;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String matchingResult;
		String cont = "y";
		System.out.println("Welcom to Rock Paper Scissors!");

		// prompt user/player to enter name
		System.out.println("Please enter your name: ");

		// get user name input - Input
		Player p = new User();
		p.setName(scan.nextLine());

		// prompt for opponent
		int opponentSelect = Validator.getInt(scan, "Would you like to play against Random or Rock (1/2)?: ", 1, 2);
		while (cont.equalsIgnoreCase("y")) {
			// prompt player for game choice
			String userChoice = Validator.getString(scan, "\nRock, Paper or Scissors?(R/P/S) : ");

			// transfer user choice into full word
			if (userChoice.equalsIgnoreCase("r"))
				userChoice = "Rock";
			else if (userChoice.equalsIgnoreCase("p"))
				userChoice = "Paper";
			else
				userChoice = "Scissors";

			if (opponentSelect == 1) {
				Random ramdon = new Random();
				ramdon.setName("Random");
				ramdon.getName();
				// display player choice
				System.out.println("\n" + p.getName() + " : " + userChoice);
				// display opponent choice
				matchingResult = ramdon.generateRoshambo().toString();
				System.out.println(ramdon.getName() + " : " + matchingResult);
				matchResult(userChoice, matchingResult, p.getName(), ramdon.getName());

			} else if (opponentSelect == 2) {
				Rock rock = new Rock();
				rock.setName("Rock");
				System.out.println("\n" + p.getName() + " : " + userChoice);
				matchingResult = rock.generateRoshambo().toString();
				System.out.println(rock.getName() + " : " + matchingResult);
				matchResult(userChoice, matchingResult, p.getName(), rock.getName());

			}

			// ask user to continue
			System.out.print("\nPlay again? (y/n): ");
			cont = scan.nextLine();
		}
		System.out.println("Good Bye!");
		scan.close();
	}

	// uc userChoice mr = matching Result
	private static void matchResult(String uc, String mr, String player, String opponent) {
		// match generated random number to rashambo enterd by user for all cases
		if (Character.toUpperCase(uc.charAt(0)) == mr.charAt(0)) {
			System.out.println("Draw!");
		} else if (uc.equals("Paper") && mr.equals("Rock")) {
			System.out.println(player + " Wins!");
			playerWin++;
		} else if (mr.equals("Paper") && uc.equals("Rock")) {
			System.out.println(opponent + " Wins!");
			playerLoss++;
		} else if (uc.equals("Paper") && mr.equals("Scissors")) {
			System.out.println(opponent + " Wins!");
			playerLoss++;
		} else if (mr.equals("Paper") && uc.equals("Scissors")) {
			System.out.println(player + " Wins!");
			playerWin++;
		} else if (uc.equals("Scissors") && mr.equals("Rock")) {
			System.out.println(opponent + " Wins!");
			playerLoss++;
		} else if (mr.equals("Scissors") && uc.equals("Rock")) {
			System.out.println(player + " Wins!");
			playerWin++;
		}
		System.out.println("You have won " + playerWin + " times and loss " + playerLoss + " times.");
	}
}
