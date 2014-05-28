package fr.iutvalence.java.morpion.ihm;

import fr.iutvalence.java.morpion.modele.Joueur;
import fr.iutvalence.java.morpion.modele.Joueurs;
import fr.iutvalence.java.morpion.modele.PlateauJeu;

/** 
 * 
 * @author ANDRE & CHOMARAT
 * @version 1.0
 */
public class ControleurIHM implements InteragirGrille {
	private Joueurs joueurs;
	private PlateauJeu plateau;
	

	public Joueur obtenirJoueurCourant(){
		return(joueurs.obtenirJoueurCourant());

	}

}