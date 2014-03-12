package fr.iutvalence.java.morpion;

import java.util.Scanner;

/** Permet d'executer l'application
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.0
 */
public class UneApplication
{
	/** Permet de lancer le jeu. */
	public static void main(String[] args)
	{
		Scanner choixDePoursuite = new Scanner(System.in);
		
		Jouer unePartie = new Jouer();
		unePartie.jouer();
		
		while (true)
		{			
			System.out.println("\nVoulez-vous rejouer une partie ? (O/N)");
			String reponse = choixDePoursuite.nextLine();

			if ("O".equals(reponse))
				unePartie.rejouer();
			else
				if ("N".equals(reponse))
				{
					unePartie.quitter();
					break;
				}
				else
					System.out.println("Veuillez saisir une lettre valide.\n");
		}
	}
}
