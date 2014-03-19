package fr.iutvalence.java.morpion;

import java.util.Scanner;

/** Modélisation d'une vue 
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.0
 * */
public class VueConsole
{
    /** Un objet qui contiendra toutes les informations relatives à player1 */
	public static Joueur player1;

    /** Un objet qui contiendra toutes les informations relatives à player2 */
	public static Joueur player2;
	
	/** Modélisation d'une vue en mode console */
	public VueConsole()
	{
		modificationNomsJoueurs();
	}
	
	/** Permet de demander aux utilisateurs si ils veulent changer le nom des joueurs */
	public void modificationNomsJoueurs()
	{
		Scanner recuperationInformation = new Scanner(System.in);
		
		while (true)
		{
			System.out.println("Voulez-vous modifier les noms de Joueur 1 et Joueur 2 (O/N)");
			String choix = recuperationInformation.nextLine();

			if ("N".equals(choix))
			{
				player1 = new Joueur(Joueur.JOUEUR1, Joueur.SIGNATURE1);
				player2 = new Joueur(Joueur.JOUEUR2, Joueur.SIGNATURE2);
				break;
			}

			if ("O".equals(choix))
			{
				while (true)
				{
					System.out.println("Veuillez entrer le nom du joueur 1 : ");
					String namePlayer1 = recuperationInformation.nextLine();
					System.out.println("Veuillez entrer le nom du joueur 2 : ");
					String namePlayer2 = recuperationInformation.nextLine();

					if (namePlayer1.equals(namePlayer2))
						System.out.println("Veuillez saisir des noms différents.\n");
					else
					{
						player1 = new Joueur(namePlayer1, Joueur.SIGNATURE1);
						player2 = new Joueur(namePlayer2, Joueur.SIGNATURE2);
						break;
					}
				}
				break;
			}
			System.out.println("Veuillez saisir une lettre valide.\n");
		}
	}
	
	/** Message à afficher lorsqu'il y a un vainqueur */
	public void afficherVainqueur()
	{
		System.out.printf("La partie est remportée par %s%n", Joueurs.joueurCourant.obtenirNom());
	}
	
	/** Méthode permettant d'afficher une partie nulle */
	public void afficherPartieNulle()
	{
		System.out.println("\nPartie nulle. Il n'y a pas de vainqueur.");
	}
	
	/** Permet de demander aux joueurs si ils veulent rejouer une partie
	 * 
	 * @return true si le joueur veut rejouer une partie, false sinon */
	public boolean choixRejouer()
	{
		while (true)
		{		
			Scanner choixDePoursuite = new Scanner(System.in);
			/* TODO L'application plante à cette étape. Essayé avec le debugger sans succès.. L'erreur intervient subitement */
			System.out.println("\nVoulez-vous rejouer une partie ? (O/N)");
			String reponse = choixDePoursuite.nextLine();

			if ("O".equals(reponse))
				return true;
			else
				if ("N".equals(reponse))
				{
					quitter();
					return false;
				}
				else
					System.out.println("Veuillez saisir une lettre valide.\n");
		}
	}
	
	/** Message à afficher lorsqu'on quitte l'application */
	public void quitter()
	{
		System.out.println("-------------------------------------------------");
		System.out.println("-- Développé par Delorme Loïc et Basson Julien --");
		System.out.println("--- Merci à Anthony Gelibert pour son aide ! ----");
		System.out.println("-------------------------------------------------");
	}

}
