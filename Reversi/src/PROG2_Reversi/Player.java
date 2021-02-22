package PROG2_Reversi;

public class Player {
	private String name;
	private StoneColor stoneColor;
	private int wins;
	private char symbol;

	public Player(StoneColor stoneColor) {
		setStoneColor(stoneColor);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.length() == 0) {
			System.out.println("Your name must be atleast 1 character long.");
			return;
		}
		this.name = name;
		System.out.println(String.format("Welcome %s!", name));
	}

	public StoneColor getStoneColor() {
		return stoneColor;
	}

	public void setStoneColor(StoneColor stoneColor) {
		if (stoneColor == StoneColor.WHITE) {
			setSymbol('O');
		} else {
			setSymbol('X');
		}
		this.stoneColor = stoneColor;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public void incrementWin() {
		wins++;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
}
