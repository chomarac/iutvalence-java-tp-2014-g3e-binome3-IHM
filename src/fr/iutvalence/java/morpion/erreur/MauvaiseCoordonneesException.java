package fr.iutvalence.java.morpion.erreur;

/**
 * Permet de soulever une exception lorsque les coordonnées saisies sont invalides
 */
public class MauvaiseCoordonneesException extends Exception
{
	/**
	 * On renvoie un message personnalisé
	 * @param message
	 */
	public MauvaiseCoordonneesException(String message)
	{
		super(message);
	}

}
