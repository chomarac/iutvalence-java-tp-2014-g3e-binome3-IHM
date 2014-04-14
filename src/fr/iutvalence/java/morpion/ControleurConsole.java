package fr.iutvalence.java.morpion;

import fr.iutvalence.java.morpion.modele.Joueurs;
import fr.iutvalence.java.morpion.modele.erreur.CoordonneesDejaPriseException;
import fr.iutvalence.java.morpion.modele.erreur.MauvaiseCoordonneesException;
import fr.iutvalence.java.morpion.modele.PlateauJeu;
import fr.iutvalence.java.morpion.vues.VueConsole;

/** Modélisation du fonctionnement d'une partie.
 *
 * @author DELORME Loïc & BASSON Julien
 * @version 2.0.0
 */
public class ControleurConsole
{
    /** Un plateau de jeu. */
    private final PlateauJeu plateau;
    
    /** La vue de la partie. */
    private final VueConsole vue;
    
    /** Les joueurs de la partie. */
    private final Joueurs joueurs;

    /** Création du controleur de la partie. */
    public ControleurConsole()
    {
        this.plateau = new PlateauJeu();
        this.vue = new VueConsole();
        this.joueurs = new Joueurs(this.vue.demanderNomsJoueurs());
    }

    /** Jouer une partie.
     *
     * @return True si le joueur veut rejouer une partie, false sinon. */
    public boolean nouvellePartie()
    {
        if (this.partie(this.plateau))
        {
        	this.vue.afficherVainqueur(this.joueurs.obtenirNomCourant());
        }
        else
        {
        	this.vue.afficherPartieNulle();
        }
        
        return this.vue.choixRejouer();
    }

    /** Permet de controler le déroulement d'une partie.
     *
     * @param plateau Le plateau de jeu courant.
     * @return True si la partie est gagné et false si la partie est nulle. */
    private boolean partie(PlateauJeu plateau) 
    {
        while (plateau.coupPossible())
        {
        	this.vue.debuterUnTour(this.joueurs.obtenirNomCourant(), this.joueurs.obtenirSymboleJoueur());
            this.vue.afficherPlateauCourant(this.plateau.toString());
            final int[] tableauDesChoix = this.vue.demanderCoordonnees();

            try
            {
                plateau.estCoupValide(tableauDesChoix[0], tableauDesChoix[1]);
                if (plateau.placerPion(this.joueurs.obtenirSignatureCourante(), tableauDesChoix[0], tableauDesChoix[1]))
                {
                	this.vue.afficherPlateauCourant(this.plateau.toString());
                    return true;
                }
                this.joueurs.joueurSuivant();
            }
            catch (final CoordonneesDejaPriseException ignored)
            {
                this.vue.coordonneesDejaPrise();
            }
            catch (final MauvaiseCoordonneesException ignored)
            {
                this.vue.mauvaisesCoordonnees();
            }
        }
        return false;
    }
}
