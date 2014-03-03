package fr.iutvalence.java.morpion;

/**
 * Modélisation d'un joueur.
 * <p>
 * Le joueur est composé des informations suivantes :
 * <ul>
 * <li>son nom</li>
 * <li>sa signature unique</li>
 * </ul>
 * </p>
 */
public class Joueurs
{
	/** Correspond au nom définitif du joueur pour une partie donnée. */
	private final String nomDuJoueur;
	
	/** Correspond à la signature unique du joueur pour une partie donnée. */
	private final int signature;

    /**
     * Retourne un nouveau joueur, de composantes données.
     *
     * @param nomJoueur la chaine de caractère du nom
     * @param signature l'entier unique
     */
    public Joueurs(String nomJoueur, int signature)
	{
		this.nomDuJoueur = nomJoueur;
		this.signature = signature;
	}

    /** Permet d'obtenir la signature de l'objet courant. */
    public int obtenirSignature()
	{
		return this.signature;
	}
	
	/** Permet d'obtenir le nom de l'objet courant. */
	public String obtenirNom()
	{
		return this.nomDuJoueur;
	}
}
