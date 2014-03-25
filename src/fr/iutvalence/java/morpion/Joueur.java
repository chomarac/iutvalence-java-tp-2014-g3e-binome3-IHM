package fr.iutvalence.java.morpion;

/* TODO Ce n'est pas du tout ce que je pensais que vous alliez faire. */
/* TODO Ce n'est pas un héritier de Joueurs. C'est une classe à part entière dont Joueurs possède deux instances. */

/**
 * Modélisation d'un joueur par héritage de la classe Joueurs.
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.0
 * */
public final class Joueur
{
    /** Nom. */
    private final String nom;

    /** Signature. */
    private final int signature;

    /** Permet de modéliser un joueur avec des composantes pré-définies
     *
     * @param nom le nom du joueur
     * @param signature la signature du joueur */
    public Joueur(final String nom, final int signature) {
        this.nom = nom;
        this.signature = signature;
    }

    public String nom() {
        return nom;
    }

    public int signature() {
        return signature;
    }

    @Override
    public String toString() {
        return String.format("Joueur{m_nom='%s', m_signature=%d}", nom, signature);
    }
}
