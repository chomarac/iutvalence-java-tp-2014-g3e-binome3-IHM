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
		Scanner recuperationInformation = new Scanner(System.in);
		
		Jouer unePartie = new Jouer();
		unePartie.jouer();

		while (true)
		{
			System.out.println("Voulez-vous rejouer une partie ? (O/N)");
			String reponse = recuperationInformation.nextLine();

			if ("O".equals(reponse))
			{
				unePartie.rejouer();
				break;
			}
			else
				if ("N".equals(reponse))
				{
					unePartie.quitter();
					break;
				}
			System.out.println("Veuillez saisir une lettre valide.\n");
		}
	}
}
