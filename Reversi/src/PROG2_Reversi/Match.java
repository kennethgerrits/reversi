package PROG2_Reversi;

import java.util.Scanner;

public class Match {
	private Scanner scanner;
	private int matchPoint;
	private Player playerOne;
	private Player playerTwo;
	private Game game;

	public Match() {
		scanner = new Scanner(System.in);
		startMatch();
	}

	public void setMatchPoint(int matchPoint) {
		this.matchPoint = matchPoint;
		System.out.println(String.format("Got it, %s is set as matchpoint", matchPoint));
	}

	/**
	 * Configures all data required for a match to begin. Then, start games till a
	 * player hits matchpoint.
	 * 
	 * @return void
	 */
	private void startMatch() {
		configureMatchPoint();
		configurePlayers();

		while (true) {
			playerOne.incrementWin();
			System.out.println(String.format("Score: %s - %d", playerOne.getWins(), playerTwo.getWins()));
			if (playerOne.getWins() == matchPoint || playerTwo.getWins() == matchPoint) {
				Player winner = playerOne.getWins() > playerTwo.getWins() ? playerOne : playerTwo;
				System.out.println(String.format("Congratulations %s, you won!", winner.getName()));
				System.out.println("Thank you for playing!");
				break;
			} else {
				startNewGame();
			}
		}
	}

	/**
	 * Configures the matchpoint (amount of games a player needs to win a match).
	 * 
	 * @return void
	 */
	private void configureMatchPoint() {
		System.out.println("Victories needed to win the match (1-9) :");
		while (true) {
			if (scanner.hasNextInt()) {
				int targetMatchPoint = scanner.nextInt();
				if (targetMatchPoint > 0 && targetMatchPoint < 10) {
					setMatchPoint(targetMatchPoint);
					break;
				}
			} else {
				System.out.println("Oh no! That's not going to work. Please choose a different matchpoint.");
				scanner.next();
			}
		}
	}

	/**
	 * Creates the players. If the matchpoint is even, playerOne will start with
	 * white, else with black.
	 * 
	 * @return void
	 */
	private void configurePlayers() {
		if (isEven(matchPoint)) {
			playerOne = new Player(StoneColor.WHITE);
			playerTwo = new Player(StoneColor.BLACK);
		} else {
			playerOne = new Player(StoneColor.BLACK);
			playerTwo = new Player(StoneColor.WHITE);
		}

		System.out.println("Enter name player one:");
		String playerOneName = scanner.next();
		playerOne.setName(playerOneName);

		System.out.println("Enter name player two:");
		String playerTwoName = scanner.next();
		playerTwo.setName(playerTwoName);
	}

	private void startNewGame() {
		game = new Game(playerOne, playerTwo);
		game.play();
	}

	private boolean isEven(int number) {
		return (number % 2 == 0 ? true : false);
	}
}
