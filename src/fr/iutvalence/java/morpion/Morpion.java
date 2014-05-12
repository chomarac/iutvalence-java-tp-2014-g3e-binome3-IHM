package fr.iutvalence.java.morpion;

import javax.swing.SwingUtilities;

import fr.iutvalence.java.morpion.ihm.Fenetre;

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
		
			/*ControleurConsole unControleurConsole;
			boolean choixVue = false;
			
			if ((args.length > 0) && args[0].equals("--ansi"))
				choixVue = true;
			
			do
			{
				unControleurConsole = new ControleurConsole(choixVue);
			}
			while (unControleurConsole.nouvellePartie());*/
			
			SwingUtilities.invokeLater(new Fenetre());
	}
}
