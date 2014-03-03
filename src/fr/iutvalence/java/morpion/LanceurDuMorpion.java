package fr.iutvalence.java.morpion;

import java.util.Random;
import java.util.Scanner;

import fr.iutvalence.java.morpion.erreur.CoordonneesDejaPriseException;
import fr.iutvalence.java.morpion.erreur.MauvaiseCoordonneesException;

/**
 * Modélisation de l'execution du jeu.
 */
public class LanceurDuMorpion
{

	/**
	 * Le nom par défaut du joueur 1
	 */
	private static final String JOUEUR1 = "Joueur 1";

	/**
	 * Le nom par défaut du joueur 2
	 */
	private static final String JOUEUR2 = "Joueur 2";

	/**
	 * La signature par défaut du joueur 1
	 */
	private static final int SIGNATURE1 = 5;

	/**
	 * La signature par défaut du joueur 2
	 */
	private static final int SIGNATURE2 = -SIGNATURE1;

	/**
	 * La nombre de tour maximum pour une partie
	 */
	private static final int NOMBREMAXDETOUR = 9;

	/**
	 * Permet de lancer le jeu.
	 */
	public static void main(String[] args)
	{
		PlateauJeu unPlateauJeu = new PlateauJeu();

		Scanner recuperationInformation = new Scanner(System.in);

		Joueurs player1 = null;
		Joueurs player2 = null;
		Joueurs joueurCourant;

		//Demande de choix des noms des joueurs
		while (true)
		{
			System.out.println("Voulez-vous modifier les noms de Joueur 1 et Joueur 2 (O/N)");
			String choix = recuperationInformation.nextLine();

			if ("N".equals(choix))
			{
				player1 = new Joueurs(JOUEUR1, SIGNATURE1);
				player2 = new Joueurs(JOUEUR2, SIGNATURE2);
				break;
			}

			if ("O".equals(choix))
			{
				while (player1 == player2)
				{
					System.out.println("Veuillez entrer le nom du joueur 1 : ");
					String namePlayer1 = recuperationInformation.nextLine();
					System.out.println("Veuillez entrer le nom du joueur 2 : ");
					String namePlayer2 = recuperationInformation.nextLine();

					if (namePlayer1.equals(namePlayer2))
						System.out.println("Veuillez saisir des noms différents.\n");
					else
					{
						player1 = new Joueurs(namePlayer1, SIGNATURE1);
						player2 = new Joueurs(namePlayer2, SIGNATURE2);
					}
				}
				break;
			}
			System.out.println("Veuillez saisir une lettre valide.\n");
		}

		//On détermine quel joueur va débuter la partie
		Random nombresAleatoire = new Random();
		double nombre = nombresAleatoire.nextDouble();

		if (nombre >= 0.5)
		{
			System.out.println(player1.obtenirNom() + " va débuter le premier");
			joueurCourant = player1;
		}
		else
		{
			System.out.println(player2.obtenirNom() + " va débuter le premier");
			joueurCourant = player2;
		}

		// Début de la partie
		int compteurDeTour = 0;

		while (compteurDeTour < NOMBREMAXDETOUR)
		{
			//On demande les coordonnées au joueur courant
			System.out.println("C'est à " + joueurCourant.obtenirNom() + " de jouer.");
			System.out.println(unPlateauJeu);
			
			System.out.println("Veuillez saisir la première coordonnée (entre 1 et 3 compris) :");
			int choix1 = recuperationInformation.nextInt();
			System.out.println("Veuillez saisir la deuxième coordonnée (entre 1 et 3 compris) :");
			int choix2 = recuperationInformation.nextInt();
			
			CoupleCoordonnees choixCoordonneesJoueur = new CoupleCoordonnees(choix1, choix2);
			
			try
			{
				unPlateauJeu.verificationDuChoix(choixCoordonneesJoueur);
				if (unPlateauJeu.ModificationDuPlateau(joueurCourant, choixCoordonneesJoueur) == true)
				{
					System.out.println(unPlateauJeu);
					compteurDeTour = 2*NOMBREMAXDETOUR;
				}
				else
				{					
					if (joueurCourant == player1)
						joueurCourant = player2;
					else
						joueurCourant = player1;
					
					compteurDeTour += 1;
				}
			}
			catch (CoordonneesDejaPriseException e)
			{
				System.out.println("Les coordonnées saisies sont déjà prises, veuillez en saisir des différentes.");
				System.out.println(unPlateauJeu);
			}
			catch (MauvaiseCoordonneesException e)
			{
				System.out.println("Les coordonnées ne sont pas comprises entre 1 et 3.");
				System.out.println(unPlateauJeu);
			}
		}
		
		//On affiche le résultat final
		if (compteurDeTour == (2*NOMBREMAXDETOUR))
			System.out.println("La partie est remportée par " + joueurCourant.obtenirNom());
		else
			System.out.println("Partie nulle. Il n'y a pas de vainqueur.");
	}
}
