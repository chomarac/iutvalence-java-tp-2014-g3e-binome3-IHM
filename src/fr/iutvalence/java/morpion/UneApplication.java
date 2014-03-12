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
		
		jouer();
		
		while (true)
		{			
			System.out.println("\nVoulez-vous rejouer une partie ? (O/N)");
			String reponse = choixDePoursuite.nextLine();

			if ("O".equals(reponse))
				rejouer();
			else
				if ("N".equals(reponse))
				{
					quitter();
					break;
				}
				else
					System.out.println("Veuillez saisir une lettre valide.\n");
		}
	}
	
	/** Permet jouer une partie */
	public static void jouer()
	{
		PlateauJeu unPlateauJeu = new PlateauJeu();
		Controlleur uneAction = new Controlleur();
		uneAction.modificationNomsJoueurs();
		uneAction.choixJoueurDebutantPartie();
		uneAction.partie(unPlateauJeu);
	}
	
	/** Permet de lancer une nouvelle partie */
	public static void rejouer()
	{
		jouer();
	}
	
	/** Permet de quitter l'application */
	public static void quitter()
	{
		System.out.println("-------------------------------------------------");
		System.out.println("-- Développé par Delorme Loïc et Basson Julien --");
		System.out.println("--- Merci à Anthony Gelibert pour son aide ! ----");
		System.out.println("-------------------------------------------------");
	}
}
