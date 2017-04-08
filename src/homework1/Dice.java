package homework1;

public class Dice {
	private int score;
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int rollDice() {
		return (int)(Math.random()*6)+1;
	}
}
