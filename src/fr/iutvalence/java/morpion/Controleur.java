package fr.iutvalence.java.morpion;

import fr.iutvalence.java.morpion.erreur.CoordonneesDejaPriseException;
import fr.iutvalence.java.morpion.erreur.MauvaiseCoordonneesException;
import fr.iutvalence.java.morpion.vue.console.VueMorpion;

import java.util.Scanner;

/** Modélisation du fonctionnement d'une partie.
 *
 * @author DELORME Loïc & BASSON Julien
 * @version 2.0.0 */
public class Controleur
{
	/* TODO Je me demande si la notion de fin de partie ne devrait pas être fournie par le plateau ? */
    /** Le nombre de tour maximum pour une partie. */
    private static final int NOMBREMAXDETOUR = 9;

    /** Un plateau de jeu. */
    private final PlateauJeu plateau;

    /* TODO Encore une fois, je pense qu'une interface VueConsole (à défaut d'un meilleur nom) aurait du sens. */
    /** Une vue. */
    private final VueMorpion vue;

    /** Joueurs. */
    private final Joueurs joueurs;

    /** Création du controleur de la partie. */
    public Controleur() {
        this.plateau = new PlateauJeu();
        this.vue = new VueMorpion();
        this.joueurs = new Joueurs(this.vue.demanderNomsJoueurs());
    }

    /** Jouer une partie.
     *
     * @return true si le joueur veut rejouer une partie, false sinon. */
    public boolean nouvellePartie() {
        if (this.partie(this.plateau))
            this.vue.afficherVainqueur(this.joueurs.obtenirNomCourant());
        else this.vue.afficherPartieNulle();

        return this.vue.choixRejouer();
    }

    /** Permet de jouer une partie.
     *
     * @param plateau Le plateau de jeu courant.
     * @return True si la partie est gagné et false si la partie est nulle. */
    private boolean partie(PlateauJeu plateau) 
    {
        Scanner scanner = new Scanner(System.in);
        int compteurDeTour = 0;

        while (compteurDeTour < Controleur.NOMBREMAXDETOUR)
        {
        	this.vue.estAJoueurDeJouer(this.joueurs);
            /* TODO Encore un println ici ! À déplacer dans l'appel à la vue (mais ça va complexifier les choses). */
            System.out.println(plateau);

            /* TODO Pensez à traiter les Exceptions de nextInt() */
            this.vue.demandePremiereCoordonnee();
            int choix1 = scanner.nextInt();
            this.vue.demandeDeuxiemeCoordonnee();
            int choix2 = scanner.nextInt();

            try
            {
                plateau.estCoupValide(choix1, choix2);
                if (plateau.placerPion(this.joueurs, choix1, choix2))
                {
                    /* TODO Encore un println ici ! À déplacer dans l'appel à la vue. */
                    System.out.println(plateau);
                    return true;
                }
                this.joueurs.joueurSuivant();
                compteurDeTour += 1;
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
        return false;
    }
}
