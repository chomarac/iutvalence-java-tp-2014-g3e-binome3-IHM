package fr.iutvalence.java.morpion;

/* TODO Ce n'est pas du tout ce que je pensais que vous alliez faire. */
/* TODO Ce n'est pas un héritier de Joueurs. C'est une classe à part entière dont Joueurs possède deux instances. */

/**
 * Modélisation d'un joueur par héritage de la classe Joueurs.
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.0
 * */
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
	
	/** Permet de modéliser un joueur avec des composantes pré-définies
	 * 
	 * @param nomJoueur le nom du joueur
	 * @param signature la signature du joueur */
	public Joueur(String nomJoueur, int signature)
	{
		super(nomJoueur, signature);
	}
}
