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
			/* Attention : l'interface graphique n'est pas encore aboutie. */
			new VueGraphique();
		}
		else
		{
			ControleurConsole unControleurConsole;
			boolean choixVue = false;
			
			if ((args.length > 0) && args[0].equals("--ainsi"))
			{
				choixVue = true;
			}
			
			do
			{
				unControleurConsole = new ControleurConsole(choixVue);
			}
			while (unControleurConsole.nouvellePartie());
		}
	}
}
