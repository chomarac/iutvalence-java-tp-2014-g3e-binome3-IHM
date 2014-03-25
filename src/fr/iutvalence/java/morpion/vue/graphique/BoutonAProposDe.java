package fr.iutvalence.java.morpion.vue.graphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/** Modélisation du bouton "A propos de" de l'application */
public class BoutonAProposDe implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JOptionPane.showMessageDialog(null, "Membres de l'équipe de développement : \n\n- BASSON Julien \n- DELORME Loïc \n\n Merci à Anthony Gelibert !",
									 "Auteurs", JOptionPane.INFORMATION_MESSAGE);
	}

}
