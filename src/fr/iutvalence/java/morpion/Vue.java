package fr.iutvalence.java.morpion;

import java.util.Scanner;

/** Modélisation d'une vue */
public class Vue
{
	/** Méthode permettant de demander à l'utilisateur si il veut changer le nom des joueurs */
	public void modificationNomsJoueurs()
	{
		@SuppressWarnings("resource")
		Scanner recuperationInformation = new Scanner(System.in);
		
		while (true)
		{
			System.out.println("Voulez-vous modifier les noms de Joueur 1 et Joueur 2 (O/N)");
			String choix = recuperationInformation.nextLine();

			if ("N".equals(choix))
			{
				Joueurs.player1 = new Joueurs(Joueurs.JOUEUR1, Joueurs.SIGNATURE1);
				Joueurs.player2 = new Joueurs(Joueurs.JOUEUR2, Joueurs.SIGNATURE2);
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
						Joueurs.player1 = new Joueurs(namePlayer1, Joueurs.SIGNATURE1);
						Joueurs.player2 = new Joueurs(namePlayer2, Joueurs.SIGNATURE2);
						break;
					}
				}
				break;
			}
			System.out.println("Veuillez saisir une lettre valide.\n");
		}
	}
	
	/** Méthode permettant d'afficher le vainqueur */
	public void afficherVainqueur()
	{
		System.out.println("La partie est remportée par " + Joueurs.joueurCourant.obtenirNom());
	}
	
	/** Méthode permettant d'afficher une partie nulle */
	public void afficherPartieNulle()
	{
		System.out.println("Partie nulle. Il n'y a pas de vainqueur.");
	}
	
	/** Méthode permettant de demander aux joueurs si ils veulent rejouer */
	public void choixRejouer()
	{
		while (true)
		{			
			@SuppressWarnings("resource")
			Scanner choixDePoursuite = new Scanner(System.in);
			
			System.out.println("\nVoulez-vous rejouer une partie ? (O/N)");
			String reponse = choixDePoursuite.nextLine();

			if ("O".equals(reponse))
				new Controleur();
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
	
	/** Permet de quitter l'application */
	public void quitter()
	{
		System.out.println("-------------------------------------------------");
		System.out.println("-- Développé par Delorme Loïc et Basson Julien --");
		System.out.println("--- Merci à Anthony Gelibert pour son aide ! ----");
		System.out.println("-------------------------------------------------");
	}

}
