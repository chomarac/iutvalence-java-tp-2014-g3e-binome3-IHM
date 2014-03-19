package fr.iutvalence.java.morpion;

import java.util.Scanner;

import fr.iutvalence.java.morpion.erreur.CoordonneesDejaPriseException;
import fr.iutvalence.java.morpion.erreur.MauvaiseCoordonneesException;

/** Modélisation des différentes actions possibles lors d'une partie
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.2 */
public class Controleur
{
	/** La nombre de tour maximum pour une partie */
	private static final int NOMBREMAXDETOUR = 9;

	/** Le nombre qui détermine si la partie est gagnée */
	private static final int PARTIEGAGNEE = 2 * Controleur.NOMBREMAXDETOUR;

	/** Modélisation d'un plateau de jeu */
	private final PlateauJeu unPlateauJeu;

	/** Modélisation d'une vue */
	private final VueConsole uneVue;
	
	/** Création du controleur de la partie */
	public Controleur()
	{
		this.unPlateauJeu = new PlateauJeu();
		this.uneVue = new VueConsole();
	}

	/** Permet de jouer une partie 
	 * @return true si le joueur veut rejouer une partie, false sinon */
	public boolean nouvellePartie()
	{
		/* XXX Déterminer le premier joueur. */
		if (this.partie(this.unPlateauJeu) == Controleur.PARTIEGAGNEE)
			this.uneVue.afficherVainqueur();
		else
			this.uneVue.afficherPartieNulle();

		return this.uneVue.choixRejouer();
	}

	/** Méthode permettant de jouer une partie
	 * 
	 * @param unPlateauJeu
	 *            Le plateau de jeu courant
	 * @return Le nombre de tours joués */
	private int partie(PlateauJeu unPlateauJeu)
	{
		Scanner recuperationInformations = new Scanner(System.in);
		int compteurDeTour = 0;

		while (compteurDeTour < Controleur.NOMBREMAXDETOUR)
		{
			String pionJoueurCourant;

			pionJoueurCourant = VueConsole.joueurActuel.obtenirSignature() == Joueur.SIGNATURE1 ? "X" : "O";

			System.out.printf("\nC'est à %s de jouer (pion : %s)%n", VueConsole.joueurActuel.obtenirNom(), pionJoueurCourant);
			System.out.println(unPlateauJeu);

			System.out.print("Veuillez saisir la première coordonnée (entre 1 et 3 compris) : ");
			int choix1 = recuperationInformations.nextInt();
			System.out.print("Veuillez saisir la deuxième coordonnée (entre 1 et 3 compris) : ");
			int choix2 = recuperationInformations.nextInt();

			try
			{
				unPlateauJeu.estCoupValide(choix1, choix2);
				if (unPlateauJeu.placerPion(VueConsole.joueurActuel, choix1, choix2))
				{
					System.out.println(unPlateauJeu);
					compteurDeTour = Controleur.PARTIEGAGNEE;
				}
				else
				{
					VueConsole.joueurActuel.joueurSuivant();
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
