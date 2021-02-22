package PROG2_Reversi;

import java.util.HashMap;

public class Board {
	private HashMap<String, Square> squares;
	private final int BOARD_SIZE;
	private final char EMPTY_SPOT;

	public Board() {
		squares = new HashMap<String, Square>();
		BOARD_SIZE = 8;
		EMPTY_SPOT = '.';
		init();
	}

	/**
	 * Prints the current state of the board.
	 * 
	 * @return void
	 */
	public void draw() {
		System.out.println("+---------------------+");
		System.out.println("|   a b c d e f g h   |");

		for (int number = 1; number <= BOARD_SIZE; number++) {
			System.out.print(String.format("| %s ", number));
			for (char letter = 'a'; letter <= 'h'; letter++) {
				String key = String.valueOf(letter) + number;
				System.out.print(squares.get(key).getSymbol());
				System.out.print(" ");
			}
			System.out.print(String.format("%s |", number));

			System.out.println();
		}

		System.out.println("|   a b c d e f g h   |");
		System.out.println("+---------------------+");
	}

	/**
	 * Creates the starting layout of the board.
	 * 
	 * @return void
	 */
	private void init() {
		for (int number = 1; number <= BOARD_SIZE; number++) {
			for (char letter = 'a'; letter <= 'h'; letter++) {
				String key = String.valueOf(letter) + number;
				squares.put(key, new Square());
			}
		}
		setSymbol("d4", 'O');
		setSymbol("e5", 'O');
		setSymbol("e4", 'X');
		setSymbol("d5", 'X');
	}

	/**
	 * Sets a symbol on the grid.
	 * 
	 * @return boolean if move was successful.
	 */
	public boolean setSymbol(String key, char symbol) {
		if (validMove(key)) {
			squares.get(key).setSymbol(symbol);
			return true;
		}
		return false;
	}

	/**
	 * Checks if the incoming move is valid, if not give according error message.
	 * 
	 * @return boolean if move is valid.
	 */
	private boolean validMove(String key) {
		if (!squares.containsKey(key)) {
			System.out.println("Invalid move: field does not exist.");
			return false;
		}
		if (squares.get(key).getSymbol() != EMPTY_SPOT) {
			System.out.println("Invalid move: field already taken.");
			return false;
		}
		return true;
	}
}
