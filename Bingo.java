
public class Bingo {
	Player[] noPlayers;

	// int pick;
	public Bingo(Player[] Player) {
		noPlayers = Player;

	}

	public String play(int number) {
		String winners = "";
		for (int i = 0; i < noPlayers.length; i++) {
			noPlayers[i].markNumber(number);
			if (noPlayers[i].isWinner() == true) {

				winners += noPlayers[i].getName() + " ";
			}

		}
		winners = winners.trim();
		return winners;
	}

}

class Player {
	Card[] classCards;
	String name;

	public Player(String name, Card[] cards) {
		this.name = name;
		this.classCards = cards;

	}

	public String getName() {
		return name;
	}

	public Card[] getCards() {
		return classCards;

	}

	public boolean isWinner() {
		int counter = 0;
		for (int z = 0; z < classCards.length; z++) {
			for (int i = 0; i < classCards[z].check.length; i++) {
//				System.out.println(i);

				for (int j = 0; j < classCards[z].check[i].length; j++) {
					if (classCards[z].check[i][j]) {
						// System.out.println(counter);
						counter++;

					}

				}
				if (counter == 5) {
					return true;
				} else {
					counter = 0;
				}
			}
		}
		return false;

	}

	public void markNumber(int number) {
		for (int i = 0; i < classCards.length; i++) {
			classCards[i].markNumber(number);
		}

	}
}

class Card {
	int[][] nom;
	boolean[][] check = new boolean[5][5];

	public Card(int[][] numbers) {
		this.nom = numbers;
	}

	public int getNumber(int Row, int Column) {
		return nom[Row][Column];

	}

	public boolean isMarked(int row, int column) {

		for (int i = 0; i < nom.length; i++) {
			for (int j = 0; j < nom[i].length; j++) {
				// System.out.print(check[i][j]);
				if (nom[i][j] == getNumber(row, column)) {

					return check[i][j] = true;
				}

			}
			// System.out.println();
		}
		// System.out.println();
		return false;

	}

	public void markNumber(int number) {
		for (int i = 0; i < nom.length; i++) {
			for (int j = 0; j < nom[i].length; j++) {
				if (nom[i][j] == number) {
					isMarked(i, j);
					getNumber(i, j);
				}
			}

		}

	}

}
