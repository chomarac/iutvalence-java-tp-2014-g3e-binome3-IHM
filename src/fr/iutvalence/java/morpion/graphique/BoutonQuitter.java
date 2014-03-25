package fr.iutvalence.java.morpion.graphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Modélisation du bouton "Quitter" de l'application */
public class BoutonQuitter implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}

}
