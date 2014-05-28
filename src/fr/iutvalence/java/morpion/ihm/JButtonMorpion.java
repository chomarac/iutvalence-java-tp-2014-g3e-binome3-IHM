package fr.iutvalence.java.morpion.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.iutvalence.java.morpion.modele.Joueurs;
import fr.iutvalence.java.morpion.modele.PlateauJeu;

/** Redéfinition des boutons.
 * 
 * @author ANDRE & CHOMARAT
 * @version 1.0
 */
public class JButtonMorpion extends JButton implements ActionListener {
	
	private int coordonneesX ;
	private int coordonneesY;
	private InterfaceIHM ihm;
	private InteragirGrille grille;
	private ControleurIHM controleur;
	private PlateauJeu plateau;
	
	public JButtonMorpion (int x, int y, InterfaceIHM ihm, InteragirGrille controleur){
		this.coordonneesX = x ;
		this.coordonneesY = y ;
		this.ihm = ihm;
		this.grille = controleur;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.ajouterSymboleBouton();
	}

	private void ajouterSymboleBouton() {
		if(this.controleur.obtenirJoueurCourant().obtenirSignature() == PlateauJeu.SIGNATURE_JOUEUR_1)
			this.setText(PlateauJeu.SYMBOLE_JOUEUR_1);
		else
			this.setText(PlateauJeu.SYMBOLE_JOUEUR_2);
		
	}
	
	
}
