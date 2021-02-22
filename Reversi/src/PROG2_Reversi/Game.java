package PROG2_Reversi;

import java.util.Scanner;

public class Game {
	private Player playerOne;
	private Player playerTwo;
	private Player currentPlayer;
	private Board board;
	private Scanner scanner;

	public Game(Player playerOne, Player playerTwo) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		currentPlayer = playerOne;
		board = new Board();
		scanner = new Scanner(System.in);
	}

	/**
	 * Handles the gameplay of 1 game.
	 * 
	 * @return void
	 */
	public void play() {
		while (true) {
			if (hasWinner())
				break;
			board.draw();

			handleMove(currentPlayer);

		}
	}

	private boolean hasWinner() {
		return false;
	}

	/**
	 * Handles the player input for making a move. If move is valid, switch to the
	 * other user.
	 * 
	 * @return void
	 */
	private void handleMove(Player currentPlayer) {
		System.out.println(String.format("%s (%s) your move:", currentPlayer.getName(), currentPlayer.getSymbol()));
		while (true) {
			String key = scanner.next();
			boolean validMove = board.setSymbol(key, currentPlayer.getSymbol());
			if (validMove)
				break;
		}
		switchCurrentPlayer();
	}

	/**
	 * Switch the current player with the other player (waiting in queue).
	 * 
	 * @return void
	 */
	private void switchCurrentPlayer() {
		currentPlayer = currentPlayer.getStoneColor() == playerOne.getStoneColor() ? playerTwo : playerOne;
	}
}
