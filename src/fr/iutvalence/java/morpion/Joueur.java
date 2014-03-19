package fr.iutvalence.java.morpion;

/** Modélisation d'un joueur */
public class Joueur extends Joueurs
{
	/** Le nom par défaut du joueur 1 */
	public static final String JOUEUR1 = "Joueur 1";

	/** Le nom par défaut du joueur 2 */
	public static final String JOUEUR2 = "Joueur 2";
	
	/** La signature par défaut du joueur 1 */
	public static final int SIGNATURE1 = 5;

	/** La signature par défaut du joueur 2 */
	public static final int SIGNATURE2 = -SIGNATURE1;
	
	/** Permet de créer un joueur
	 * 
	 * @param nomJoueur le nom du joueur
	 * @param signature la signature du joueur */
	public Joueur(String nomJoueur, int signature)
	{
		super(nomJoueur, signature);
	}

}
