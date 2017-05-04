/**
 * @author Gaut-vador <a href="mailto:gauthier.pirlet@gmail.com?Subject=Demineur" target="_top"></a>
 */
package main;

import jeu.Plateau;

public class Main {

	public static void main(String[] args) {
		
		Plateau p = new Plateau(10, 10);
		
		System.out.println(p.toString());
	}
}
