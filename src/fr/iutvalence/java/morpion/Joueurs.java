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
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.0
 */
public class Joueurs
{
	/** Correspond au nom définitif du joueur pour une partie donnée. */
	private final String nomDuJoueur;
	
	/** Correspond à la signature unique du joueur pour une partie donnée. */
	private final int signature;
	
	/** Le nom par défaut du joueur 1 */
	public static final String JOUEUR1 = "Joueur 1";

	/** Le nom par défaut du joueur 2 */
	public static final String JOUEUR2 = "Joueur 2";
	
	/** La signature par défaut du joueur 1 */
	public static final int SIGNATURE1 = 5;

	/** La signature par défaut du joueur 2 */
	public static final int SIGNATURE2 = -SIGNATURE1;
	
    /** Un objet qui contiendra toutes les informations relatives à player1 */
	public static Joueurs player1 = null;

    /** Un objet qui contiendra toutes les informations relatives à player2 */
	public static Joueurs player2 = null;
	
	/** Un objet qui contiendra le joueur courant */
	public static Joueurs joueurCourant;

    /** Retourne un nouveau joueur, de composantes données.
     *
     * @param nomJoueur la chaine de caractère du nom
     * @param signature l'entier unique
     */
    public Joueurs(String nomJoueur, int signature)
	{
		this.nomDuJoueur = nomJoueur;
		this.signature = signature;
	}

    /** Permet d'obtenir la signature de l'objet courant.
     * 
     * @return La signature du joueur courant
     */
    public int obtenirSignature()
	{
		return this.signature;
	}
	
	/** Permet d'obtenir le nom de l'objet courant. 
	 *
	 * @return Le nom du joueur courant
	 */
	public String obtenirNom()
	{
		return this.nomDuJoueur;
	}
}
