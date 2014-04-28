package fr.iutvalence.java.morpion.controleurs;

import javax.swing.JOptionPane;

import fr.iutvalence.java.morpion.modele.Joueurs;
import fr.iutvalence.java.morpion.modele.erreur.CoordonneesDejaPriseException;
import fr.iutvalence.java.morpion.modele.erreur.MauvaiseCoordonneesException;
import fr.iutvalence.java.morpion.modele.PlateauJeu;

/** Modélisation du fonctionnement d'une partie.
 *
 * @author DELORME Loïc & BASSON Julien
 * @version 2.0.0
 */
public class ControleurGraphique
{
    /** Un plateau de jeu. */
    private final PlateauJeu plateau;

    /** Joueurs de la partie. */
    private final Joueurs joueurs;
    
    /** Noms par défaut des différents joueurs. */
	private static final String[] JOUEURS_PAR_DEFAUT = { "Joueur 1", "Joueur 2" };

    /** Création du controleur de la partie. */
    public ControleurGraphique()
    {
        this.plateau = new PlateauJeu();
        this.joueurs = new Joueurs(JOUEURS_PAR_DEFAUT);
    }
    
    /** Tentative de placer un pion sur le plateau.
     * 
     * @param x La coordonnée en X.
     * @param y La coordonnée en Y.
     */
    public void placerPion(int x, int y)
    {
    	try
        {
            this.plateau.estCoupValide(x, y);
            if (this.plateau.placerPion(this.joueurs.obtenirSignatureCourante(), x, y))
            	JOptionPane.showMessageDialog(null, "Partie gagné !", "Fin de la partie.", JOptionPane.INFORMATION_MESSAGE);
            this.joueurs.joueurSuivant();
            
            if (!(this.plateau.coupPossible()))
            	JOptionPane.showMessageDialog(null, "Partie nulle !", "Fin de la partie.", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (CoordonneesDejaPriseException ignored)
        {
            // Rien.
        }
        catch (MauvaiseCoordonneesException ignored)
        {
            // Rien.
        }
    }
    
    /** Obtenir la signature du joueur courant.
     * 
     * @return La signature du joueur courant. */
    public String obtenirSignatureJoueurCourant()
    {
    	return (this.joueurs.obtenirSymboleJoueur());
    }
}
