package fr.iutvalence.java.morpion;

/**
 * La classe Joueurs permet de créer de nouveaux objets de type Joueurs,
 * avec des composantes définies en fonction des choix de l'utilisateur.
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
	
	/**
	 * Permet d'obtenir la signature de l'objet courant
	 * @return la signature
	 */
	public int obtenirSignature()
	{
		return this.signature;
	}
	
	/**
	 * Permet d'obtenir le nom de l'objet courant
	 * @return le nom
	 */
	public String obtenirNom()
	{
		return this.nameOfPlayer;
	}
}
