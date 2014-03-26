package fr.iutvalence.java.morpion;

import fr.iutvalence.java.morpion.erreur.CoordonneesDejaPriseException;
import fr.iutvalence.java.morpion.erreur.MauvaiseCoordonneesException;
import fr.iutvalence.java.morpion.vues.VueConsole;

/** Modélisation du fonctionnement d'une partie.
 *
 * @author DELORME Loïc & BASSON Julien
 * @version 2.0.0 */
public class Controleur
{


    /** Un plateau de jeu. */
    private final PlateauJeu plateau;

    /* TODO Qu'entendez vous par interface ? */
    /** Une vue. */
    private final VueConsole vue;

    /** Joueurs. */
    private final Joueurs joueurs;

    /** Création du controleur de la partie. */
    public Controleur()
    {
        this.plateau = new PlateauJeu();
        this.vue = new VueConsole();
        this.joueurs = new Joueurs(this.vue.demanderNomsJoueurs());
    }

    /** Jouer une partie.
     *
     * @return true si le joueur veut rejouer une partie, false sinon. */
    public boolean nouvellePartie()
    {
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
        int compteurDeTour = 0;

        while (compteurDeTour < this.plateau.obtenirNombreDeToursMax())
        {
        	this.vue.debuterUnTour(this.joueurs.obtenirNomCourant(), this.joueurs.obtenirSymboleJoueur());
            this.vue.afficherPlateauCourant(this.plateau.toString());
            int[] tableauDesChoix = this.vue.demanderCoordonnees();

            try
            {
                plateau.estCoupValide(tableauDesChoix[0], tableauDesChoix[1]);
                if (plateau.placerPion(this.joueurs.obtenirSignatureCourante(), tableauDesChoix[0], tableauDesChoix[1]))
                {
                	this.vue.afficherPlateauCourant(this.plateau.toString());
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
