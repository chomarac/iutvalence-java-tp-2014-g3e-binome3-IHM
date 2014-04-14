package fr.iutvalence.java.morpion;

import fr.iutvalence.java.morpion.vues.graphique.VueGraphique;

/** Permet d'executer l'application.
 * 
 * @author DELORME Loïc & BASSON Julien
 * @version 1.5
 */
public class Morpion
{

	/** Permet de lancer le jeu.
	 * 
	 * @param args
	 *            args. */
	public static void main(String[] args)
	{
		if ((args.length > 0) && args[0].equals("--gui"))
		{
			new VueGraphique();
		}
		else
		{
			ControleurConsole unControleurConsole;

			do
			{
				unControleurConsole = new ControleurConsole();
			}
			while (unControleurConsole.nouvellePartie());
		}
	}
}
