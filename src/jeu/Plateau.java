/**
 * @author Gaut-vador
 */

package jeu;

import java.util.Random;

public class Plateau {

	int nbBombe;
	int size;
	int[][][] plateau;

	/**
	 * Constructor of the game, take the size of the square and the number of
	 * bombes.
	 * 
	 * @param size
	 * @param bombes
	 */
	public Plateau(int size, int bombes) {
		if (size > 0)
			this.size = size;
		else
			this.size = 10;

		plateau = new int[this.size][this.size][2];

		if (bombes > 0 && bombes < (this.size * this.size))
			this.nbBombe = bombes;
		else
			this.nbBombe = 10;

		this.putBombes();
		this.putHint();
		this.hide();
	}

	/**
	 * Add 0 in the third dimension of the array, mean this case is'nt show. 1
	 * mean the opposite.
	 */
	private void hide() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				plateau[i][j][1] = 0;
			}
		}
	}

	/**
	 * Put the numbers around the bombes as hints.
	 */
	private void putHint() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (plateau[i][j][0] != -1)
					plateau[i][j][0] = lookAround(i, j);
			}
		}
	}

	/**
	 * Return number of bombes around the given position (x and y parameters)
	 * 
	 * @param x
	 * @param y
	 * @return number of bombes
	 */
	private int lookAround(int x, int y) {
		int cpt = 0;
		for (int a = -1; a <= 1; a++) {
			for (int b = -1; b <= 1; b++) {
				if ((a + x >= 0 && a + x < size) && (b + y >= 0 && b + y < size)) {
					if (plateau[a + x][b + y][0] == -1)
						cpt++;
				}
			}
		}
		return cpt;
	}

	/**
	 * Put the bombes in the field.
	 */
	private void putBombes() {
		Random rng = new Random();
		int x;
		int y;
		int cpt = 0;

		while (cpt < nbBombe) {
			if (plateau[(x = rng.nextInt(size))][(y = rng.nextInt(size))][0] != -1) {
				plateau[x][y][0] = -1;
				cpt++;
			}
		}
	}

	/**
	 * Show bombes with a 'X', and the hints by there number.
	 */
	public String toString() {
		String res = "";
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (plateau[i][j][0] == -1)
					res += 'X';
				else
					res += plateau[i][j][0];
			}
			res += "\n";
		}
		return res;
	}

}
