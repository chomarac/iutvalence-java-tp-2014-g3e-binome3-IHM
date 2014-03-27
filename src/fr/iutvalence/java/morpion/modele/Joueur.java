package fr.iutvalence.java.morpion.modele;

/** Modélisation d'un joueur par son nom et sa signature.
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 2.0.0 */
public final class Joueur
{
	/** Nom. */
	private final String nom;

	/** Signature. */
	private final int signature;

	/** Permet de modéliser un joueur avec des composantes pré-définies.
	 * 
	 * @param nom
	 *            Le nom du joueur.
	 * @param signature
	 *            La signature du joueur. */
	public Joueur(final String nom, final int signature)
	{
		this.nom = nom;
		this.signature = signature;
	}

	/** Obtenir le nom du joueur.
	 * 
	 * @return Le nom du joueur. */
	public String obtenirNom()
	{
		return this.nom;
	}

	/** Obtenir la signature du joueur.
	 * 
	 * @return La signature du joueur. */
	public int obtenirSignature()
	{
		return this.signature;
	}

	@Override
	public String toString()
	{
		return String.format("Joueur{m_nom='%s', m_signature=%d}", this.nom, this.signature);
	}
}
