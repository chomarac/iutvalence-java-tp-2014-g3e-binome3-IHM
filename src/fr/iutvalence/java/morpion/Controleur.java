package fr.iutvalence.java.morpion;

import fr.iutvalence.java.morpion.erreur.CoordonneesDejaPriseException;
import fr.iutvalence.java.morpion.erreur.MauvaiseCoordonneesException;

import java.util.Scanner;

/** Modélisation du fonctionnement d'une partie.
 *
 * @author DELORME Loïc & BASSON Julien
 * @version 2.0 */
public class Controleur
{
	
    /** Le nombre de tour maximum pour une partie. */
    private static final int NOMBREMAXDETOUR = 9;

    /** Le nombre qui détermine si la partie est gagnée. */
    private static final int PARTIEGAGNEE = 2 * Controleur.NOMBREMAXDETOUR;

    /** Un plateau de jeu. */
    private final PlateauJeu plateau;

    /** Une vue. */
    private final VueMorpion vue;

    /** Joueurs. */
    private final Joueurs joueurs;

    /** Création du controleur de la partie. */
    public Controleur()
    {
        this.plateau = new PlateauJeu();
        this.vue = new VueMorpion();
        this.joueurs = new Joueurs(this.vue.demanderNomsJoueurs());
    }

    /** Jouer une partie.
     *
     * @return true si le joueur veut rejouer une partie, false sinon. */
    public boolean nouvellePartie()
    {
        if (this.partie(this.plateau))
            this.vue.afficherVainqueur(this.joueurs.obtenirNomCourant());
        else
        	this.vue.afficherPartieNulle();

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
            /* TODO Tous ces printf n'ont rien à faire ici. */
            System.out.printf("\nC'est à %s de jouer (pion : %s)%n", joueurs.obtenirNomCourant(), joueurs.obtenirSignatureCourante());
            System.out.println(plateau);

            /* TODO Pensez à traiter les Exceptions de nextInt() */
            System.out.print("Veuillez saisir la première coordonnée (entre 1 et 3 compris) : ");
            int choix1 = scanner.nextInt();
            System.out.print("Veuillez saisir la deuxième coordonnée (entre 1 et 3 compris) : ");
            int choix2 = scanner.nextInt();

            try
            {
                plateau.estCoupValide(choix1, choix2);
                if (plateau.placerPion(this.joueurs, choix1, choix2))
                {
                    System.out.println(plateau);
                    return true;
                }
                else
                {
                    this.joueurs.joueurSuivant();
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
        return false;
    }
}
