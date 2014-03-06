package fr.iutvalence.java.morpion;

import fr.iutvalence.java.morpion.erreur.CoordonneesDejaPriseException;
import fr.iutvalence.java.morpion.erreur.MauvaiseCoordonneesException;

import java.security.SecureRandom;
import java.util.Scanner;

/**
 * Permet de gérer l'intégralité du jeu (début, rejouer, fin)
 */
public class Jouer
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
	public static final int SIGNATURE1 = 5;

	/**
	 * La signature par défaut du joueur 2
	 */
	public static final int SIGNATURE2 = -SIGNATURE1;

	/**
	 * Un objet qui contiendra toutes les informations relatives à player1
	 */
	private static Joueurs player1 = null;

	/**
	 * Un objet qui contiendra toutes les informations relatives à player2
	 */
	private static Joueurs player2 = null;
	
	/**
	 * Un objet qui contiendra le joueur courant
	 */
	private static Joueurs joueurCourant;

	/**
	 * La nombre de tour maximum pour une partie
	 */
	private static final int NOMBREMAXDETOUR = 9;
	
	/**
	 * Le nombre qui détermine si la partie est gagnée
	 */
	private static final int PARTIEGAGNEE = 2*NOMBREMAXDETOUR;

	/**
	 * L'objet qui va permettre de récupérer les entrées au clavier
	 */
	Scanner recuperationInformation = new Scanner(System.in);

	/**
	 * Permet lancer une partie
	 */
	public void jouer()
	{
		PlateauJeu unPlateauJeu = new PlateauJeu();

		while (true)
		{
			System.out.println("Voulez-vous modifier les noms de Joueur 1 et Joueur 2 (O/N)");
			String choix = this.recuperationInformation.nextLine();

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
					String namePlayer1 = this.recuperationInformation.nextLine();
					System.out.println("Veuillez entrer le nom du joueur 2 : ");
					String namePlayer2 = this.recuperationInformation.nextLine();

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

		// On détermine quel joueur va débuter la partie
		SecureRandom nombresAleatoire = new SecureRandom();

		if ((nombresAleatoire.nextDouble()) >= 0.5)
			joueurCourant = player1;
		else
			joueurCourant = player2;

		// Début de la partie
		int compteurDeTour = 0;

		while (compteurDeTour < NOMBREMAXDETOUR)
		{
			String pionJoueurCourant;
			
			if (joueurCourant.obtenirSignature() == Jouer.SIGNATURE1)
				pionJoueurCourant = "X";
			else
				pionJoueurCourant = "O";
			
			System.out.println("C'est à " + joueurCourant.obtenirNom() + " de jouer (pion : " + pionJoueurCourant + ").");
			System.out.println(unPlateauJeu);
			
			System.out.println("Veuillez saisir la première coordonnée (entre 1 et 3 compris) :");
			int choix1 = this.recuperationInformation.nextInt();
			System.out.println("Veuillez saisir la deuxième coordonnée (entre 1 et 3 compris) :");
			int choix2 = this.recuperationInformation.nextInt();
			
			try
			{
				unPlateauJeu.verificationDuChoix(choix1, choix2);
				if (unPlateauJeu.modificationDuPlateau(joueurCourant, choix1, choix2))
				{
					System.out.println(unPlateauJeu);
					compteurDeTour = PARTIEGAGNEE;
				}
				else
				{
					if (joueurCourant.equals(player1))
						joueurCourant = player2;
					else
						joueurCourant = player1;

					compteurDeTour += 1;
				}
			}
			catch (CoordonneesDejaPriseException ignored)
			{
				System.out.println("Les coordonnées saisies sont déjà prises, veuillez en saisir des différentes.");
				System.out.println(unPlateauJeu);
			}
			catch (MauvaiseCoordonneesException ignored)
			{
				System.out.println("Les coordonnées ne sont pas comprises entre 1 et 3.");
				System.out.println(unPlateauJeu);
			}
		}

		// On affiche le résultat final
		if (compteurDeTour == PARTIEGAGNEE)
			System.out.println("La partie est remportée par " + joueurCourant.obtenirNom());
		else
			System.out.println("Partie nulle. Il n'y a pas de vainqueur.");
	}
	
	/**
	 * Permet de lancer une nouvelle partie
	 */
	public void rejouer()
	{
		this.jouer();
	}
	
	/**
	 * Permet de quitter l'application
	 */
	public void quitter()
	{
		System.out.println("-------------------------------------------------");
		System.out.println("-- Développé par Delorme Loïc et Basson Julien --");
		System.out.println("--- Merci à Anthony Gelibert pour son aide ! ----");
		System.out.println("-------------------------------------------------");
	}
}
