
public class CoupleCoordonnees
{
	private static int firstCoordinates;

	private static int secondCoordinates;
	
	/**
	 * Retourne un nouveau couple de coordonnées de composantes données 
	 * @param firstCoordinates
	 * @param secondCoordinates
	 */
	public CoupleCoordonnees(int coordonnee1, int coordonnee2)
	{
		this.firstCoordinates = coordonnee1;
		this.secondCoordinates = coordonnee2;
	}
	
	/**
	 * Permet d'obtenir la première coordonnée de l'objet courant
	 * @return la première coordonnée
	 */
	public int obtenirPremiereCoordonnee()
	{
		return this.firstCoordinates;
	}
	
	/**
	 * Permet d'obtenir la deuxième coordonnée de l'objet courant
	 * @return la deuxième coordonnée
	 */
	public int obtenirDeuxiemeCoordonnee()
	{
		return this.secondCoordinates;
	}

}
