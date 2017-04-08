package homework1;

public class DiceRoll {

	public static void main(String[] args) {
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		
		dice1.setScore(dice1.rollDice());
		dice2.setScore(dice2.rollDice());
		
		while (dice1.getScore() != dice2.getScore()) {
			dice1.setScore(dice1.rollDice());
			dice2.setScore(dice2.rollDice());
			System.out.println("Dice 1: " + dice1.getScore());
			System.out.println("Dice 2: " + dice2.getScore());
			System.out.println();
			if (dice1.getScore() == dice2.getScore()) {
				System.out.println("2 dices have the same score");
				break;
			}
		}
	}

}
