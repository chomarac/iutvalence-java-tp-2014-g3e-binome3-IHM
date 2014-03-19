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
	/** Nom définitif du joueur pour une partie donnée */
	private final String nomDuJoueur;
	
	/** Signature unique du joueur pour une partie donnée */
	private final int signature;
	
	/** Contient le joueur courant */
	public static Joueurs joueurCourant;

    /** Retourne un nouveau joueur avec des composantes données.
     *
     * @param nomJoueur la chaine de caractère du nom
     * @param signature l'entier unique */
    public Joueurs(String nomJoueur, int signature)
	{
		this.nomDuJoueur = nomJoueur;
		this.signature = signature;
	}

    /** Obtenir la signature d'un joueur courant.
     * 
     * @return La signature du joueur courant */
    public int obtenirSignature()
	{
		return this.signature;
	}
	
	/** Obtenir le nom d'un joueur courant. 
	 *
	 * @return Le nom du joueur courant */
	public String obtenirNom()
	{
		return this.nomDuJoueur;
	}
	
	/** Détermine le premier joueur 
	 * 
	 * @return le joueur qui va débuter la partie */
	public static Joueurs determinerPremierJoueur()
	{
		return (joueurCourant = new SecureRandom().nextBoolean() ? VueConsole.player1 : VueConsole.player2);
	}
	
	/** Détermine le joueur suivant
	 * 
	 * @return le joueur opposé */
	public static Joueurs joueurSuivant()
	{
		return (joueurCourant = (joueurCourant.equals(VueConsole.player1)) ? VueConsole.player2 : VueConsole.player1);
	}
}
