package fr.iutvalence.java.morpion.ihm;

import fr.iutvalence.java.morpion.modele.Joueur;

/** 
 * 
 * @author ANDRE & CHOMARAT
 * @version 1.0
 */
public interface InterfaceIHM {
	
	public void placerPion(int ligne, int colonne, Joueur joueur);
	
	public void victoire(Joueur joueur);
	
	public void nul();
}
