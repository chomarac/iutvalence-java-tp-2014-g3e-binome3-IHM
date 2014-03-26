package fr.iutvalence.java.morpion.vue.graphique.boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/** Modélisation du bouton "Règle du jeu" de l'application */
public class BoutonReglesDuJeu implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JOptionPane.showMessageDialog(null, "Le jeu du morpion est un jeu de réflexion qui se pratique à deux."
										  + "\nChaque joueur possède un symbole différent ('X' ou 'O') et le but est de créer un alignement de 3 symboles."
										  + "\nLe premier joueur qui a aligné 3 symboles a gagné."
										  , "Règle du jeu", JOptionPane.INFORMATION_MESSAGE);
	}

}
