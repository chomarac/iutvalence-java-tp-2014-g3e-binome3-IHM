package fr.iutvalence.java.morpion;

import java.security.SecureRandom;
import java.util.Scanner;

import fr.iutvalence.java.morpion.erreur.CoordonneesDejaPriseException;
import fr.iutvalence.java.morpion.erreur.MauvaiseCoordonneesException;

/** Modélisation des différentes actions possibles lors d'une partie
 *
 * @author DELORME Loïc & BASSON Julien
 * @version 1.2
 */
public class Controleur
{
	/** La nombre de tour maximum pour une partie */
	private static final int NOMBREMAXDETOUR = 9;
	
	/** Le nombre qui détermine si la partie est gagnée */
	private static final int PARTIEGAGNEE = 2*NOMBREMAXDETOUR;
	
	/** Création du controleur de la partie */
	public Controleur()
	{
		PlateauJeu unPlateauJeu = new PlateauJeu();
		Vue uneVue = new Vue();
		uneVue.modificationNomsJoueurs();
		this.choixJoueurDebutantPartie();
		if (this.partie(unPlateauJeu) == PARTIEGAGNEE)
			uneVue.afficherVainqueur();
		else
		{
			if (this.partie(unPlateauJeu) == NOMBREMAXDETOUR)
				uneVue.afficherPartieNulle();
		}
		uneVue.choixRejouer();
	}
	
	/** Méthode permettant de choisir un joueur aléatoire pour débuter la partie */
	public void choixJoueurDebutantPartie()
	{
		SecureRandom nombresAleatoire = new SecureRandom();

		if ((nombresAleatoire.nextDouble()) >= 0.5)
			Joueurs.joueurCourant = Joueurs.player1;
		else
			Joueurs.joueurCourant = Joueurs.player2;
	}
	
	/** Méthode permettant de jouer une partie
	 * 
	 * @param unPlateauJeu Le plateau de jeu courant
	 * @return Le nombre de tours joués
	 */
	public int partie(PlateauJeu unPlateauJeu)
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
			
			System.out.println("\nC'est à " + Joueurs.joueurCourant.obtenirNom() + " de jouer (pion : " + pionJoueurCourant + ")");
			System.out.println(unPlateauJeu);
			
			System.out.print("Veuillez saisir la première coordonnée (entre 1 et 3 compris) : ");
			int choix1 = recuperationInformations.nextInt();
			System.out.print("Veuillez saisir la deuxième coordonnée (entre 1 et 3 compris) : ");
			int choix2 = recuperationInformations.nextInt();
			
			try
			{
				unPlateauJeu.estCoupValide(choix1, choix2);
				if (unPlateauJeu.placerPion(Joueurs.joueurCourant, choix1, choix2))
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
				System.out.println("\nLes coordonnées saisies sont déjà prises, veuillez en saisir des différentes.");
			}
			catch (MauvaiseCoordonneesException ignored)
			{
				System.out.println("\nLes coordonnées ne sont pas comprises entre 1 et 3.");
			}
		}
		
		return compteurDeTour;
	}
	
}
