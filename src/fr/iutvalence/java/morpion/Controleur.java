package fr.iutvalence.java.morpion;

import fr.iutvalence.java.morpion.erreur.CoordonneesDejaPriseException;
import fr.iutvalence.java.morpion.erreur.MauvaiseCoordonneesException;

import java.util.Scanner;

/**
 * Modélisation du fonctionnement d'une partie.
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.2.0
 */
public class Controleur
{
	/** Le nombre de tour maximum pour une partie. */
	private static final int NOMBREMAXDETOUR = 9;

	/** Le nombre qui détermine si la partie est gagnée. */
	private static final int PARTIEGAGNEE = 2 * Controleur.NOMBREMAXDETOUR;

	/** Un plateau de jeu */
	private final PlateauJeu plateau;

    /* TODO Créer une interface pour VueConsole ? */
    /** Une vue. */
    private final VueConsole vue;

    /** Création du controleur de la partie. */
    public Controleur() {
        this.plateau = new PlateauJeu();
        this.vue = new VueConsole();
        /* TODO Ca n'a rien à faire ici. */
        nouvellePartie();
    }

    /**
     * Jouer une partie.
     *
     * @return true si le joueur veut rejouer une partie, false sinon.
     */
    public boolean nouvellePartie() {
        Joueurs.determinerPremierJoueur();
        /* TODO Pourquoi est-ce que partie ne renvoie pas simplement un booléen ? */
        if (this.partie(this.plateau) == Controleur.PARTIEGAGNEE)
            this.vue.afficherVainqueur();
        else this.vue.afficherPartieNulle();

        return this.vue.choixRejouer();
    }

    /**
     * Permet de jouer une partie.
     *
     * @param plateau Le plateau de jeu courant
     * @return Le nombre de tours joués
     */
    private int partie(PlateauJeu plateau)
	{
		Scanner scanner = new Scanner(System.in);
		int compteurDeTour = 0;

		while (compteurDeTour < Controleur.NOMBREMAXDETOUR)
		{
            String pionJoueurCourant = (Joueurs.joueurCourant.obtenirSignature() == Joueur.SIGNATURE1) ? "X" : "O";
            /* TODO Tous ces printf n'ont rien à faire ici. */
            System.out.printf("\nC'est à %s de jouer (pion : %s)%n", Joueurs.joueurCourant.obtenirNom(), pionJoueurCourant);
			System.out.println(plateau);

            /* TODO Pensez à traiter les Exceptions de nextInt() */
			System.out.print("Veuillez saisir la première coordonnée (entre 1 et 3 compris) : ");
			int choix1 = scanner.nextInt();
			System.out.print("Veuillez saisir la deuxième coordonnée (entre 1 et 3 compris) : ");
			int choix2 = scanner.nextInt();

			try
			{
				plateau.estCoupValide(choix1, choix2);
				if (plateau.placerPion(Joueurs.joueurCourant, choix1, choix2))
				{
					System.out.println(plateau);
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
		scanner.close();
		return compteurDeTour;
	}

}
