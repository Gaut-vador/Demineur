package jeu;

import java.util.Random;

public class Plateau {

	int nbBombe;
	int size;
	int[][] plateau;

	public Plateau(int size, int bombes) {
		this.size = size;
		this.nbBombe = bombes;

		plateau = new int[size][size];

		this.putBombes();
		this.putHint();
	}

	private void putHint() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (plateau[i][j] != -1)
					plateau[i][j] = lookAround(i, j);
			}
		}

	}

	private int lookAround(int i, int j) {
		int cpt = 0;
		for (int a = -1; a <= 1; a++) {
			for (int b = -1; b <= 1; b++) {
				if ((a + i >= 0 && a + i < size) && (b + j >= 0 && b + j < size)) {
					if (plateau[a + i][b + j] == -1)
						cpt++;
				}
			}
		}
		return cpt;
	}

	private void putBombes() {
		Random rng = new Random();
		int x;
		int y;
		int cpt = 0;

		while (cpt < nbBombe) {
			if (plateau[(x = rng.nextInt(size))][(y = rng.nextInt(size))] != -1) {
				plateau[x][y] = -1;
				cpt++;
			}
		}
	}

	public String toString() {
		String res = "";
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (plateau[i][j] == -1)
					res += 'X';
				else
					res += plateau[i][j];
			}
			res += "\n";
		}
		return res;
	}

}
