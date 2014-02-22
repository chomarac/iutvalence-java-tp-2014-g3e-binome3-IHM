/* TODO Améliorez vos JavaDoc ! On se doute que "Joueurs.java" contient la classe "Joueurs" ! */
/**
 * Classe Joueurs
 * @author Loic
 */
public class Joueurs {
	
	private final String nameOfPlayer;

	private final int signature;
	
	/**
	 * Retourne un nouveau joueur, de composantes données 
	 * @param playerName la chaine de caractère du nom
	 * @param signature l'entier unique
	 */
	public Joueurs(String playerName, int signature)
	{
		this.nameOfPlayer = playerName;
		this.signature = signature;
	}
}
