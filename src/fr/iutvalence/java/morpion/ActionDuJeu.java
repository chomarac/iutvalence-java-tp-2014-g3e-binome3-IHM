package fr.iutvalence.java.morpion;

import java.security.SecureRandom;
import java.util.Scanner;

import fr.iutvalence.java.morpion.erreur.CoordonneesDejaPriseException;
import fr.iutvalence.java.morpion.erreur.MauvaiseCoordonneesException;

/** Modélisation des différentes actions possibles lors d'une partie
 *
 * @author DELORME Loïc & BASSON Julien
 * @version 0.9
 */
public class ActionDuJeu
{
	/** La nombre de tour maximum pour une partie */
	private static final int NOMBREMAXDETOUR = 9;
	
	/** Le nombre qui détermine si la partie est gagnée */
	private static final int PARTIEGAGNEE = 2*NOMBREMAXDETOUR;

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
	
	/** Méthode permettant de choisir un joueur aléatoire pour débuter la partie */
	public void choixJoueurDebutantPartie()
	{
		/* TODO Vous pouvez simplifier cette affectation (à discuter en TP). */
		SecureRandom nombresAleatoire = new SecureRandom();

		if ((nombresAleatoire.nextDouble()) >= 0.5)
			Joueurs.joueurCourant = Joueurs.player1;
		else
			Joueurs.joueurCourant = Joueurs.player2;
	}
	
	/** Méthode permettant de jouer une partie
	 * 
	 * @param unPlateauJeu Le plateau de jeu courant
	 */
	public void partie(PlateauJeu unPlateauJeu)
	{
		@SuppressWarnings("resource")
		Scanner recuperationInformations = new Scanner(System.in);
		int compteurDeTour = 0;

		while (compteurDeTour < NOMBREMAXDETOUR)
		{
			String pionJoueurCourant;
			
			if (Joueurs.joueurCourant.obtenirSignature() == Joueurs.SIGNATURE1)
				pionJoueurCourant = "X";
			else
				pionJoueurCourant = "O";
			
			System.out.println("C'est à " + Joueurs.joueurCourant.obtenirNom() + " de jouer (pion : " + pionJoueurCourant + ").");
			System.out.println(unPlateauJeu);
			
			System.out.println("Veuillez saisir la première coordonnée (entre 1 et 3 compris) :");
			int choix1 = recuperationInformations.nextInt();
			System.out.println("Veuillez saisir la deuxième coordonnée (entre 1 et 3 compris) :");
			int choix2 = recuperationInformations.nextInt();
			
			try
			{
				unPlateauJeu.estCoupValide(choix1, choix2);
				if (unPlateauJeu.placerPionSurPlateau(Joueurs.joueurCourant, choix1, choix2))
				{
					System.out.println(unPlateauJeu);
					compteurDeTour = PARTIEGAGNEE;
				}
				else
				{
					if (Joueurs.joueurCourant.equals(Joueurs.player1))
						Joueurs.joueurCourant = Joueurs.player2;
					else
						Joueurs.joueurCourant = Joueurs.player1;

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

		afficherVictoire(compteurDeTour);
	}
	
	/** Méthode permettant de connaître le vainqueur d'une partie ou si celle-ci est nulle
	 * 
	 * @param nbTours Le nombre de tours joués lors de la partie
	 */
	public void afficherVictoire(int nbTours)
	{
		if (nbTours == PARTIEGAGNEE)
			System.out.println("La partie est remportée par " + Joueurs.joueurCourant.obtenirNom());
		else
			System.out.println("Partie nulle. Il n'y a pas de vainqueur.");
	}
}
