package fr.iutvalence.java.morpion;

import java.util.Scanner;

/**
 * Lance le jeu
 */
public class uneApplication
{
	/**
	 * Permet de lancer le jeu.
	 */
	public static void main(String[] args)
	{
        /* TODO Où est la classe Jouer ? */
		Jouer unePartie = new Jouer();
		unePartie.jouer();
		
		Scanner recuperationInformation = new Scanner(System.in);
		System.out.println("Voulez-vous rejouer une partie ? (O/N)");
		String reponse = recuperationInformation.nextLine();

        /* TODO Il doit manquer une boucle... */
		if ("O".equals(reponse))
			unePartie.rejouer();
	}
}
