package fr.iutvalence.java.morpion;

import java.security.SecureRandom;

/** Gestionnaire des joueurs.
 *
 * @author DELORME Loïc & BASSON Julien
 * @version 2.0.0 */
public final class Joueurs
{
    /** Premier joueur. */
    private final Joueur joueur1;

    /** Deuxième joueur. */
    private final Joueur joueur2;

    /** Joueur courant */
    private Joueur joueurCourant;

    /** Créer les deux joueurs de la partie en utilisant les noms spécifiés.
     *
     * @param joueurs Noms des deux joueurs (ATTENTION, le tableau doit contenir deux entrées) */
    public Joueurs(final String[] joueurs)
    {
        assert joueurs.length == 2 : "Tentative de création d'un gestionnaire avec moins de deux joueurs";

        this.joueur1 = new Joueur(joueurs[0], PlateauJeu.SIGNATURE_JOUEUR1);
        this.joueur2 = new Joueur(joueurs[1], PlateauJeu.SIGNATURE_JOUEUR2);
        determinerPremierJoueur();
    }

    /** Déterminer le premier joueur. */
    private void determinerPremierJoueur()
    {
        this.joueurCourant = new SecureRandom().nextBoolean() ? this.joueur1 : this.joueur2;
    }

    /** Détermine le joueur suivant. */
    public void joueurSuivant()
    {
        this.joueurCourant = (this.joueurCourant.equals(this.joueur1)) ? this.joueur2 : this.joueur1;
    }

    /** Obtenir la signature d'un joueur courant.
     * 
     * @return La signature du joueur courant.*/
    public int obtenirSignatureCourante()
    {
        return this.joueurCourant.obtenirSignature();
    }

    /** Obtenir le nom d'un joueur courant. 
     * 
     * @return Le nom du joueur courant. */
    public String obtenirNomCourant()
    {
        return this.joueurCourant.obtenirNom();
    }
}
