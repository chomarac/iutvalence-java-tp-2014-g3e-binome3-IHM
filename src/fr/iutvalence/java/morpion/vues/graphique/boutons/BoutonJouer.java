package fr.iutvalence.java.morpion.vues.graphique.boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.iutvalence.java.morpion.Controleur;


/** Modélisation du bouton permettant de lancer le jeu
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.0 */
public class BoutonJouer implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Controleur controleur;
        
        do
        {
            controleur = new Controleur();
        } while (controleur.nouvellePartie());
	}

}
