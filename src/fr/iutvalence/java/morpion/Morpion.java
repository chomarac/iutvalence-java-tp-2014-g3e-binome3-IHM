package fr.iutvalence.java.morpion;

import fr.iutvalence.java.morpion.vues.graphique.Controleur2;
import fr.iutvalence.java.morpion.vues.graphique.VueGraphique;

/** Permet d'executer l'application.
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.2 */
public class Morpion
{

	/** Permet de lancer le jeu.
	 * 
	 * @param args
	 *            args. */
	public static void main(String[] args)
	{
		/*if ((args.length > 0) && args[0].equals("--gui"))
		{
			new VueGraphique();
		}
		else
		{
			Controleur controleur;

			do
			{
				controleur = new Controleur();
			}
			while (controleur.nouvellePartie());
		}*/
		//Controleur2 unControleur = new Controleur2();
		
		new VueGraphique();
	}
}
