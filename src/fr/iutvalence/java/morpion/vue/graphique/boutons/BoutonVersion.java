package fr.iutvalence.java.morpion.vue.graphique.boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/** Modélisation du bouton "Version" de l'application */
public class BoutonVersion implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JOptionPane.showMessageDialog(null, "Nom : Morpion"
				+ "\nVersion : 1.0"
				+ "\nSite : www.iut-valence.fr"
				+ "\nContact : Loic.Delorme@iut-valence.fr & Julien.Basson@iut-valence.fr"
				+ "\nLicence : Ce programme est distribué selon les termes de la version GNU General Public License 3"
				, "Version", JOptionPane.INFORMATION_MESSAGE);
	}

}
