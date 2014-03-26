package fr.iutvalence.java.morpion.vues.graphique.boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/** Modélisation du bouton "Quitter" de l'application */
public class BoutonQuitter implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		JOptionPane.showMessageDialog(null, "-------------------------------------------------\n"
										  + "-- Développé par Delorme Loïc et Basson Julien --\n"
										  + "--- Merci à Anthony Gelibert pour son aide ! ----\n"
										  + "-------------------------------------------------",
										  "Remerciements", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}
