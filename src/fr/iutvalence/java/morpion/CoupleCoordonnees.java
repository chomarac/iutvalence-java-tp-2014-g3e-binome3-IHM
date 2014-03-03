package fr.iutvalence.java.morpion;

/* TODO Je suis toujours très sceptique sur l'utilité de cette classe. */
/**
 * Modélisation d'un couple de coordonnées.
 * <p>
 * Modélisation par deux valeurs entières.
 * </p>
 */
public class CoupleCoordonnees
{

	/**
	 * La valeur entière correspondant à la première coordonnée du couple
	 * de coordonnée
	 */
	private static int premiereCoordonnee;

	/**
	 * La valeur entière correspondant à la deuxième coordonnée du couple
	 * de coordonnée
	 */
	private static int deuxiemeCoordonnee;

	/**
	 * Retourne un nouveau couple de coordonnées de composantes données
	 * @param premiereCoordonnee
	 * @param deuxiemeCoordonnee
	 */
	public CoupleCoordonnees(int coordonnee1, int coordonnee2)
	{
		//On retourne un nouveau couple de coordonnees avec les composantes suivantes : coordonnee1 et coordonnee2
		this.premiereCoordonnee = coordonnee1;
		this.deuxiemeCoordonnee = coordonnee2;
	}

	/**
	 * Permet d'obtenir la première coordonnée de l'objet courant
	 * @return la première coordonnée
	 */
	public int obtenirPremiereCoordonnee()
	{
		//On retourne la première coordonnée du couple courant
		return this.premiereCoordonnee;
	}

	/**
	 * Permet d'obtenir la deuxième coordonnée de l'objet courant
	 * @return la deuxième coordonnée
	 */
	public int obtenirDeuxiemeCoordonnee()
	{
		//On retourne la deuxième coordonnée du couple courant
		return this.deuxiemeCoordonnee;
	}

}
