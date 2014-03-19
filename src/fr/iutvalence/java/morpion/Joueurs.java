package fr.iutvalence.java.morpion;

import java.security.SecureRandom;

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
	
	/** Un objet qui contiendra le joueur courant */
	public Joueurs joueurCourant;

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
	
	/** Détermine le premier joueur 
	 * @return le joueur qui va débuter la partie */
	public Joueurs determinerPremierJoueur()
	{
		return (this.joueurCourant = new SecureRandom().nextBoolean() ? VueConsole.player1 : VueConsole.player2);
	}
	
	/** Détermine le joueur suivant 
	 * @return le joueur opposé */
	public Joueurs joueurSuivant()
	{
		return (this.joueurCourant.equals(VueConsole.player1) ? VueConsole.player2 : VueConsole.player1);
	}
}
