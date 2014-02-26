package fr.iutvalence.java.morpion.erreur;

/**
 * Permet de soulever une exception lorsque la case est déjà occupée
 */
public class CoordonneesDejaPriseException extends Exception {
	
	/**
	 * On renvoie un message personnalisé
	 * @param message
	 */
	public CoordonneesDejaPriseException(String message)
	{
		super(message);
	}
}
