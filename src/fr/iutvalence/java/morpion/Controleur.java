package fr.iutvalence.java.morpion;

import java.util.Scanner;

import fr.iutvalence.java.morpion.erreur.CoordonneesDejaPriseException;
import fr.iutvalence.java.morpion.erreur.MauvaiseCoordonneesException;

/** Modélisation des différentes actions possibles lors d'une partie
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.2
 * */
public class Controleur
{
	/** La nombre de tour maximum pour une partie */
	private static final int NOMBREMAXDETOUR = 9;

	/** Le nombre qui détermine si la partie est gagnée */
	private static final int PARTIEGAGNEE = 2 * Controleur.NOMBREMAXDETOUR;

	/** Un plateau de jeu */
	private final PlateauJeu unPlateauJeu;

	/** Une vue */
	private final VueConsole uneVue;
	
	/** Création du controleur de la partie */
	public Controleur()
	{
		this.unPlateauJeu = new PlateauJeu();
		this.uneVue = new VueConsole();
		nouvellePartie();
	}

	/** Jouer une partie
	 * 
	 * @return true si le joueur veut rejouer une partie, false sinon */
	public boolean nouvellePartie()
	{
		Joueurs.determinerPremierJoueur();
		if (this.partie(this.unPlateauJeu) == Controleur.PARTIEGAGNEE)
			this.uneVue.afficherVainqueur();
		else
			this.uneVue.afficherPartieNulle();
		
		return (this.uneVue.choixRejouer());
	}

	/** Permet de jouer une partie
	 * 
	 * @param unPlateauJeu Le plateau de jeu courant
	 * @return Le nombre de tours joués */
	private int partie(PlateauJeu unPlateauJeu)
	{
		Scanner recuperationInformations = new Scanner(System.in);
		int compteurDeTour = 0;

		while (compteurDeTour < Controleur.NOMBREMAXDETOUR)
		{
			String pionJoueurCourant;

			pionJoueurCourant = (Joueurs.joueurCourant.obtenirSignature() == Joueur.SIGNATURE1) ? "X" : "O";

			System.out.printf("\nC'est à %s de jouer (pion : %s)%n", Joueurs.joueurCourant.obtenirNom(), pionJoueurCourant);
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
					compteurDeTour = Controleur.PARTIEGAGNEE;
				}
				else
				{
					Joueurs.joueurSuivant();
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

		recuperationInformations.close();
		return compteurDeTour;
	}

}
